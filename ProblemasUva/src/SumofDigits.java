import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofDigits {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void dfs(int index, int s) {
		if (index == 1001) {

		} else {
			char cad[] = (index + "").toCharArray();
			int sum = 0;
			for (int i = 0; i < cad.length; i++) {
				sum += Integer.parseInt(cad[i] + "");
			}
			System.out.println(index + " " + (s + sum));

			dfs(index + 1, s + sum);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = in.readLine()) != null) {
			if (line.equals("0"))
				break;
			int n = Integer.parseInt(line);
			long dp[][] = new long[ 11 ][ 11 ];

			for (int i = 1; i < dp[0].length; i++) {
				dp[0][i] = 0;
				dp[1][i] = i;
				dp[2][i] = dp[2][i - 1] + 45 + ((i - 1) * 10);
			}
			dfs(0, 0);

			for (int i = 3; i < 11; i++) {
				for (int j = 1; j <= 10; j++) {

					dp[i][j] =dp[i - 1][10]+(((j - 1) * (int) Math.pow(10, i-1)));
					// dp[i][j] = dp[i][j - 1] + dp[i - 1][10] + ((j - 1) *
					// (int) Math.pow(10, i));

				}
			}

		}
	}
}
