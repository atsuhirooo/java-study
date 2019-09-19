package ch02.ex11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
  
public class LinkedListTest{


   @Test
   public void showTest(){
  
        Vehicle v1 = new Vehicle("a");
        v1.setSpeed(10);
        v1.setDirection("East");
       
        LinkedList ll = new LinkedList(v1);
        String expectInfo1 = "carID: 1 speed: 10 direction: East ownerName: a";
        assertThat(v1.toString(),is(expectInfo1));
     
        Vehicle v2 = new Vehicle("b");
        v2.setSpeed(20);
        v2.setDirection("West");
        ll.add(v2);
        String expectInfo2 = "carID: 2 speed: 20 direction: West ownerName: b";
        assertThat(v2.toString(),is(expectInfo2));
        
        String expectResult="[carID: 1 speed: 10 direction: East ownerName: a]%n[carID: 2 speed: 20 direction: West ownerName: b]";
        System.out.printf(expectResult);
        assertThat(ll.toString(), is(expectResult));

}         
}
