package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Wormholes {

	public static class BellmanFord {

		public static ArrayList<arista> grafo[];// lista de adyacencia
		public static int distancia[];// distancias minimas
		public static int previo[];// encontrar camino de vuelta
		public static final int INF = ((Integer.MAX_VALUE) / 2) + 1;// infinito
		public static int V;// vertices
		public static boolean existeCiclo;

		public void inint(int v) {// inicializacion
			this.V = v;
			grafo = new ArrayList[ V ];
			distancia = new int[ V ];
			previo = new int[ V ];
			existeCiclo = false;
			for (int i = 0; i < V; i++) {
				grafo[i] = new ArrayList<arista>();
				distancia[i] = INF;// distacias en infinito
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
			if (distancia[inicio] + peso < distancia[fin]) {
				distancia[fin] = distancia[inicio] + peso;
				previo[fin] = inicio;
				return true;
			}
			return false;
		}

		public void bellmanFord(int nodoInicial) {
			for (int i = 0; i < distancia.length; i++) {
				distancia[i] = INF;
				previo[i] = -1;
			}
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
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo[i].size(); j++) {
					int fin = grafo[i].get(j).destino;
					int peso = grafo[i].get(j).peso;
					if (relajacion(i, fin, peso)) {
						existeCiclo = true;
						return;
					}
				}
			}
		}

		public void add(int a, int b, int peso) {
			grafo[a].add(new arista(b, peso));
		}
	}

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int values[] = atoi(in.readLine());
			int vertices = values[0];
			BellmanFord bellman = new BellmanFord();
			bellman.V = vertices;
			bellman.inint(vertices);
			for (int j = 0; j < values[1]; j++) {
				int date[] = atoi(in.readLine());
				bellman.add(date[0], date[1], date[2]);
			}
			bellman.bellmanFord(0);
			if (bellman.existeCiclo) {
				out.append("possible\n");
			} else {
				out.append("not possible\n");
			}
		}
		System.out.print(out);
	}
}
