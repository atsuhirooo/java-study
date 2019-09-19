package ch02.ex02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
  
public class LinkedListTest{
   @Test
   public void showTest(){
     LinkedList ll = new LinkedList();
     ll.add(new Object());
     ll.add(new Object());
     ll.add(new Object());
     ll.showlist();
  }
}
