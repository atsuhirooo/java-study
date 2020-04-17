package ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class EncryptOutputStream extends FilterOutputStream {

	private final byte key;

	public EncryptOutputStream(OutputStream out, byte key) {
		super(out);
		this.key = key;
	}

	@Override
	public void write(int b) throws IOException {
		int encrypted = b ^ key;
		super.write(encrypted);
	}
}
