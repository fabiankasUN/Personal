import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigSegment {

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
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean a = false;
		int num = -1;
		int index = 0;
		int ini[] = new int[ n ];
		int fin[] = new int[ n ];

		for (int i = 0; i < n; i++) {
			int values[] = atoi(in.readLine());
			ini[i] = values[0];
			fin[i] = values[1];
			if (ini[i] <= min && fin[i] >= max) {
				if (ini[i] == min && fin[i] == max) {
				} else {
					min = ini[i];
					max = fin[i];
					a = true;
					index = i;

				}
				
			} else if (ini[i] < min || fin[i] > max) {
				min = ini[i];
				max = fin[i];
				a = false;

			}
		}
		if (a) {
			System.out.println(index + 1);
		} else {
			System.out.println(-1);
		}
	}
}
