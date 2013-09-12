package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class XYZZY {

	public static class bellmanFord {
		public static ArrayList<arista> grafo[];// lista de adyacencia
		public static int distancia[];// distancias minimas
		public static int existeCamino[];// distancias minimas
		public static int previo[];// encontrar camino de vuelta
		public static final int INF = (Integer.MIN_VALUE);// infinito
		public static int V;// vertices

		public void inint(int v) {// inicializacion
			this.V = v;
			grafo = new ArrayList[ V ];
			distancia = new int[ V ];
			existeCamino = new int[ V ];
			previo = new int[ V ];
			for (int i = 0; i < V; i++) {
				grafo[i] = new ArrayList<arista>();
				distancia[i] = INF;// distacias en infinito
				existeCamino[i] = INF;
				previo[i] = -1;
			}
		}

		public static class arista implements Comparable<arista> {
			public int destino;
			public int peso;

			public arista(int x, int y) {
				this.destino = x;
				this.peso = y;
			}

			@Override
			public int compareTo(arista c) {
				if (this.destino < c.destino)
					return -1;
				else if (this.destino > c.destino)
					return 1;
				else if (this.peso < c.peso)
					return -1;
				else if (this.peso > c.peso)
					return 1;
				return 0;
			}

			public String toString() {
				return destino + " peso " + peso;
			}

		}

		public boolean relajacion(int inicio, int fin, int peso) {
			if (distancia[inicio] != INF && distancia[inicio] + peso > distancia[fin] && (distancia[inicio] + peso + 100 > 0)) {
				distancia[fin] = distancia[inicio] + peso;
				previo[fin] = inicio;
				return true;
			}
			return false;
		}

		public static boolean ciclo = false;;

		public void bellmanFord(int nodoInicial) {
			distancia[nodoInicial] = 0;
			for (int k = 0; k < V - 1; k++) {
				for (int i = 0; i < grafo.length; i++) {
					for (int j = 0; j < grafo[i].size(); j++) {//
						int fin = grafo[i].get(j).destino;
						int peso = grafo[i].get(j).peso;
						relajacion(i, fin, peso);
					}
				}
			}
			for (int i = 0; i < distancia.length; i++) {
				existeCamino[i] = distancia[i];
			}
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo[i].size(); j++) {
					int fin = grafo[i].get(j).destino;
					int peso = grafo[i].get(j).peso;
					if (relajacion(i, fin, peso)) {
						ciclo = true;
					}
				}
			}
			if (ciclo == true) {
				for (int i = 0; i < distancia.length; i++) {
					if (distancia[i] > existeCamino[i]) {
						visited = new boolean[ V ];
						if (dfs(i)) {
							esta = true;

						}
						break;
					}
				}
			}

			// impresionDistanciasMinimas();// impresion valores de caminos
			// minimos
		}

		public static boolean visited[];

		public static boolean dfs(int ini) {
			if (ini == V - 1) {
				return true;
			} else {
				for (int i = 0; i < grafo[ini].size(); i++) {
					int c = grafo[ini].get(i).destino;
					if (!visited[c]) {
						visited[c] = true;
						boolean a = dfs(c);
						if (a)
							return true;
					}
				}
			}
			return false;
		}

		public void impresionDistanciasMinimas() {
			for (int i = 0; i < distancia.length; i++) {
				System.out.println("distancia al nodo " + i + " es :" + distancia[i]);
			}
		}

		public void add(int a, int b, int peso) {
			grafo[a].add(new arista(b, peso));
		}

		public static boolean esta;
	}

	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		StringBuilder out = new StringBuilder();

		while (scan.hasNext()) {
			int vertices = scan.nextInt();
			if (vertices == -1)
				break;

			if (vertices > 0) {
				bellmanFord bellman = new bellmanFord();
				bellman.V = vertices;
				bellman.inint(vertices);
				bellman.ciclo = false;
				bellman.esta = false;
				int matriz[][] = new int[ vertices ][];
				int energy[] = new int[ vertices ];
				for (int i = 0; i < vertices; i++) {
					energy[i] = scan.nextInt();
					int p = scan.nextInt();
					matriz[i] = new int[ p ];
					for (int j = 0; j < p; j++) {
						matriz[i][j] = scan.nextInt();
					}
				}
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						bellman.add(i, matriz[i][j] - 1, energy[matriz[i][j] - 1]);
					}
				}
				bellman.bellmanFord(0);
				if (bellman.distancia[vertices - 1] != bellmanFord.INF || (bellman.ciclo && bellman.esta)) {
					out.append("winnable\n");

				} else {
					out.append("hopeless\n");
				}
			}
		}
		System.out.print(out);
	}

}
