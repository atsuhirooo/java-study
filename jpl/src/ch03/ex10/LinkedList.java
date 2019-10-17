package ch03.ex10;

public class LinkedList implements Cloneable{
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

   

 public LinkedList clone(){
 try {
    LinkedList ll = (LinkedList) super.clone();
    ll.head = head.clone();
    return ll; 

 } catch (CloneNotSupportedException e){
  throw new InternalError(e.toString());
  
}
}
}
  
