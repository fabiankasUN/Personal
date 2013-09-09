package Problemas;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class prueba {

	public static class Dijkstra {

		public static class arista implements Comparable<arista> {
			int vecino;// etiqueta del nodo
			double peso;// etiqueta del peso

			public arista(int vecino, double peso) {// constructor
				this.vecino = vecino;
				this.peso = peso;

			}

			public String toString() {
				return vecino + " peso " + peso;
			}

			@Override
			public int compareTo(arista o) {// comparable para la priority queue
				if (o.peso > this.peso)
					return -1;
				else if (o.peso < this.peso)
					return 1;
				return 0;
			}

		}

		public static final int INF = Integer.MAX_VALUE;
		public static ArrayList<arista> adj[];// grafo representado como listas
												// enlazadas de nodos
		public static double distancia[];// lleva las distancias minimas a cada
											// nodo
		public static boolean visitado[];// lleva los visitados, para no
											// repetirlos
		public static int previo[];// caminos pra poder devolverse y conocer el
									// camino
		public static PriorityQueue<arista> Q;// cola de prioridad
		int V;// num vertices

		public void inint() {// inicializacion de vertices
			Q = new PriorityQueue<arista>();// cola de prioridad
			adj = new ArrayList[ V ];// listas de adyacencia del tamaño de
										// numero de vertices
			distancia = new double[ V ];// lleva las distancias minimas a cada
										// nodo
			visitado = new boolean[ V ];// lleva si un nodo es visitado o no
			previo = new int[ V ];// sirve para volver de cualquier nodo al
									// inicio
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<arista>();
				distancia[i] = Integer.MAX_VALUE; // inicializamos todas las
													// distancias con
				visitado[i] = false; // inicializamos todos los vértices como no
				previo[i] = -1; // inicializamos el previo del vértice i con -1
			}
		}

		public void dijkstra(arista inicial) {// manda el nodo inicial para
												// marcarlo y ponerlo pon peso 0

			Q.add(inicial);// metemos nodo icicial a la cola
			distancia[inicial.vecino] = 0;// la distancia de el a el mismo es 0

			while (!Q.isEmpty()) {
				arista ac = Q.poll();
				if (visitado[ac.vecino])
					continue;// para que no revisite vertices
				visitado[ac.vecino] = true;// marca el vertice actual
				/**
				 * el ciclo avanza por todos los vertices adyacentes al nodo
				 * actual, usando la lista de nodos
				 */
				for (int i = 0; i < adj[ac.vecino].size(); i++) {
					arista adyacente = adj[ac.vecino].get(i);
					if (!visitado[adyacente.vecino]) {// en caso que no esté
														// visitado ya
						minPeso(ac.vecino, adyacente.vecino, adyacente.peso);
					}
				}
			}
		}

		public void minPeso(int actual, int adyacente, double peso) {
			/*
			 * Si la distancia del origen al vertice actual + peso de su arista
			 * es menor a la distancia del origen al vertice adyacente
			 */
			if (distancia[actual] + peso < distancia[adyacente]) {
				distancia[adyacente] = distancia[actual] + peso; // cambiamos
				// la distancia del vertice al inicio
				previo[adyacente] = actual;// a su vez actualizamos el vertice
											// previo
				Q.add(new arista(adyacente, distancia[adyacente]));//
			}
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
				System.out.println("distancia al nodo " + i + " es :" + distancia[i]);
			}
		}

		public static void add(int a, int b, double peso) {
			adj[a].add(new arista(b, peso));
		}

	}

	public static double dist(double lt1, double ln1, double lt2, double ln2) {
		double D = Math.acos(Math.cos(lt1) * Math.cos(lt2) * Math.cos(ln1 - ln2) + Math.sin(lt1) * Math.sin(lt2)) * R;
		return D;
	}

	public static double R = 4000;
	public static double PI = Math.PI;

	public static class city {
		double lt;
		double ln;
		int index;

		public city(double lt, double ln, int name) {
			this.lt = (lt * PI) / 180;
			this.ln = (ln * PI) / 180;
			this.index = name;
		}

		public static void main(String[] args) {

		}
	}

	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	static double shortestTrip(int[] latitude, int[] longitude, String[] canTravel, int origin, int destination) {
		Dijkstra grafo = new Dijkstra();
		grafo.V = latitude.length;
		grafo.inint();
		for (int i = 0; i < canTravel.length; i++) {
			int nums[] = atoi(canTravel[i]);
			city temp = new city(latitude[i], longitude[i], i);
			for (int j = 0; j < nums.length; j++) {
				city actual = new city(latitude[nums[j]], longitude[nums[j]], nums[j]);
				grafo.add(i, nums[j], dist(temp.lt, actual.lt, temp.ln, actual.ln));
			}

		}
		grafo.dijkstra(new Dijkstra.arista(origin, 0));
		return grafo.distancia[destination];
	}

	public static void main(String[] args) {
		int l[] = { 0, 0, 70 };
		int lo[] = { 90, 0, 45 };
		String n[] = { "1 2", "0 2", "0 1" };
		int o = 0;
		int f = 1;
		System.out.println(shortestTrip(l, lo, n, o, f));
	}

}
