package ch20.ex02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class TranslateByte extends FilterInputStream {

	private final byte from;
	private final byte to;

	protected TranslateByte(InputStream in, int from, int to) {
		super(in);
		if (from < 0 || from > 255) {
			throw new IllegalArgumentException("from, illegal input: " + from);
		}
		if (to < 0 || to > 255) {
			throw new IllegalArgumentException("to, illegal input: " + to);
		}
		this.from = (byte) from;
		this.to = (byte) to;
	}

	@Override
	public int read() throws IOException {
		int b = super.read();
		return (b == from) ? to : b;
	}
}
