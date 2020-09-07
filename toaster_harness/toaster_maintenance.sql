
CREATE STREAM DeleteSingleton(iter_id int, node_self int, node_child int, key int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV();

/* CREATE STREAM DeleteElements(iter_id int, node_self int, node_child int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV(); */

CREATE STREAM BTree(iter_id int, node_self int, node_left int, node_right int, separator int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV();

CREATE STREAM Concat(iter_id int, node_self int, node_left int, node_right int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV();

/* CREATE STREAM SortedArray(iter_id int, node_self int, size int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV(); */

CREATE STREAM Array(iter_id int, node_self int, size int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV();

CREATE STREAM Singleton(iter_id int, node_self int, key int) FROM FILE 'maintenance_input.csv' LINE DELIMITED CSV();


/* CrackArray */
/* SELECT a.id FROM Array a WHERE a.arraySize > crackAt */
SELECT Array.node_self FROM Array WHERE Array.size > 100;  /* crackAt */

/* MergeSortedBTrees */
/* SELECT a.id FROM BTree a, SortedArray b, SortedArray c WHERE a.lhs = b.id AND a.rhs = c.id LIMIT 1 */

/* MergeSortedConcat */
/* SELECT a.id FROM Concat a, SortedArray b, SortedArray c WHERE a.lhs = b.id AND a.rhs = c.id LIMIT 1 */

/* MergeUnSortedConcatArray */
/* SELECT a.id FROM Concat a, Array b, Array c WHERE a.lhs = b.id AND a.rhs = c.id LIMIT 1 */

/* MergeUnSortedConcatArrayandSingleton */
/* SELECT a.id FROM Concat a, Array b, Singleton c WHERE a.lhs = b.id AND a.rhs = c.id LIMIT 1 */

/* PivotLeft */
/* SELECT a.id FROM BTree a, BTree b WHERE a.lhs = b.id LIMIT 1 */

/* PushDownAndCrack */
/* SELECT a.id FROM Concat a, BTree b, Array c WHERE a.lhs = b.id AND a.rhs = c.id ORDER BY c.arraySize LIMIT 1 */
/* SELECT Concat.node_self FROM Concat, BTree, Array WHERE Concat.node_left = BTree.node_self AND Concat.node_right = Array.node_self; */

/* PushDownSingleton */
/* SELECT a.id FROM Concat a, BTree b, Singleton c WHERE a.lhs = b.id AND a.rhs = c.id LIMIT 1 */

/* PushDownSingletonLeft */
/* SELECT a.id FROM Concat a, BTree b, Singleton c WHERE a.lhs = b.id AND a.rhs = c.id AND data < b.separator */
SELECT Concat.node_self FROM Concat, BTree, Singleton WHERE Concat.node_left = BTree.node_self AND Concat.node_right = Singleton.node_self /*AND Singleton.key < BTree.separator*/;

/* PushDownSingletonRight */
/* SELECT a.id FROM Concat a, BTree b, Singleton c WHERE a.lhs = b.id AND a.rhs = c.id AND data >= b.separator */
/*SELECT Concat.node_self FROM Concat, BTree, Singleton WHERE Concat.node_left = BTree.node_self AND Concat.node_right = Singleton.node_self AND Singleton.key >= BTree.separator;*/

/* PushDownDontDeleteElemBtree */
/* SELECT a.id FROM DeleteElements a, BTree b WHERE a.lhs = b.id LIMIT 1 */

/* PushDownDontDeleteElemConcat */
/* SELECT a.id FROM DeleteElements a, Concat b WHERE a.lhs = b.id LIMIT 1 */

/* PushDownDontDeleteSingletonBtree */
/* SELECT a.id FROM DeleteSingleton a, BTree b WHERE a.lhs = b.id LIMIT 1 */

/* PushDownDontDeleteSingletonBtreeLeft */
/* SELECT a.id FROM DeleteSingleton a, BTree b WHERE a.lhs = b.id AND a.key < b.separator */
SELECT DeleteSingleton.node_self FROM DeleteSingleton, BTree WHERE DeleteSingleton.node_child = Btree.node_self AND DeleteSingleton.key < BTree.separator;

/* PushDownDontDeleteSingletonBtreeRight */
/* SELECT a.id FROM DeleteSingleton a, BTree b WHERE a.lhs = b.id AND a.key >= b.separator LIMIT 1 */
SELECT DeleteSingleton.node_self FROM DeleteSingleton, BTree WHERE DeleteSingleton.node_child = Btree.node_self AND DeleteSingleton.key >= BTree.separator;

/* PushDownDontDeleteSingletonConcat */
/* SELECT a.id FROM DeleteSingleton a, Concat b WHERE a.lhs = b.id LIMIT 1 */

/* DeleteElemFromSortedArray */
/* SELECT a.id FROM DeleteElements a, SortedArray b WHERE a.lhs = b.id LIMIT 1 */

/* DeleteElemFromArray */
/* SELECT a.id FROM DeleteElements a, Array b WHERE a.lhs = b.id LIMIT 1 */

/* DeleteSingletonFromArray */
/* SELECT a.id FROM DeleteSingleton a, Array b WHERE a.lhs = b.id LIMIT 1 */
SELECT DeleteSingleton.node_self FROM DeleteSingleton, Array WHERE DeleteSingleton.node_child = Array.node_self;

/* DeleteKeyFromSingleton */
/* SELECT a.id FROM DeleteSingleton a LIMIT 1 */

/* DeleteElemFromSingleton */
/* SELECT a.id FROM DeleteElements a, Singleton b WHERE a.lhs = b.id LIMIT 1 */




