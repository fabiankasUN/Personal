package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Commandos {

	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int distancias[][];
	public static final int INF = (Integer.MAX_VALUE - 1) / 2;

	public static void inint(int n) {
		distancias = new int[ n ][ n ];
		for (int i = 0; i < n; i++) {
			Arrays.fill(distancias[i], INF);
			distancias[i][i] = 0;
		}
	}

	static void floyd(int rows, int ini, int fin) {

		for (int k = 0; k < rows; k++) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++) {

					if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];

					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		int times = 1;
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(in.readLine());
			inint(p);
			int c = Integer.parseInt(in.readLine());
			for (int j = 0; j < c; j++) {
				int values[] = atoi(in.readLine());
				distancias[values[0]][values[1]] = 1;
				distancias[values[1]][values[0]] = 1;
			}

			int values[] = atoi(in.readLine());
			int ini = values[0];
			int fin = values[1];

			int res = 0;
			floyd(p, ini, fin);
			for (int k = 0; k < p; k++) {
				if (ini != k && distancias[ini][k] != INF && distancias[k][fin] != INF
						&& distancias[ini][k] + distancias[k][fin] > res) {
					res = distancias[ini][k] + distancias[k][fin];
				}
			}
			out.append("Case " + times++ + ": " + (res) + "\n");
		}
		System.out.print(out);
	}
}
