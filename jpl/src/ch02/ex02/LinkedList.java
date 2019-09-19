package ch02.ex02;

public class LinkedList {
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
}

  
