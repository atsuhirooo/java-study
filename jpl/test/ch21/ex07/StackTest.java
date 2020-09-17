package ch21.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testStack() {
		Stack<String> stack = new Stack();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.pop();
		stack.push("d");

		assertThat(stack.peek(), is("d"));
		assertThat(stack.Search("a"), is(3));

	}

}
