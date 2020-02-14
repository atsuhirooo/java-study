package ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class TranslateByte {

	public static void main(String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);

		String streamName = args[2];
		InputStream in = null;
		OutputStream out = null;
		switch (streamName) {
		case "System":
			in = System.in;
			out = System.out;
			break;
		default:
			throw new IllegalArgumentException("Illegal Stream type");
		}

		int b = 0;
		while ((b = in.read()) != -1) {
			out.write(b == from ? to : b);
		}
	}

}
