import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitSum {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int sum = 45;

	public static int sumOnes(int n) {
		if (n <= 100) {
			if (n >= 20) {
				return 12 + ((n % 10 >= 1) ? (n / 10) - 1 : (n / 10) - 2);
			} else {
				return n / 10 + 1 + n % 10;
			}
		}
		return 10 * (sumOnes(n / 10)) / 10;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// String line = in.readLine();
		// int arr[] = atoi(line);
		// int n = arr[0];
		int n=Integer.parseInt(in.readLine());
		String x = "0";
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j < x.length(); j++) {
				if (x.charAt(j) == '1') {
					sum++;
				}
			}
			x = i + "";
		}
		// System.out.println(sum);
		System.out.println(sumOnes(n));
	}
}
