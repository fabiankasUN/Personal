package Problemas;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class PageHopping {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
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

	public static void floyd(int rows) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				distancias[i][j] = grafo[i][j];
				padres[i][j] = i;
				if (grafo[i][j] == INF || i == j) {
					padres[i][j] = -1;
				}
			}
		}
		for (int k = 0; k < rows; k++) {
			// print(distancias);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++) {

					if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}
		}
	}

	public static int grafo[][];
	public static int distancias[][];
	public static int padres[][];
	public static int n;
	public static int INF = (Integer.MAX_VALUE - 1) / 2;
	public static HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int times = 1;
		while ((line = in.readLine()) != null) {
			if (line.equals("0 0"))
				break;
			tabla = new HashMap<Integer, Integer>();
			int arr[] = atoi(line);
			int cont = 0;
			ArrayList<Point> p = new ArrayList<Point>();
			for (int i = 0; i < arr.length; i += 2) {
				int a = 0, b = 0;
				if (arr[i] == 0 && arr[i + 1] == 0)
					break;
				if (!tabla.containsKey(arr[i])) {
					tabla.put(arr[i], cont);
					a = cont;
					cont++;
				} else {
					a = tabla.get(arr[i]);
				}
				if (!tabla.containsKey(arr[i + 1])) {
					tabla.put(arr[i + 1], cont);
					b = cont;
					cont++;
				} else {
					b = tabla.get(arr[i + 1]);
				}
				p.add(new Point(a, b));
			}
			int n = cont;
			grafo = new int[n][n];
			distancias = new int[n][n];
			padres = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					grafo[i][k] = INF;
				}
			}
			for (int i = 0; i < p.size(); i++) {
				grafo[p.get(i).x][p.get(i).y] = 1;
			}
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					distancias[i][k] = grafo[i][k];
					padres[i][k] = i;
					if (grafo[i][k] == INF || i == k) {
						padres[i][k] = -1;
					}

				}
			}

			floyd(n);
			double sum = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if (i != k) {
						sum += distancias[i][k];
						c++;
					}
				}
			}
			
			// System.out.println(sum);
			System.out.print("Case " + times
					+ ": average length between pages = ");
			System.out.format(Locale.US, "%.3f", sum / c);
			System.out.println(" clicks");
			// System.out.println((double) sum / c);

			times++;
		}
	}

}
