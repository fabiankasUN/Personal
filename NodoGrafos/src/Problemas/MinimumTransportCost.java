package Problemas;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MinimumTransportCost {
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

	public static void print(long arr[][],int n) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				System.out.print(arr[j][k] + "  ");
			}
			System.out.println();
		}
	}

	public static void imprimir(long inicio, long fin) {
		Stack<Long> pila = new Stack<Long>();
		pila.add(fin);
		while (padres[(int) inicio][(int) fin] != -1) {
			pila.add(padres[(int) inicio][(int) fin]);
			fin = padres[(int) inicio][(int) fin];
		}

		while (!pila.isEmpty()) {
			System.out.print((pila.pop() + 1));
			if (!pila.isEmpty())
				System.out.print("-->");
		}
		System.out.println();

	}

	public static long grafo[][];
	public static long distancias[][];
	public static long padres[][];
	public static long peaje[];
	public static long INF = 0xfffffff;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		int t = 0;
		int MAX = 505;
		grafo = new long[MAX][MAX];
		distancias = new long[MAX][MAX];
		padres = new long[MAX][MAX];
		peaje = new long[MAX];

		for (int i = 0; i < n; i++) {
			if (t > 0)
				System.out.println();
			t++;
			String cad[] = scan.nextLine().split(" ");
			for (int j = 0; j < cad.length; j++) {
				for (int k = 0; k < cad.length; k++) {
					if (j != k)
						grafo[j][k] = INF;
				}
			}
			
			for (int j = 0; j < cad.length; j++) {
				if (Long.parseLong(cad[j]) != -1)
					grafo[0][j] = Long.parseLong(cad[j]);
			}

			for (int j = 1; j < cad.length; j++) {
				cad = scan.nextLine().split(" ");
				for (int k = 0; k < cad.length; k++) {
					if (Long.parseLong(cad[k]) != -1)
						grafo[j][k] = Long.parseLong(cad[k]);
				}
			}
			// cad = scan.nextLine().split(" ");
			for (int j = 0; j < cad.length; j++) {
				peaje[j] = scan.nextLong();
			}
			scan.nextLine();
			for (int j = 0; j < cad.length; j++) {
				for (int k = 0; k < cad.length; k++) {
					if (grafo[j][k] != INF && grafo[j][k] != 0) {
						grafo[j][k] += peaje[k];
					}
				}
			}
			//print(grafo,cad.length);
			floyd(cad.length);
			//print(p,cad.length);
			String line;
			int times = 0;
			// scan.nextLine();
			do {
				line = scan.nextLine();
				if (line.equals("") || line == null)
					break;
				if (times++ > 0)
					System.out.println();
				String c[] = line.split(" ");
				int inicio = Integer.parseInt(c[0])-1;// scan.nextInt();
				int fin = Integer.parseInt(c[1])-1;
				System.out.println("From " + (inicio + 1) + " to " + (fin + 1)
						+ " :");
				System.out.print("Path: ");
				 imprimir(inicio, fin);
				if (distancias[inicio][fin] == 0)
					System.out.println("Total cost : " + 0);
				else
					System.out.println("Total cost : "
							+ (distancias[inicio][fin] - peaje[fin]));

			} while (!line.equals("") && line != null);

		}
	}
}
