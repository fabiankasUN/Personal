import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class TheWall {

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

	public static BigInteger MCM(int a, int b) {
		BigInteger c = new BigInteger(a + "");
		BigInteger d = new BigInteger(b + "");
		return (c.divide(d.gcd(c))).multiply(d);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int values[] = atoi(line);
		int n = values[0];
		int m = values[1];
		int a = values[2];
		int b = values[3];
		
		BigInteger n1 = new BigInteger(a + "");
		BigInteger n2 = new BigInteger(b + "");
		BigInteger c = new BigInteger((b - a) + "");
		BigInteger mcm = MCM(n, m);
		BigInteger res = c.divide(mcm);

		if (n1.mod(mcm).toString().equals("0") || n2.mod(mcm).toString().equals("0")) {
			res = res.add(new BigInteger("1"));
		}
		System.out.println(res);
	}
}
