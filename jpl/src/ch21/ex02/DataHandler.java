package ch21.ex02;

import java.io.File;
import java.util.WeakHashMap;

class DataHandler {
	private final WeakHashMap<File, byte[]> fileAndLastData = new WeakHashMap<>();

	byte[] readFile(File file) {
		byte[] data;

		data = fileAndLastData.get(file);
		if (data != null) {
			return data;
		}

		data = readBytesFromFile(file);
		fileAndLastData.put(file, data);
		return data;
	}

	private byte[] readBytesFromFile(File file) {

		return new byte[0];
	}
}
