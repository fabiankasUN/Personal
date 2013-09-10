import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonDecreasingDigits {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder br = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		long dp[][] = new long[ 65 ][ 11 ];
		for (int i = 1; i < dp[0].length; i++) {
			dp[1][i] = i;
			dp[0][i] = 0;
			dp[2][i] = dp[2][i - 1] + 10 - i + 1;
		}
		
		for (int i = 3; i <= 64; i++) {
			for (int j = 1; j <= 10; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][10] - dp[i - 1][j - 1];
			}
		}
		for (int i = 0; i < n; i++) {
			int values[] = atoi(in.readLine());
			br.append((i + 1) + " " + dp[values[1]][10] + "\n");
		}
		System.out.print(br);
	}
}
