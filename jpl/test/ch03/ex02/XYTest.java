package ch03.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class XYTest {

	@Test
	public void startTest() {
		X x = new X();
		assertThat(x.mask(255 * 256 + 255 * 1), is(255));
		Y y = new Y();
		assertThat(y.mask(255 * 256 + 255 * 1), is(255 * 256 + 255 * 1));

	}

}
