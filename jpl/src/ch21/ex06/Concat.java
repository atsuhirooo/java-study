package ch21.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;

class Concat {

	public static InputStream in;

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			in = System.in;
		} else {

			InputStream[] inputs = new InputStream[args.length];
			for (int i = 0; i < args.length; i++) {
				try {
					inputs[i] = new FileInputStream(args[i]);
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			cat(inputs);
		}
		int ch;
		try {
			while ((ch = in.read()) != -1) {
				System.out.println(ch);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void cat(InputStream... inputs_) {
		InputStream fileIn, bufIn;

		List<InputStream> inputs = Arrays.asList(inputs_);
		// List<InputStream> inputs = new ArrayList<>(inputs_.length);
		// for (InputStream input : inputs_) {
		//
		// bufIn = new BufferedInputStream(input);
		// inputs.add(bufIn);
		// }

		Enumeration<InputStream> files = new EnumerationImpl(inputs);
		in = new SequenceInputStream(files);
	}

	public static class EnumerationImpl<E extends InputStream> implements Enumeration {

		private final ListIterator<E> listIterator;
		private E usedInputStream = null;

		EnumerationImpl(List<E> list) {
			listIterator = list.listIterator();
		}

		@Override
		public boolean hasMoreElements() {
			return listIterator.hasNext();
		}

		@Override
		public InputStream nextElement() {
			if (usedInputStream != null) {
				try {
					usedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			usedInputStream = listIterator.next();
			return usedInputStream;
		}

	}
}
