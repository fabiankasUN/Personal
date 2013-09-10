import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SummationofMultiples {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
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
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/"
				+ (Runtime.getRuntime().totalMemory() >> 20) + " MB";
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

	public static BigInteger res(int num) {
		BigInteger a = new BigInteger(num + "");
		BigInteger b = a.multiply(a.add(new BigInteger("1")));
		return b.divide(new BigInteger("2"));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(in.readLine());
			int a = num / 3;
			int b = num / 5;
			int c = num / 15;
			BigInteger aa = res(a).multiply(new BigInteger("3"));
			BigInteger bb = res(b).multiply(new BigInteger("5"));
			BigInteger cc = res(c).multiply(new BigInteger("15"));
			BigInteger total = aa.add(bb);
			total = total.subtract(cc);
			if (num % 3 == 0)
				total = total.subtract(new BigInteger(num + ""));
			if (num % 5 == 0)
				total = total.subtract(new BigInteger(num + ""));
			if (num % 15 == 0)
				total = total.add(new BigInteger(num + ""));
			System.out.println(total);

		}
	}

}
