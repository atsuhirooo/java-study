package ch02.ex03;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class VehicleTest {

 @Test
 public void startTest(){
  Vehicle v = new Vehicle(60,"north","atsuhiro");
  assertThat(v.carID,is(0));
  assertThat(v.speed,is(60));
  assertThat(v.direction,is("north"));
  assertThat(v.ownerName,is("atsuhiro"));
  
  Vehicle v2 = new Vehicle(40,"south","atsuhiro");
  assertThat(v2.carID,is(1));

}


}

