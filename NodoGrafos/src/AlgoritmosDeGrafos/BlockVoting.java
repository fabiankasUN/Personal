package AlgoritmosDeGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlockVoting {

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

	public static int max = 0;
	public static int arr[];
	public static boolean visited[];
	public static int promedio = 0;

	public static void dfs(int pivot, int sum, String res, int index, int num) {
		if (num == 2) {

		} else
			for (int i = index + 1; i < arr.length; i++) {
				if (i != pivot && !visited[i]) {
					if (sum + arr[i] <= promedio && sum + arr[i] + arr[pivot] > promedio) {
						max++;
						visited[i] = true;
						//System.out.println(res + "" + arr[i]);
						dfs(pivot, sum + arr[i], res + "" + arr[i], i, num + 1);
						visited[i] = false;
					} else if (sum + arr[i] < promedio) {
						visited[i] = true;
						// System.out.println(res + "" + arr[i]);
						dfs(pivot, sum + arr[i], res + "" + arr[i], i, num + 1);
						visited[i] = false;
					}
				}
			}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++) {
			arr = atoi(in.readLine());
			//Arrays.sort(arr);
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j];
			}
			promedio = sum / 2;

			for (int j = 0; j < arr.length; j++) {
				max = 0;
				visited = new boolean[ arr.length ];
				dfs(1, 0, "", -1, 0);
				System.out.println(max);
			}
		}
	}
}
