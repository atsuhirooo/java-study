package ch22.ex14;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class DoubleSunTest {

	@Test
	public void testDoubleSum() {

		String csv = "1.23456789 1.23456789";
		StringReader reader = new StringReader(csv);
		try {
			System.out.println(DoubleSum.sumDouble(reader));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
