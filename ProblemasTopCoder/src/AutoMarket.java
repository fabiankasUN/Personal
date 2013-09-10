import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AutoMarket {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static class order implements Comparable<order> {
		int cost;
		int feactures;
		int fixtimes;

		public order(int cost, int feactures, int fixtimes) {
			this.cost = cost;
			this.feactures = feactures;
			this.fixtimes = fixtimes;
		}

		@Override
		public int compareTo(order o) {
			if (this.cost < o.cost)
				return -1;
			if (this.cost > o.cost)
				return 1;
			return 0;
		}

	}

	public static int max = 0;
	public static order dp[];
	public static boolean cond = false;

	public static void dfs(int cur, int index, long mask) {
		if (cond) {
			return;
		}
		max = Math.max(cur, max);
		for (int i = index + 1; i < dp.length; i++) {
			if ((((1L << i) & mask)) == 0 && dp[i].feactures < dp[index].feactures && dp[i].fixtimes > dp[index].fixtimes
					&& dp[i].cost > dp[index].cost) {
				mask |= (long) (1L << i);
				if (cur + (dp.length - i) + index + 1 <= max) {
					cond = true;
				}
				dfs(cur + 1, i, mask);
				mask ^= (long) (1L << i);
			}
		}

	}

	public static int maxSet(int[] cost, int[] features, int[] fixTimes) {
		dp = new order[ cost.length ];
		for (int i = 0; i < fixTimes.length; i++) {
			dp[i] = new order(cost[i], features[i], fixTimes[i]);
		}
		Arrays.sort(dp);
		for (int i = 0; i < dp.length; i++) {
			dfs(1, i, 0);
			cond = false;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a[] = new int[ 50 ];
		int b[] = new int[ 50 ];
		int c[] = new int[ 50 ];
		for (int i = 1; i < 51; i++) {
			a[i - 1] = i;
			b[i - 1] = 50 - i + 1;
			c[i - 1] = i;

		}
		System.out.println(maxSet(a, b, c));
	}

}
