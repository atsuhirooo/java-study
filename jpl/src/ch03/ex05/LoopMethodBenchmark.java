package ch03.ex05;

public class LoopMethodBenchmark extends Benchmark {

	public int totalCount = 0;

	public void benchmark() {
		for (int i = 0; i < 100; i++) {

			totalCount++;
		}
	}

	public static void main(String[] args) {

		int count = Integer.parseInt(args[0]);
		long time = new LoopMethodBenchmark().repeat(count);
		System.out.println("count:" + count + " time:" + time);
	}
}
