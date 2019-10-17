package ch04.ex03;

public class ListElement implements Cloneable{

     ListElement(Object value){
       this.value=value;
     }
     
     public Object value;
     
     public ListElement next;


public ListElement clone(){

 
 try {
    return (ListElement) super.clone();
     

 } catch (CloneNotSupportedException e){
  throw new InternalError(e.toString());
  
}
}

}

