import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hexadecimaltheorem {

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
		int n = Integer.parseInt(line);
		int k = 1;
		int p = 1;
		int w;
		int arr[] = new int[ 47 ];
		arr[0] = 0;
		arr[1] = 1;
		int index = 2;
		while (k < 1000000000) {
			arr[index] = p;
			w = p;
			p = p + k;
			k = w;
			index++;
		}
		int np = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				np = i;
				break;
			}
		}
		if (n == 0) {
			System.out.println("0 0 0 ");
		} else if (n == 1) {
			System.out.println("0 0 1");
		} else if (n == 2) {
			System.out.println("0 1 1");
		} else {
			System.out.println(arr[np - 1] + " " + arr[np - 3] + " " + arr[np - 4]);
		}
	}

}
