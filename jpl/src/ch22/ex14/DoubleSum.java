package ch22.ex14;

import java.io.IOException;
import java.util.Scanner;

public class DoubleSum {

	public static double sumDouble(Readable source) throws IOException {

		Scanner in = new Scanner(source);

		double sum = 0;
		while (in.hasNext()) {

			sum += in.nextDouble();
		}

		return sum;
	}
}
