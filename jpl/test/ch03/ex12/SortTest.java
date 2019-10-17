package ch03.ex12;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class SortTest {

	static Object[] testData = { 0.3, 1.3e-2, 7.9, 3.17 };
	static Object[] expectedResult = { 7.9, 3.17, 0.3, 1.3e-2 };

	@Test
	public void startTest() {

		SortHarness tmp = new SortHarness() {

			@Override
			protected void doSort() {
				for (int i = 0; i < getDataLength(); i++) {
					for (int j = i + 1; j < getDataLength(); j++) {

						if (compare(i, j) > 0) {
							swap(i, j);
						}
					}
				}

			}

			@Override
			protected boolean isFormerBigger(Object former, Object latter) {
				// TODO 自動生成されたメソッド・スタブ

				return (Double) former > (Double) latter;

			}

		};

		tmp.sort(testData);

		for (int i = 0; i < testData.length; i++) {
			assertThat(testData[i], is(expectedResult[i]));
		}

	}
}
