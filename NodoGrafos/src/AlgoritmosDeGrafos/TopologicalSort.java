package AlgoritmosDeGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static ArrayList<arista> grafo[];// grafo
	public static int IN_Degree[];// nodos de entrada desde otros nodos al nodo
									// i

	public static int v;// numero de nodos

	public void init(int v) {
		grafo = new ArrayList[v];
		IN_Degree = new int[v];
		for (int i = 0; i < grafo.length; i++) {
			grafo[i] = new ArrayList<arista>();
		}
	}

	public void topologicalSort() {
		Queue<Integer> cola = new LinkedList<Integer>();
		for (int i = 0; i < IN_Degree.length; i++) {
			if (IN_Degree[i] == 0) {
				cola.add(i);
			}
		}
		while (!cola.isEmpty()) {
			int actual = cola.poll();
			System.out.println((char)(actual+'a'));
			for (int i = 0; i < grafo[actual].size(); i++) {
				int vecino = grafo[actual].get(i).destino;
				IN_Degree[vecino]--;
				if (IN_Degree[vecino] == 0) {
					cola.add(vecino);
				}
			}
		}
	}

	public void add(int a, int b) {
		grafo[a].add(new arista(b));
		IN_Degree[b]++;// numero de
	}

	public static class arista {
		public int destino;

		public arista(int x) {
			this.destino = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(in.readLine().trim());
		int aristas = Integer.parseInt(in.readLine().trim());
		TopologicalSort sort = new TopologicalSort();
		sort.init(v);

		for (int i = 0; i < aristas; i++) {
			String cad[] = in.readLine().trim().split(" ");
			int origen = Integer.parseInt(cad[0]);
			int destino = Integer.parseInt(cad[1]);
			sort.add(origen, destino);
		}
		sort.topologicalSort();
	}
	/*
	 * ejemplo
	 * 
	  8 
	  11
	  0 3
	  0 4
	  1 4
	  2 0
	  2 1
	  2 5
	  2 6
	  3 4
	  3 5
	  4 5
	  5 7
	 * 
	 * 
	 * */
	

}
