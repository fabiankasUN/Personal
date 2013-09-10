import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shortest {

	// split de array`
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
		String res = in.readLine();
		char letter1 = line.charAt(0);
		char num1 = line.charAt(1);
		char letter2 = res.charAt(0);
		char num2 = res.charAt(1);
		int cont = 0;
		StringBuilder br = new StringBuilder();

		while (letter1 != letter2 && num1 != num2) {
			if (letter1 < letter2 && num1 < num2) {
				br.append("RU").append("\n");
				letter1++;
				num1++;
			} else if (letter1 > letter2 && num1 > num2) {
				br.append("LD").append("\n");
				letter1--;
				num1--;
			} else if (letter1 > letter2 && num1 < num2) {
				br.append("LU").append("\n");
				letter1--;
				num1++;
			} else if (letter1 < letter2 && num1 > num2) {
				br.append("RD").append("\n");
				letter1++;
				num1--;
			}
			cont++;
		}

		if (letter1 == letter2) {
			if (num1 < num2) {
				while (num1 < num2) {
					br.append("U").append("\n");
					num1++;
					cont++;
				}
			} else {
				while (num1 > num2) {
					br.append("D").append("\n");
					num1--;
					cont++;
				}
			}
		} else if (num1 == num2) {
			if (letter1 < letter2) {
				while (letter1 < letter2) {
					br.append("R").append("\n");
					letter1++;
					cont++;
				}
			} else {
				while (letter1 > letter2) {
					br.append("L").append("\n");
					letter1--;
					cont++;
				}
			}
		}
		System.out.println(cont);
		System.out.print(br);
	}

}