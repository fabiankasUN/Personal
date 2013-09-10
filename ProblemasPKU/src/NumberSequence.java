import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSequence {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	// split de String
	public static String[] atos(String cad) {
		return cad.split(" ");
	}

	// parsing de String a int
	public static int parseo(String cad, int index) {
		return Integer.parseInt(cad.split(" ")[index]);
	}

	// memory status
	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory() >> 20)
				+ "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
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

	// impresion de datos
	static void print(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(obj[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(in.readLine());
		long dp[] = new long[33001];
		long dpSum[] = new long[33001];
		dp[0] = 1;
		dpSum[0] = 1;
		int arr[] = { 9, 99, 999, 9999, 99999 };
		int cont = 1;
		int index = 0;
		int sum = 1;
		for (int i = 1; i <= 33000; i++) {
			if (cont < arr[index]) {
				dp[i] = dp[i - 1] + sum;
				dpSum[i] = dpSum[i - 1] + dp[i];
				cont++;
			} else {
				cont++;
				sum++;
				index++;
				dp[i] = dp[i - 1] + sum;
				dpSum[i] = dpSum[i - 1] + dp[i];

			}
		}
		for (int k = 0; k < times; k++) {
			String line = in.readLine();
			long n = Long.parseLong(line);
			long ini = 1;
			if (n == 1)
				System.out.println(1);
			else
				for (int i = 0; i < dp.length - 1; i++) {
					if (n >= dpSum[i] && n <= dpSum[i + 1]) {
						long num = dpSum[i];
						while (num < n) {
							num += (ini + "").length();
							if (num < n)
								ini++;
						}
						if (ini < 10) {
							System.out.println(ini);
						} else {
							long dif = num - n;
							String cad = (ini) + "";

							System.out.println(cad.charAt((cad.length())
									- (int) (dif + 1)));

						}

						break;
					}
				}

		}

	}

}
