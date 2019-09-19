package ch01.ex16;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class BadDataSetExceptionTest {

	@Test
	public void exceptionTest() {
		Exception expectE = new Exception();

		BadDataSetException e = new BadDataSetException("test", expectE);

		assertThat(e.getName(), is("test"));
		assertThat(e.getException(), is(expectE));

	}
}
