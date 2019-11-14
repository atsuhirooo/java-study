package ch09.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class bitCountTest {
	@Test
	public void bitCountTest() {

		assertThat(BitCount.count(-1), is(32));

	}
}
