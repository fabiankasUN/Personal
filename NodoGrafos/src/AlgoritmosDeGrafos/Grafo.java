package AlgoritmosDeGrafos;

import java.util.ArrayList;

import ClasesAux.arista;

public class Grafo {
	
	
	public static ArrayList<arista> grafo[];//lista de adyacencia
	public static int distancia[];//distancias minimas
	public static int previo[];//encontrar camino de vuelta
	public static final int INF = ((Integer.MAX_VALUE)/2)+1;//infinito
	public static int V;//vertices
	
	public class arista implements Comparable<arista> {
		int vecino;// etiqueta del nodo
		int peso;// etiqueta del peso

		public arista(int vecino, int peso) {// constructor
			this.vecino = vecino;
			this.peso = peso;

		}

		public String toString() {
			return vecino + " ";
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
	public Grafo(int V,int E){
		
	}

}
