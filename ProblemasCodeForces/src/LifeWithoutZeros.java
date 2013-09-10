import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LifeWithoutZeros {

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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		long n = Integer.parseInt(line);
		long m = Integer.parseInt(in.readLine());
		long r1 = n + m;
		String a = "";
		String b = "";
		String c = "";
		String cad = n + "";
		String cad2 = m + "";
		String cad3 = r1 + "";
		for (int i = 0; i < (n + "").length(); i++) {
			if (cad.charAt(i) != '0') {
				a = a + cad.charAt(i) + "";
			}
		}
		for (int i = 0; i < (m + "").length(); i++) {
			if (cad2.charAt(i) != '0') {
				b = b + cad2.charAt(i) + "";
			}
		}
		for (int i = 0; i < (r1 + "").length(); i++) {
			if (cad3.charAt(i) != '0') {
				c = c + cad3.charAt(i) + "";
			}
		}
		if (Long.parseLong(a) +Long.parseLong(b) == Long.parseLong(c)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
