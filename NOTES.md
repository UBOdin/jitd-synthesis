Overview
---------

A Just-in-Time Data Structure is defined by a jitd.spec.Definition.  As of right now, we don't
have a parser, so definitions need to be implemented by hand.  You can see an example in 
jitd.example.KeyValueJITD.  

Before proceeding forward, please read our [Concept Paper](https://odin.cse.buffalo.edu/papers/2015/CIDR-jitd-final.pdf)

#### Anatomy of a JITD definition

* **Node**: A data structure building block: A name and a set of typed fields.  This is analogous to a structure definition in Thrift or CapnProto
* **Accessor**: A block of code used to compute one or more properties of the structure (e.g., size or a key lookup).
    * **args**: Parameters  (e.g., a key to look up)
    * **ret**: Return parameters (e.g., a pre-allocated record object)
    * **lookups**: Blocks of code, one per node type.  Code may include references to the fields of the node type.  All node types *must* be defined.
    * **returnType**: Type of the literal returned by the operation
* **Mutator**: A block of code used to insert new data into the JITD.  Uses a ConstructorPattern to define the structure of the new JITD root.
* **Transform**: A block of code that defines a *from* pattern and a *to* pattern.  Can be used to replace instances of *from* with the mapped instance of *to*
* **Policy**: A set of heuristics for which transforms to apply when/where (see below)

A definition may also include:
* **keyType**: The C++ type of keys
* **recordType**: The C++ type of records
* **includes**: A list of C++ header files to include

keyType and recordType *must* be comparable ('<', '>', and '==' must be overridden).

#### Anatomy of a Policy

To be written

--------------------------------------------------------------------------------------

Design Choices
---------------

#### Policies in General

To start, let's define an organizational TODO as a node and a transform to apply to it.  At any
given moment, there might be a large number of TODOs available.  A policy defines a set of rules for prioritizing TODOs.  In the default setting, with one background thread doing reorganization, the policy repeatedly tells the background thread which TODO to apply.  

#### Comparing TODOs

The first question is how does the policy chose which of two TODOs is better?  

###### Score-Based

Each TODO is assigned a score (e.g., based on its anticipated performance improvement)

###### Transform-Tiered

Most transforms already organize themselves into a nice tiered structure.  For example, in the KV-JITD, you generally want to Crack first, then Sort, then Merge.  In this approach, Sort always ranks below Crack, so you can keep them separate.  This has the advantage of needing to compare fewer transforms.

###### Other?

The above comparison strategies are *local*: They only consider the benefit of a TODO in the context of that one node.  It's likely that we'll also need to consider strategies that require global context, for example to keep overall performance bounded.  We're holding off on these strategies for the time being.


#### TODOs as Graph Queries

A transform can only be applied to specific nodes.  For example, the example MergeBTree transform is only applicable to a node of the form:
~~~
BTree(
  SortedArray(...),
  sep,
  SortedArray(...)
)
~~~
If you think of the JITD as a directed graph (with field names identifying triples, and isa defining the node type), this is analogous to the SparQL query:
~~~
SELECT ?root, ?lhs, ?rhs
WHERE ?root  isa  BTree
      ?root  lhs  ?lhs
      ?lhs   isa  SortedArray
      ?root  rhs  ?rhs
      ?rhs   isa  SortedArray
ORDER BY mergebtree_score(?root, ?lhs, ?rhs)
LIMIT 1
~~~
More generally, with the scoring/tiered approaches discussed above, a policy is in effect, repeatedly querying for the Top-1 result based on the scoring function.  The question then is how do we efficiently answer this query?  A few design considerations follow:

###### Naive Enumeration

The naive implementation of a policy would be to answer each query by traversing the JITD structure and repeatedly computing the score of each node in turn.  Since (ideally) the scores don't change drastically with each modification to the structure, this approach results in a lot of wasted computation.  However, it also requires no additional storage overhead.

###### Proactive Incremental-Maintenance

A second option is to incrementally maintain results for this query.  We compute the results once.  Then, (1) every time we remove a node, we find all of the query results the node participates in.  (2) every time we add a node, we look at its immediate ancestors and descendants to determine which new query results the node enables. 

The main limiting factor of this approach is that now we need a way to look up each node's parents.  For example, let's say we have the structure (somewhere in the tree):
~~~
BTree(
  Array(...),
  sep
  SortedArray(...)
)
~~~
As soon as we Sort the Array, this structure becomes a candidate TODO.  However, the SortArray transform is only looking at the array itself, and has no idea who the array's parent is.  

The problem gets more complex: There may be multiple parents.  Obviously if we're working with a DAG, that's a problem.  However, tracking parents poses a problem for trees as well.  Consider the Pushdown transform, which rewrites an inner structure (i.e., the structure created by Pushdown includes non-leaf nodes re-used from the original tree).  In other words, the transform replaces the parent of one existing node with another.  The problem is that the parent doesn't 'officially' get replaced until the root of the newly created structure is linked back into the JITD.  That, in turn, means that we need multiple pointer swaps to be performed atomically, in concert. 

Question: Where do we store the parent pointer?
* In the node itself: Efficient, but problematic if we need to store multiple parents.
* In a separate structure: Possibly less efficient, but can use something like unordered_multimap to track multiple parents.

We can put off the problem of multiple-parents if we can guarantee that at most one thread will be handling scheduling and problematic transforms at any given time, since the parent swaps can be handled atomically by that thread.

Another, more limited version of this problem is to maintain an external data structure that lists, for every node, all of the matches that the node *could* participate in, given its parents.  

