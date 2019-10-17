package ch04.ex03;

public class LinkedListImpl implements LinkedList,Cloneable{
   ListElement head; 

   public void add(Object value){
        if(head==null)
           head=new ListElement(value);
        else{   
          ListElement tmp=head;
          while(tmp.next!=null){
            tmp=tmp.next;  
          }
          tmp.next=new ListElement(value);
        }
   }   

   public void showlist(){ 
        ListElement tmp=this.head;
        while(tmp!=null && tmp.value!=null){
          System.out.println(tmp.value);
          tmp=tmp.next;  
        }
   }

   

 public LinkedListImpl clone(){
 try {
    LinkedListImpl ll = (LinkedListImpl) super.clone();
    ll.head = head.clone();
    return ll; 

 } catch (CloneNotSupportedException e){
  throw new InternalError(e.toString());
  
}
}
}
  
