package ch04.ex01;

public class GasTank implements EnergySource {
  
    
  private boolean isGasEmpty=true;
  public void setEnergy(){
    isGasEmpty=false;
    
  }
  public boolean empty(){
   return isGasEmpty;
  }
}
