import java.io.IOException;
import java.util.Scanner;

public class TwoEnds {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	// imprimir array
	static void printArrayInt(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

	public static int max = Integer.MIN_VALUE;
	public static int cartas = 0;
	public static int nCartas;
	public static int arr[];
	public static int dp[][];
	public static int dp2[][];
	public static int value;
	public static String camino;
	public static int value2 = 0;

	public static int dfs(int num, int sumGreedy, int sum, int indexIzq, int indexDer, int turn, String cadSum, String cadgreedy) {

		if (indexIzq <= indexDer) {
			if (turn == 0) {
				if (arr[indexIzq] >= arr[indexDer]) {
					if (dp[indexIzq][indexDer] != Integer.MIN_VALUE) {
						value = (sum - (sumGreedy + arr[indexIzq]));
						dp[indexIzq][indexDer] = Math.max(dp[indexIzq][indexDer], value);

					} else
						dp[indexIzq][indexDer] = dfs(num + 1, sumGreedy + arr[indexIzq], sum, indexIzq + 1, indexDer, 1, cadSum,
								cadgreedy + arr[indexIzq] + " ");
				} else {
					if (dp[indexIzq][indexDer] != Integer.MIN_VALUE) {
						value = (sum) - (sumGreedy + arr[indexDer]);
						dp[indexIzq][indexDer] = Math.max(dp[indexIzq][indexDer], value);
					} else {
						dp[indexIzq][indexDer] = dfs(num + 1, sumGreedy + arr[indexDer], sum, indexIzq, indexDer - 1, 1, cadSum,
								cadgreedy + arr[indexDer] + " ");
					}

				}
			} else {
				if (arr[indexIzq] >= arr[indexDer]) {
					dfs(num + 1, sumGreedy, sum + arr[indexIzq], indexIzq + 1, indexDer, 0, cadSum + arr[indexIzq] + " ",
							cadgreedy);
					dfs(num + 1, sumGreedy, sum + arr[indexDer], indexIzq, indexDer - 1, 0, cadSum + arr[indexDer] + " ",
							cadgreedy);
				} else {
					dfs(num + 1, sumGreedy, sum + arr[indexDer], indexIzq, indexDer - 1, 0, cadSum + arr[indexDer] + " ",
							cadgreedy);
					dfs(num + 1, sumGreedy, sum + arr[indexIzq], indexIzq + 1, indexDer, 0, cadSum + arr[indexIzq] + " ",
							cadgreedy);

				}

			}
		}
		if (sum - sumGreedy > max && indexIzq >= indexDer) {
			max = sum - sumGreedy;
			camino = cadSum + "    " + cadgreedy;
		}
		return sum - sumGreedy;
	}

	public static int dfs2(int num, int sumGreedy, int sum, int indexIzq, int indexDer, int turn, String cadSum, String cadgreedy) {

		if (indexIzq <= indexDer) {
			if (turn == 0) {
				if (arr[indexIzq] >= arr[indexDer]) {

					dfs2(num + 1, sumGreedy + arr[indexIzq], sum, indexIzq + 1, indexDer, 1, cadSum, cadgreedy + arr[indexIzq]
							+ " ");
				} else {

					dfs2(num + 1, sumGreedy + arr[indexDer], sum, indexIzq, indexDer - 1, 1, cadSum, cadgreedy + arr[indexDer]
							+ " ");

				}
			} else {
				if (dp2[indexIzq][indexDer] != Integer.MIN_VALUE) {
					value = ((sum + arr[indexIzq]) - (sumGreedy));
					value2 = ((sum + arr[indexDer]) - (sumGreedy));

					dp2[indexIzq][indexDer] = Math.max(value2, value);
					// dp2[indexIzq][indexDer] =
					// Math.max(dp[indexIzq][indexDer], value2);
				} else {
					if (arr[indexIzq] < arr[indexDer]) {
						dp2[indexIzq][indexDer] = dfs2(num + 1, sumGreedy, sum + arr[indexDer], indexIzq, indexDer - 1, 0, cadSum
								+ arr[indexDer] + " ", cadgreedy);

						dp2[indexIzq][indexDer] = dfs2(num + 1, sumGreedy, sum + arr[indexIzq], indexIzq + 1, indexDer, 0, cadSum
								+ arr[indexIzq] + " ", cadgreedy);
					} else {
						dp2[indexIzq][indexDer] = dfs2(num + 1, sumGreedy, sum + arr[indexIzq], indexIzq + 1, indexDer, 0, cadSum
								+ arr[indexIzq] + " ", cadgreedy);
						dp2[indexIzq][indexDer] = dfs2(num + 1, sumGreedy, sum + arr[indexDer], indexIzq, indexDer - 1, 0, cadSum
								+ arr[indexDer] + " ", cadgreedy);
					}

				}
			}
		}
		else if (sum - sumGreedy > max ) {
			max = sum - sumGreedy;
			camino = cadSum + "    " + cadgreedy;
		}
		return sum - sumGreedy;
	}

	public static void bruteForce(int num, int sumGreedy, int sum, int indexIzq, int indexDer, int turn, String cad) {
		if (num == nCartas) {
			if (sum - sumGreedy > max) {
				max = sum - sumGreedy;
				camino = cad;
			}
		} else {
			if (indexIzq <= indexDer) {
				if (turn == 0) {

					if (arr[indexIzq] > arr[indexDer]) {
						bruteForce(num + 1, sumGreedy + arr[indexIzq], sum, indexIzq + 1, indexDer, 1, cad + indexIzq + " ");
					} else {

						bruteForce(num + 1, sumGreedy + arr[indexDer], sum, indexIzq, indexDer - 1, 1, cad + indexDer + " ");

					}
				} else {

					bruteForce(num + 1, sumGreedy, sum + arr[indexIzq], indexIzq + 1, indexDer, 0, cad + indexIzq + " ");
					bruteForce(num + 1, sumGreedy, sum + arr[indexDer], indexIzq, indexDer - 1, 0, cad + indexDer + " ");

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);

		String line[];
		int times = 1;
		while (scan.hasNext()) {

			int n = scan.nextInt();// Integer.parseInt(line[0]);
			arr = new int[ n ];
			nCartas = n;
			dp = new int[ n ][ n ];
			dp2 = new int[ n ][ n ];
			long tm = System.currentTimeMillis();

			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {

					dp[i][k] = Integer.MIN_VALUE;
					dp2[i][k] = Integer.MIN_VALUE;
				}

			}
			// System.out.println(System.currentTimeMillis() - tm);
			 bruteForce(0, 0, 0, 0, arr.length - 1, 0, "");
			 bruteForce(0, 0, 0, 0, arr.length - 1, 1, "");
			//dfs(0, 0, 0, 0, arr.length - 1, 1, "", "");
			//dfs2(0, 0, 0, 0, arr.length - 1, 0, "", "");
			
			for (int i = 0; i < n; i++) {
				if (dp[i][i] > max)
					max = dp[i][i];
				if (dp2[i][i] > max)
					max = dp2[i][i];
			}

			System.out.println(camino);

			System.out.println("In game " + times + ", the greedy strategy might lose by as many as " + max + " points.");
			max = Integer.MIN_VALUE;
			times++;
			System.out.println(System.currentTimeMillis() - tm);

			/*
			 * for (int i = 0; i < n; i++) { for (int k = 0; k < n; k++) { //
			 * System.out.print((dp[i][k] != Integer.MIN_VALUE ? dp[i][k] :
			 * "n   ")); } System.out.println(); }
			 */

		}
	}
}
