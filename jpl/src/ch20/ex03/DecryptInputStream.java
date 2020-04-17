
package ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DecryptInputStream extends FilterInputStream {

	private final byte key;

	protected DecryptInputStream(InputStream in, byte key) {
		super(in);
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		int encrypted = super.read();
		return encrypted ^ key;
	}
}
