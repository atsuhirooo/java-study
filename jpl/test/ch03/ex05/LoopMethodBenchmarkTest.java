package ch03.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class LoopMethodBenchmarkTest {

	@Test
	public void startTest() {

		LoopMethodBenchmark lBenchmark = new LoopMethodBenchmark();
		lBenchmark.repeat(100);
		assertThat(lBenchmark.totalCount, is(10000));

	}

}