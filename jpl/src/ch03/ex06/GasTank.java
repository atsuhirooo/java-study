package ch03.ex06;

public class GasTank extends EnergySource {
  
    
  void setEnergy(){
   isEmpty=false; 
  }
  boolean empty(){
   return isEmpty;
  }
}
