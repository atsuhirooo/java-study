package ch22.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhichCharsTest {

	@Test
	public void testToString() {
		WhichChars wc = new WhichChars("Testing 1 2 3");
		final String actual = wc.toString();
		final String expected = "[ 123Teginst]";
		if (!actual.equals(expected)) {
			fail();
		}
	}

}
