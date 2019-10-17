package ch03.ex02;

public class X {
  protected int xMask = 0x00ff;
  protected int fullMask;

  public X() {
    fullMask = xMask;
    System.out.printf("X constructor body fullMask %x %n",fullMask);
  }
 
  public int mask(int orig) {
   System.out.printf("mask method fullMask %x %n",fullMask);
   return (orig & fullMask);
  }
}
