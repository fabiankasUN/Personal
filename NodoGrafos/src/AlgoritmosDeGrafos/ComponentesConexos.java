package AlgoritmosDeGrafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ComponentesConexos {

	public static nodo grafo[];// arreglo de listas<arista> para
	public static boolean visitado[];// lleva los visitados de cada nodo
	public static int cont = 0;// contador para llevar los index y lowlink
	public static Stack<Integer> pila;// pila para sacar soluciones
	public static ArrayList<Integer> res[];//
	public static int sig = 0;

	public static class arista {
		int vecino;// etiqueta del nodo
		int peso;// etiqueta del peso

		public arista(int vecino, int peso) {// constructor
			this.vecino = vecino;
			this.peso = peso;

		}

		public String toString() {
			return vecino + " ";
		}
	}

	public static class nodo {
		String nombre;
		int id;
		int lowLink;
		int index;
		LinkedList<arista> listaVecinos;

		public nodo(String nombre, int id, int lowlink, int index) {
			this.nombre = nombre;
			this.id = id;
			this.lowLink = lowlink;
			this.index = index;
			listaVecinos = new LinkedList<arista>();
		}

		public String toString() {
			return "id: " + id + " lowlink: " + lowLink + " index: " + index;
		}
	}

	public static void add(int a, int b, int peso) {
		grafo[a].listaVecinos.add(new arista(b, peso));
	}	

	public static void init(int v) {
		grafo = new nodo[v];
		visitado = new boolean[v];
		res = new ArrayList[v];
		cont = 1;
		sig = 0;
		for (int i = 0; i < grafo.length; i++) {
			res[i] = new ArrayList<Integer>();
			grafo[i] = new nodo(i + "", i, 0, 0);
		}
	}

	public static ArrayList[] Tarjan() {
		pila = new Stack<Integer>();
		for (int i = 0; i < grafo.length; i++) {
			if (!visitado[i]) {
				strongComponent(i);
			}
		}
		return res;
	}

	public static void strongComponent(int v) {
		visitado[v] = true;
		grafo[v].lowLink = cont;
		grafo[v].index = cont;
		cont++;
		pila.add(v);
		for (int i = 0; i < grafo[v].listaVecinos.size(); i++) {
			int vecino = grafo[v].listaVecinos.get(i).vecino;
			if (!visitado[vecino]) {
				strongComponent(vecino);
				grafo[v].lowLink = Math.min(grafo[v].lowLink,
						grafo[vecino].lowLink);
			} else if (pila.contains(vecino)) {
				grafo[v].lowLink = Math.min(grafo[v].lowLink,
						grafo[vecino].index);
			}
		}

		if (grafo[v].lowLink == grafo[v].index) {
			int w;
			do {
				w = pila.pop();
				res[sig].add(w);
			} while (w != v);
			sig++;
		} else {
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aristas=scan.nextInt();//num aristas
		int vertices=scan.nextInt();//num vertices
		ComponentesConexos convex=new ComponentesConexos();
		convex.init(vertices);
		for (int i = 0; i < aristas; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int peso=scan.nextInt();
			convex.add(a, b, peso);
		}
		ArrayList<Integer> lista[]=Tarjan(); 
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista[i].size(); j++) {
				System.out.print(lista[i].get(j)+" ");
			}
			System.out.println();
		}
	}
}
