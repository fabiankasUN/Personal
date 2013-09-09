package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsterixandObelix {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int grafo[][];
	public static int distancias[][];
	public static int padres[][];
	public static int INF = (Integer.MAX_VALUE - 1) / 2;

	public static void floyd(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				distancias[i][k] = grafo[i][k];
				padres[i][k] = i;
				if (grafo[i][k] == INF || i == k) {
					padres[i][k] = -1;
				}

			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = in.readLine()) != null) {
			if (line.equals("0 0 0"))
				break;
			int values[] = atoi(line);
			int n = values[0];
			int m = values[1];
			int q = values[2];
			int costos[] = atoi(in.readLine());
			grafo = new int[n][n];
			distancias = new int[n][n];
			padres = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					grafo[i][k] = INF;
				}
			}
			for (int i = 0; i < m; i++) {
				String dates[] = in.readLine().split(" ");
				int a = Integer.parseInt(dates[0]) - 1;
				int b = Integer.parseInt(dates[1]) - 1;
				int peso = Integer.parseInt(dates[2]);
				grafo[a][b] = peso;
				grafo[b][a] = peso;

			}
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if(grafo[i][k]!=INF){
						grafo[i][k]+=costos[i];
					}
				}
			}
			floyd(n);
			
			/*for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					System.out.print(distancias[i][k]+"  ");
				}
				System.out.println();
			}*/

			for (int i = 0; i < q; i++) {
				String dates[] = in.readLine().split(" ");
				int a = Integer.parseInt(dates[0]) - 1;
				int b = Integer.parseInt(dates[1]) - 1;
				System.out.println(distancias[a][b]);
			}
		}
	}

}
