package ch03.ex02;

public class Y extends X {

  protected int yMask = 0xff00;
 
  public Y() {

   fullMask |= yMask;
   System.out.printf("Y constractor body fullMask %x %n",fullMask);
  }

  public static void main(String[] args){
   X x =new X();
   x.mask(10);

   Y y = new Y();
   y.mask(20);

  }
}
