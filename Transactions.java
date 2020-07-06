
package corporatevehiclerentalagnecy;

import java.util.ArrayList;
/*
This method will only add to the array. It keeps the history of all transactions made when
as vehicle is returned. Acts like the Vehicles aggregation class
*/
public class Transactions {
  private Transaction [] list;
private int index=0;  
public Transactions(){
   list= new Transaction[100]; // default amount of possible transactions it would hold 
}
  public void add (Transaction tran){ 
   int i=0;
   boolean found=false;
     while(!found)
     {
          if (list[i]!=null)
           i++;
        else
          if (list[i]==null)
            found=true;     
     }
     if(found)
     {
         list[i]=tran;
         
         
         }
  }
 public void reset(){ // resets index to 0 when called
     index=0;
 } 
 public boolean hasNext(){// checks if index is null 
     return list[index]!=null;
 }
 public Transaction getNext(){// will return a transaction object 
    Transaction tran=list[index];
    index+=1;
    return tran;
}

}
