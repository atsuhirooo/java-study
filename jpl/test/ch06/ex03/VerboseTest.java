package ch06.ex03;

import org.junit.Test;

public class VerboseTest {

	@Test
	public void startTest() {

		// 目視確認
		for (Verbose.MessageLebel mlabel : Verbose.MessageLebel.values())
			System.out.println(mlabel);

	}

}
