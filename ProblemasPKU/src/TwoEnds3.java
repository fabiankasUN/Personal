import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoEnds3 {

	public static int nums[];
	public static int dp[][];
	public static int dp2[][];
	public static int INF = Integer.MIN_VALUE + 1;

	public static int recursive(int indexIzq, int indexDer, int sum, int sumGreedy, int turn) {

		if (indexIzq > indexDer) {
		} else {
			if (turn == 0) {
				if (dp[indexIzq][indexDer] != INF && indexIzq != indexDer) {
					return dp[indexIzq][indexDer];
				} else {

					int a = recursive(indexIzq, indexDer - 1, sum + nums[indexDer], sumGreedy, 1);
					int b = recursive(indexIzq + 1, indexDer, sum + nums[indexIzq], sumGreedy, 1);
					return dp[indexIzq][indexDer] = Math.max(a, b);
				}

			} else {
				int max = Math.max(nums[indexDer], nums[indexIzq]);
				if (max == nums[indexIzq]) {
					if (dp[indexDer][indexIzq] != INF) {
						return dp[indexDer][indexIzq];

					} else
						dp[indexDer][indexIzq] = recursive(indexIzq + 1, indexDer, sum, sumGreedy + nums[indexIzq], 0);

				} else {
					if (dp[indexDer][indexIzq] != INF) {
						return dp[indexDer][indexIzq];
					} else {
						dp[indexDer][indexIzq] = recursive(indexIzq, indexDer - 1, sum, sumGreedy + nums[indexDer], 0);
					}
				}
			}
		}
		return sum - sumGreedy;
	}

	public static int recursive2(int indexIzq, int indexDer, int sum, int sumGreedy, int turn) {
		if (indexIzq > indexDer) {
		} else {
			if (turn == 0) {
				if (dp2[indexIzq][indexDer] != INF && indexDer != indexIzq) {
					return dp2[indexIzq][indexDer];
				} else {
					int b = recursive2(indexIzq, indexDer - 1, sum + nums[indexDer], sumGreedy, 1);
					int a = recursive2(indexIzq + 1, indexDer, sum + nums[indexIzq], sumGreedy, 1);
					return dp2[indexIzq][indexDer] = Math.max(a, b);
				}

			} else {
				if (dp2[indexDer][indexIzq] != INF && indexDer != indexIzq) {
					return dp2[indexDer][indexIzq];
				} else {
					int max = Math.max(nums[indexDer], nums[indexIzq]);

					if (max == nums[indexIzq]) {
						if (dp2[indexDer][indexIzq] != INF) {
							return dp2[indexDer][indexIzq];

						} else
							dp2[indexDer][indexIzq] = recursive2(indexIzq + 1, indexDer, sum, sumGreedy + nums[indexIzq], 0);
					} else {
						if (dp2[indexDer][indexIzq] != INF) {
							return dp2[indexDer][indexIzq];
						} else {
							dp2[indexDer][indexIzq] = recursive2(indexIzq, indexDer - 1, sum, sumGreedy + nums[indexDer], 0);
						}

					}
				}
			}
		}
		return sum - sumGreedy;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int times = 1;
		while ((line = in.readLine()) != null) {
			if (line.equals("0"))
				break;
			String cad[] = line.split(" ");
			nums = new int[ cad.length - 1 ];
			for (int i = 1; i < cad.length; i++) {
				nums[i - 1] = Integer.parseInt(cad[i]);
			}
			dp = new int[ nums.length ][ nums.length ];
			dp2 = new int[ nums.length ][ nums.length ];
			for (int i = 0; i < dp.length; i++) {
				for (int k = 0; k < dp.length; k++) {
					dp[i][k] = INF;
					dp2[i][k] = INF;
				}
			}
			recursive(0, nums.length - 1, 0, 0, 0);
			recursive2(0, nums.length - 1, 0, 0, 1);

			for (int i = 0; i < nums.length; i++) {
				for (int k = 0; k < nums.length; k++) {
					// if (i == k)
					System.out.print((dp[i][k] != INF ? dp[i][k] : 0) + "  ");
				}
				System.out.println();
			}

			System.out.println("");
			for (int i = 0; i < nums.length; i++) {
				for (int k = 0; k < nums.length; k++) {
					// if (i == k)
					System.out.print((dp2[i][k] != INF ? dp2[i][k] : 0) + "  ");
				} //
				System.out.println();
			}
			int res = Integer.MIN_VALUE;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp.length; j++) {

					if (dp[i][j] > res && dp[i][j] != INF) {
						res = dp[i][j];
					}
					if (dp2[i][j] > res && dp2[i][j] != INF) {
						res = dp2[i][j];
					}
				}
			}
			System.out.println("In game " + times++ + ", the greedy strategy might lose by as many as " + res + " points.");

		}
	}
}
