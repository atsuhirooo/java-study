package ch22.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Test;

public class CSVTest {

	@Test

	public void testCSVread() {
		String csv = "1, 2, 3\n4, 5, 6\n";
		StringReader reader = new StringReader(csv);

		List<String[]> result = null;
		try {
			result = ReadCSVTable.readCSVTable(reader, 3);
		} catch (IOException e) {
			e.printStackTrace();

		}

		String[][] expected = { { "1", " 2", " 3" }, { "4", " 5", " 6" } };

		for (int i = 0; i < result.size(); i++) {
			String[] record = result.get(i);

			for (int j = 0; j < record.length; j++) {
				assertThat(record[j], is(expected[i][j]));

			}
		}
	}
}
