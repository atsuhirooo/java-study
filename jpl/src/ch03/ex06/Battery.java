package ch03.ex06;

public class Battery extends EnergySource {
  
    
  void setEnergy(){
   isEmpty=false; 
  }

  boolean empty(){
   return isEmpty;
  }
}
