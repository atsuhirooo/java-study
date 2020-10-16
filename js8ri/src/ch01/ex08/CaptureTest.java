package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public final class CaptureTest {

	public static void main(String[] args) {
		String[] names = { "Peter", "Paul", "Marry" };
		List<Runnable> runners = new ArrayList<>();

		for (String name : names)
			runners.add(() -> System.out.println(name));

		// for (int i=0;i<names.length;i++)
		// runners.add(()->System.out.println(names[i]));

	}

}
