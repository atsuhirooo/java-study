package ch01.ex14;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import ch01.ex14.DoublePinWalkman;
import ch01.ex14.TwoWayCommunicationWalkman;
import ch01.ex14.Walkman;

public class WalkmanTest {
	@Test
	public void TestPinNumber() {

		Walkman walkman = new Walkman();
		assertThat(1, is(walkman.getPinNumber()));
		DoublePinWalkman walkman2 = new DoublePinWalkman();
		assertThat(1, is(walkman2.getPinNumber()));
		assertThat(2, is(walkman2.getSecondpin()));
		TwoWayCommunicationWalkman walkman3 = new TwoWayCommunicationWalkman();
		assertThat(1, is(walkman3.getPinNumber()));
		assertThat(2, is(walkman3.getSecondpin()));
		assertThat(walkman3.talk(), is("conversation"));

	}
}
