package AlgoritmosDeGrafos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BellmanFord {

	public static ArrayList<arista> grafo[];//lista de adyacencia
	public static int distancia[];//distancias minimas
	public static int previo[];//encontrar camino de vuelta
	public static final int INF = ((Integer.MAX_VALUE)/2)+1;//infinito
	public static int V;//vertices

	public void inint(int v) {//inicializacion
		this.V = v;
		grafo = new ArrayList[V];
		distancia = new int[V];
		previo = new int[V];
		for (int i = 0; i < V; i++) {
			grafo[i] = new ArrayList<arista>();
			distancia[i] = INF;//distacias en infinito
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
			return destino + " peso "+peso;
		}

	}

	public boolean relajacion(int inicio, int fin, int peso) {//metodo que relaja las aristas
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

		/*
		 * se hace la primera relajacion 
		 * de las aristas
		 * */
		for (int  k= 0; k<V-1; k++) {
			for (int i = 0; i < grafo.length; i++) {// hacemos el primer paso de relajacion
				for (int j = 0; j < grafo[i].size(); j++) {//
					int fin = grafo[i].get(j).destino;
					int peso = grafo[i].get(j).peso;
					relajacion(i, fin, peso);
				}
			}
		}
		
		/*
		 * se vuelve a relajar todo
		 * si da mejorado es por que existen
		 * ciclos negativos
		 * 
		 * */
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo[i].size(); j++) {
				int fin = grafo[i].get(j).destino;
				int peso = grafo[i].get(j).peso;
				if (relajacion(i, fin, peso)) {
					System.out.println("existe ciclo");
					return;
				}
			}
		}
		
		impresionDistanciasMinimas();//impresion valores de caminos minimos
		print(2);//camino a  un nodo
	}

	public void add(int a, int b, int peso) {
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

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aristas = scan.nextInt();// num aristas
		int vertices = scan.nextInt();// num vertices

		BellmanFord bellman = new BellmanFord();
		bellman.V = vertices;// se mira el numero de vertices para inicializar
		bellman.inint(vertices);// se inicializan las variables
		for (int i = 0; i < aristas; i++) {// va agregando vertices a -- > b con
											// su peso
			int a = scan.nextInt();
			int b = scan.nextInt();
			int peso = scan.nextInt();
			bellman.add(a, b, peso);
		}
		int inicio = scan.nextInt();// vertice de inicio
		bellman.bellmanFord(inicio);

	}
	/*
	EJEMPLO DE INPUT
	9 5
	0 1 7
	0 3 2
	1 2 1
	1 3 2
	2 4 4
	3 1 3
	3 2 8
	3 4 5
	4 2 5
	0

	CICLO NEGATIVO
	3 3
	0 1 500
	1 2 5
	2 1 -10
	0
	*/

}
