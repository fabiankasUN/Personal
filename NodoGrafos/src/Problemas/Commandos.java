package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Commandos {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static class Floyd {

		public static int distancias[][];
		// public static int padres[][];
		public static final int INF = (Integer.MAX_VALUE - 1) / 2;

		public void inint(int n) {
			// grafo = new int[ n ][ n ];
			distancias = new int[ n ][ n ];
			// padres = new int[ n ][ n ];
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if (i != k)
						distancias[i][k] = INF;
					// grafo[i][k] = INF;
				}
			}
		}

		int floyd(int rows, int ini, int fin) {
			int max = 0;

			for (int k = 0; k < rows; k++) {
				// print(distancias);
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < rows; j++) {

						if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
							distancias[i][j] = distancias[i][k] + distancias[k][j];
							// padres[i][j] = padres[k][j];
							if (distancias[i][j] != INF && distancias[j][fin] != INF && i == ini
									&& (distancias[i][j] + distancias[j][fin]) > max) {
								max = (distancias[i][j] + distancias[j][fin]);
							}
						}
						if (distancias[i][j] != INF && distancias[j][fin] != INF && i == ini
								&& (distancias[i][j] + distancias[j][fin]) > max) {
							max = (distancias[i][j] + distancias[j][fin]);
						}
					}
				}
			}
			// print(distancias);
			return max;

			// System.out.println();
			// print(padres);
		}

		public static void print(int grafo[][]) {
			for (int i = 0; i < grafo.length; i++) {
				for (int k = 0; k < grafo.length; k++) {
					System.out.print(grafo[i][k] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int n = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		int times = 1;
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(in.readLine());
			Floyd grafo = new Floyd();
			grafo.inint(p);
			int c = Integer.parseInt(in.readLine());
			for (int j = 0; j < c; j++) {
				int values[] = atoi(in.readLine());
				grafo.distancias[values[0]][values[1]] = 1;
				grafo.distancias[values[1]][values[0]] = 1;
			}

			int values[] = atoi(in.readLine());
			int ini = values[0];
			int fin = values[1];
			int res = grafo.floyd(p, ini, fin);
			out.append("Case " + times++ + ": " + (res) + "\n");
		}
		System.out.print(out);
	}
}
