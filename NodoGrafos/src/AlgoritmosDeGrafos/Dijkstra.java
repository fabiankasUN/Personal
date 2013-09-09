package AlgoritmosDeGrafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

import ClasesAux.arista;

public class Dijkstra {

	public static class arista implements Comparable<arista> {
		int vecino;// etiqueta del nodo
		int peso;// etiqueta del peso

		public arista(int vecino, int peso) {// constructor
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
	public static int distancia[];// lleva las distancias minimas a cada nodo
	public static boolean visitado[];// lleva los visitados, para no repetirlos
	public static int previo[];// caminos pra poder devolverse y conocer el
								// camino
	public static PriorityQueue<arista> Q;// cola de prioridad
	int V;// num vertices

	public void inint() {// inicializacion de vertices
		Q = new PriorityQueue<arista>();// cola de prioridad
		adj = new ArrayList[ V ];// listas de adyacencia del tamaño de numero de
									// vertices
		distancia = new int[ V ];// lleva las distancias minimas a cada nodo
		visitado = new boolean[ V ];// lleva si un nodo es visitado o no
		previo = new int[ V ];// sirve para volver de cualquier nodo al inicio

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<arista>();
		}
	}

	public void dijkstra(arista inicial) {// manda el nodo inicial para marcarlo
											// y ponerlo pon peso 0

		for (int i = 0; i < V; i++) {
			distancia[i] = Integer.MAX_VALUE; // inicializamos todas las
												// distancias con
			visitado[i] = false; // inicializamos todos los vértices como no
			previo[i] = -1; // inicializamos el previo del vértice i con -1
		}

		Q.add(inicial);// metemos nodo icicial a la cola
		distancia[inicial.vecino] = 0;// la distancia de el a el mismo es 0

		while (!Q.isEmpty()) {
			arista ac = Q.poll();
			if (visitado[ac.vecino])
				continue;// para que no revisite vertices
			visitado[ac.vecino] = true;// marca el vertice actual
			/**
			 * el ciclo avanza por todos los vertices adyacentes al nodo actual,
			 * usando la lista de nodos
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

	public void minPeso(int actual, int adyacente, int peso) {
		/*
		 * Si la distancia del origen al vertice actual + peso de su arista es
		 * menor a la distancia del origen al vertice adyacente
		 */
		if (distancia[actual] + peso < distancia[adyacente]) {
			distancia[adyacente] = distancia[actual] + peso; // cambiamos
			// la distancia del vertice al inicio
			previo[adyacente] = actual;// a su vez actualizamos el vertice
										// previo
			Q.add(new arista(adyacente, distancia[adyacente]));//
		}
	}

	/**
	 * @param destino
	 *            : nodo destino
	 * 
	 *            imprime los nodos por los que hay que pasar para llegar al
	 *            inicio
	 * */

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

	public static void add(int a, int b, int peso) {
		adj[a].add(new arista(b, peso));
	}

	/**
	 * metodo de prueba
	 * 
	 * */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aristas = scan.nextInt();// num aristas
		int vertices = scan.nextInt();// num vertices

		Dijkstra algoDijktra = new Dijkstra();// se crea el grafo
		algoDijktra.V = vertices;// se mira el numero de vertices para
									// inicializar
		// las listas enlazadas
		algoDijktra.inint();// se inicializan las variables

		for (int i = 0; i < aristas; i++) {// va agregando vertices a -- > b con
											// su peso
			int a = scan.nextInt();
			int b = scan.nextInt();
			int peso = scan.nextInt();
			algoDijktra.add(a, b, peso);
		}
		int inicio = scan.nextInt();// vertice de inicio
		int fin = scan.nextInt();

		algoDijktra.dijkstra(new arista(inicio, 0));// realiza la busqueda de
													// camino corto
		algoDijktra.print(fin);// imprime el camino desde el nodo inicio hasta
								// algun otro nodo

		algoDijktra.impresionDistanciasMinimas();

		algoDijktra.dijkstra(new arista(4, 0));// realiza la busqueda de camino
												// corto
		algoDijktra.print(fin);// imprime el camino desde el nodo inicio hasta
								// algun otro nodo

		algoDijktra.impresionDistanciasMinimas();

	}
}
