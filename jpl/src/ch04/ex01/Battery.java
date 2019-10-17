package ch04.ex01;

public class Battery implements EnergySource {
  
    
  private boolean isBatteryEmpty=true;
  public void setEnergy(){
   isBatteryEmpty=false; 
  }

  public boolean empty(){
   return isBatteryEmpty;
  }
}
