package ch10.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class ReplaceTest {

	@Test
	public void ReplaceTest() {
		assertThat(Replace.replaceMethod("\n"), is("\\n"));
		assertThat(Replace.replaceMethod("\t"), is("\\t"));
		assertThat(Replace.replaceMethod("\b"), is("\\b"));
		assertThat(Replace.replaceMethod("\r"), is("\\r"));
		assertThat(Replace.replaceMethod("\f"), is("\\f"));
		assertThat(Replace.replaceMethod("\\"), is("\\\\"));
		assertThat(Replace.replaceMethod("\'"), is("\\'"));
		assertThat(Replace.replaceMethod("\""), is("\\\""));

	}
}
