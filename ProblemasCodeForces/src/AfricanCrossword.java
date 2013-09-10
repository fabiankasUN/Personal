import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class AfricanCrossword {

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

	public static class nodo {
		int sum;
		int antX;
		int antY;

		public nodo(int sum, int antX, int antY) {
			this.sum = sum;
			this.antX = antX;
			this.antY = antY;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n[] = atoi(in.readLine().trim());
		char arr[][] = new char[ n[0] ][ n[1] ];
		boolean es[][] = new boolean[ n[0] ][ n[1] ];

		for (int i = 0; i < n[0]; i++) {
			arr[i] = in.readLine().trim().toCharArray();
		}

		for (int i = 0; i < arr.length; i++) {
			nodo nums[] = new nodo[ 27 ];
			for (int j = 0; j < arr[0].length; j++) {
				if (nums[arr[i][j] - 'a'] == null)
					nums[arr[i][j] - 'a'] = new nodo(0, i, j);

				nums[arr[i][j] - 'a'].sum++;
				if (nums[arr[i][j] - 'a'].sum > 1) {
					es[i][j] = true;
					es[nums[arr[i][j] - 'a'].antX][nums[arr[i][j] - 'a'].antY] =true;
				}
			}
		}
		for (int i = 0; i < arr[0].length; i++) {
			nodo nums[] = new nodo[ 27 ];
			for (int j = 0; j < arr.length; j++) {
				if (nums[arr[j][i] - 'a'] == null)
					nums[arr[j][i] - 'a'] = new nodo(0, j, i);

				nums[arr[j][i] - 'a'].sum++;
				if (nums[arr[j][i] - 'a'].sum > 1) {
					es[j][i] = true;
					es[nums[arr[j][i] - 'a'].antX][nums[arr[j][i] - 'a'].antY] =true;
				}
			}
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (es[i][j] == false) {
					System.out.print(arr[i][j]);
				}
			}
		}
		

	}
}
