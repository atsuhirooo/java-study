
package ch22.ex05;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public final class Dice {

	private static final Random r = new Random();
	private static final Map<Integer, Integer> sumOfDiceNumAndCount = new HashMap<>();
	private static final int NUM_OF_DICE = 3;
	private static final int NUMBER_OF_TRIALS = 1000;

	public static void main(String[] args) {
		test();

		for (final Entry<Integer, Integer> entry : sumOfDiceNumAndCount.entrySet()) {
			int sumOfDiceNum = entry.getKey();
			int count = entry.getValue();

			System.out.print("sumOfDiceNum: " + sumOfDiceNum + ", ");
			System.out.printf("frequency: %d%n", count);
		}
	}

	private static void test() {
		for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
			int sumOfDiceNum = 0;
			for (int j = 0; j < NUM_OF_DICE; j++) {
				sumOfDiceNum += (r.nextInt(6) + 1);

			}
			Integer count = sumOfDiceNumAndCount.get(sumOfDiceNum);
			if (count == null) {
				sumOfDiceNumAndCount.put(sumOfDiceNum, 1);
			} else {
				sumOfDiceNumAndCount.put(sumOfDiceNum, ++count);
			}
		}
	}

}
