package ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public final class LineReader extends FilterReader {

	protected LineReader(Reader in) {
		super(in);
	}

	public int readLine(char[] output, int offset) throws IOException {
		int ch;
		int count = 0;
		while ((ch = read()) != -1 && ch != '\n') {
			output[offset] = (char) ch;
			offset++;
			count++;
		}
		return count;
	}
}
