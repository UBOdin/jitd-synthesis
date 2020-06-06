template <class JITDNode> 
class MergeIterator : public IteratorBase<Record> {
  std::shared_ptr<JITDNode> lhs, rhs;
  Iterator<Record> lhsIter, rhsIter;
  bool lhsDone, rhsDone;
  bool lhsBest;
  
  public: 
    MergeIterator(
      std::shared_ptr<JITDNode> &lhs, 
      std::shared_ptr<JITDNode> &rhs
    )
    {
      //std::cout<<"Merege iterator constructor"<<std::endl;
      if(lhsIter.get()==NULL)
      {
        lhsIter = lhs->iterator();
        //std::cout<<"MEREGE CONSTRUCTOR:LHS ITER CREATED"<<lhs<<std::endl;
        lhsDone = lhsIter->atEnd();
        //std::cout<<"MEREGE CONSTRUCTOR:LhsDone:"<<lhsDone<<std::endl;
      }
      if(rhsIter.get()==NULL)
      {
        rhsIter = rhs->iterator();
        //std::cout<<"MEREGE CONSTRUCTOR:RHS ITER CREATED"<<rhs<<std::endl;
        rhsDone = rhsIter->atEnd();
        //std::cout<<"MEREGE CONSTRUCTOR:RhsDone:"<<rhsDone<<std::endl;
      }
      //std::cout<<"CONSTRUCTOR:LhsDone: "<<lhsDone<<std::endl;
      
      //std::cout<<"CONSTRUCTOR:rhsDone: "<<rhsDone<<std::endl;
      //updateBest();
    }
    
//     inline void updateBest() 
//     {
//       lhsBest = ((!lhsDone) && (rhsDone || (*lhsIter->get() < *rhsIter->get())));
// //      std::cerr << "Cmp: " << *lhsIter->get() << " ^^ " << *rhsIter->get() << std::endl;
//     }

    void next()
    {
      //std::cout<<"MergeIterator NEXT()"<<std::endl;
      if(lhsDone && rhsDone) { return; }
      else if(!lhsDone && !rhsDone){lhsIter->next(); lhsDone = lhsIter->atEnd(); //std::cout<<"Next:LhsDone: "<<lhsDone<<std::endl;
      }
      // else if(!lhsDone && rhsDone){lhsIter->next(); lhsDone = lhsIter->atEnd(); //std::cout<<"Next:LhsDone: "<<lhsDone<<"Next:rhsDone: "<<rhsDone<<std::endl;
      // }
      else if(lhsDone && !rhsDone){rhsIter->next(); rhsDone = rhsIter->atEnd();//std::cout<<"Next:rhsDone: "<<rhsDone<<std::endl;
      }
      else if(!rhsDone){rhsIter->next(); rhsDone = rhsIter->atEnd();//std::cout<<"Next:rhsDone: "<<rhsDone<<std::endl;
      }
      // if(lhsBest) { lhsIter->next(); lhsDone = lhsIter->atEnd();}
      // else        { rhsIter->next(); rhsDone = rhsIter->atEnd(); }
      // updateBest();
    }
    void range_next(const long &r1,const long &r2)
    {
      //std::cout<<"MergeIterator NEXT()"<<std::endl;
      if(lhsDone && rhsDone) { return; }
      else if(!lhsDone && !rhsDone){lhsIter->range_next(r1,r2);; lhsDone = lhsIter->atEnd(); //std::cout<<"Next:LhsDone: "<<lhsDone<<std::endl;
      }
      // else if(!lhsDone && rhsDone){lhsIter->next(); lhsDone = lhsIter->atEnd(); //std::cout<<"Next:LhsDone: "<<lhsDone<<"Next:rhsDone: "<<rhsDone<<std::endl;
      // }
      else if(lhsDone && !rhsDone){rhsIter->range_next(r1,r2);; rhsDone = rhsIter->atEnd();//std::cout<<"Next:rhsDone: "<<rhsDone<<std::endl;
      }
      else if(!rhsDone){rhsIter->range_next(r1,r2);; rhsDone = rhsIter->atEnd();//std::cout<<"Next:rhsDone: "<<rhsDone<<std::endl;
      }
      // if(lhsBest) { lhsIter->next(); lhsDone = lhsIter->atEnd();}
      // else        { rhsIter->next(); rhsDone = rhsIter->atEnd(); }
      // updateBest();
    }
    void seek(const Record &k)
    {
      //std::cout<<"MergeIterator SEEK()"<<std::endl;
      lhsIter->seek(k); //std::cout<<"seek for MergeIterator lhs done"<<std::endl;
      lhsDone = lhsIter->atEnd(); 
      //std::cout<<"lhsDone:"<<lhsDone<<std::endl;
      rhsIter->seek(k);  rhsDone = rhsIter->atEnd();
      //std::cout<<"rhsDone:"<<rhsDone<<std::endl;
      //updateBest();
    }
    bool atEnd()
    {
      return lhsDone && rhsDone;
    }
    Record get()
    {
      if(!lhsDone)
      {
        return lhsIter->get();
      }
      else if(lhsDone && rhsDone)
      {
        return rhsIter->get();
      }
      else  
      {
        //rhsIter->next();
        return rhsIter->get();
      }
      // Record r = lhsIter->get();
      // if(r.key !=0)
      // {
      //   return r;
      // }
      // //if(lhsBest) { return lhsIter->get(); }
      // else        { return rhsIter->get(); }
    }
};