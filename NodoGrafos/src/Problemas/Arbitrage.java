package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import AlgoritmosDeGrafos.BellmanFord.arista;

public class Arbitrage {

	public static class BellmanFord {

		public static ArrayList<arista> grafo[];// lista de adyacencia
		public static double distancia[];// distancias minimas
		public static int previo[];// encontrar camino de vuelta
		public static final int INF = Integer.MAX_VALUE;// infinito
		public static int V;// vertices

		public void inint(int v) {// inicializacion
			this.V = v;
			grafo = new ArrayList[V];
			distancia = new double[V];
			previo = new int[V];
			for (int i = 0; i < V; i++) {
				grafo[i] = new ArrayList<arista>();
				distancia[i] = Double.POSITIVE_INFINITY;// distacias en
														// oinfinito
				previo[i] = -1;
			}
		}

		public static class arista implements Comparable<arista> {
			public int destino;
			public double peso;

			public arista(int x, double y) {
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

		public boolean relajacion(int inicio, int fin, double peso) {
			if (distancia[inicio]*peso < distancia[fin]) {
				distancia[fin] = distancia[inicio] * peso;
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

			/*
			 * se hace la primera relajacion de las aristas
			 */
			for (int k = 0; k < V - 1; k++) {
				for (int i = 0; i < grafo.length; i++) {// hacemos el primer
														// paso de relajacion
					for (int j = 0; j < grafo[i].size(); j++) {//
						int fin = grafo[i].get(j).destino;
						double peso = grafo[i].get(j).peso;
						relajacion(i, fin, peso);
					}
				}
			}

			/*
			 * se vuelve a relajar todo si da mejorado es por que existen ciclos
			 * negativos
			 */
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo[i].size(); j++) {
					int fin = grafo[i].get(j).destino;
					double peso = grafo[i].get(j).peso;
					if (relajacion(i, fin, peso)) {
						System.out.println("existe ciclo");
						return;
					}
				}
			}

			impresionDistanciasMinimas();// impresion valores de caminos minimos
			print(2);// camino a un nodo
		}

		public void add(int a, int b, double peso) {
			grafo[a].add(new arista(b, peso));
		}

		void print(int destino) {
			Stack<Integer> pila = new Stack<Integer>();
			pila.push(destino);
			while (previo[destino] != -1) {// imprime los nodos por donde pasa
				pila.push(previo[destino]);
				destino = previo[destino];// cambia el destino anterior
			}
			while (!pila.isEmpty()) {
				System.out.print(pila.pop() + " ");
			}
			System.out.println();

		}

		public void impresionDistanciasMinimas() {
			for (int i = 0; i < distancia.length; i++) {
				System.out.println("distancia al nodo " + i + " es :"
						+ distancia[i]);
			}
		}

	}

	public static ArrayList<arista> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		BellmanFord bellman = new BellmanFord();
		bellman.inint(n);
		for (int i = 0; i < n; i++) {
			String cad = in.readLine().trim();
			
			StringTokenizer token = new StringTokenizer(cad," ");
			String arr[]=new String[token.countTokens()];
			int p=0;
			while (token.hasMoreTokens()) {
				arr[p++]=token.nextToken();
				
			}
			int k = 0;
			for (int j = 0; j < arr.length; j++) {
				if (k == i)
					k++;
				bellman.add(i, k, Double.parseDouble(arr[j]));
				k++;
			}
		}		
		bellman.bellmanFord(0);
		bellman.impresionDistanciasMinimas();

	}
}
