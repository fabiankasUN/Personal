import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SumDigits {

	// split de array
	public static long[] atoi(String cad) {
		String read[] = cad.split(" ");
		long res[] = new long[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Long.parseLong(read[i]);
		}
		return res;
	}

	static long dp[][];
	static int c[] = { 1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10, 1 };

	public static long sum(long num) {

		long modulo;
		long sum = 0;
		int arr[] = new int[ (num + "").length() ];
		int tam = c.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt((num + "").charAt(i) + "");
		}
		int cont = c.length - arr.length;
		int cond = 0;
		while (cont < c.length) {
			modulo = num / c[cont];
			sum += dp[tam - cont][(int) modulo];
			sum += arr[cond];
			if (cont != c.length - arr.length) {
				sum += arr[cond - 1] * (num);
			}
			cond++;
			num = num % c[cont];
			cont++;
		}
		sum -= arr[arr.length - 1];
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		dp = new long[ 11 ][ 11 ];
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = 0;
			dp[1][i] = dp[1][i - 1] + i;
			dp[2][i] = dp[2][i - 1] + 45 + ((i - 1) * 10);
		}

		for (int i = 3; i < 11; i++) {
			for (int j = 1; j <= 10; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][10] + ((j - 1) * (int) Math.pow(10, i - 1));
			}
		}

		while ((line = in.readLine()) != null) {
			if (line.equals("-1 -1"))
				break;
			long values[] = atoi(line);
			long ini = values[0];
			long fin = values[1];
			System.out.println((sum(fin) - sum(ini - 1)));
		}

	}
}
