package ch07.ex03;

public class Pascal {

	public static void main(String[] args) {
		Pascal p = new Pascal();
		p.showPascal(14);

	}

	void showPascal(int depth) {
		int[][] pascalTriangle = new int[depth][];
		pascalTriangle[0] = new int[0];
		for (int i = 1; i < depth; i++) {
			pascalTriangle[i] = new int[i + 1];
			pascalTriangle[i][0] = 1;
			pascalTriangle[i][i] = 1;
			for (int j = 1; j < i; j++) {
				pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
			}

		}

		for (int[] p : pascalTriangle) {
			for (int e : p) {
				System.out.print(e + " ");
			}
			System.out.println("");
		}
	}
}
