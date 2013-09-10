import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceTower {

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
		int p = Integer.parseInt(in.readLine());
		int der[] = new int[ 101 ];
		int izq[] = new int[ 101 ];
		int rIzq[] = new int[ 101 ];
		int rDer[] = new int[ 101 ];
		int up[] = new int[ 101 ];
		int down[] = new int[ 101 ];
		up[0] = p;
		down[0] = Math.abs(7 - p);
		for (int i = 0; i < n; i++) {
			int values[] = atoi(in.readLine());
			izq[i] = values[0];
			der[i] = values[1];
			rIzq[i] = Math.abs(7 - values[0]);
			rDer[i] = Math.abs(7 - values[1]);
		}
		int cont = 0;
		for (int i = 1; i < n; i++) {
			if (izq[i] != up[0] && der[i] != up[0] && der[i] != down[0] && izq[i] != down[0]) {
				cont++;
			}

		}
		cont++;
		if (cont < n) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}

}
