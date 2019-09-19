package ch02.ex07;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class VehicleTest {

 @Test
 public void startTest(){
  Vehicle v = new Vehicle("atsuhiro");
  v.setSpeed(60);
  v.setDirection("North");
  String expectInfo = "carID: 0 speed: 60 direction: North ownerName: atsuhiro";
  assertThat(v.vehicleInfo(),is(expectInfo));
  
 }
}

