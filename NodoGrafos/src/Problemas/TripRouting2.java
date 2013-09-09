package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class TripRouting2 {
/*
 * accepted
 * */
	public static void print(int grafo[][]) {
		for (int i = 0; i < grafo.length; i++) {
			System.out.println(i+"  "+ inverse.get(i));
		}
		for (int i = 0; i < grafo.length; i++) {
			System.out.print(i+ ":  ");
			for (int k = 0; k < grafo.length; k++) {
				System.out.print(grafo[i][k] + "     ");
			}
			System.out.println();
		}
	}

	public static void floyd(int rows) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				distancias[i][j] = grafo[i][j];
				padres[i][j] = i;
				if (grafo[i][j] == INF || i == j) {
					padres[i][j] = -1;
				}
			}
		}
		for (int k = 0; k < rows; k++) {
			// print(distancias);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++) {

					if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}
		}
		//print(distancias);
		//System.out.println();
		//print(padres);
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

	}

	public static class pair {
		String a;
		String b;

		public pair(String a, String b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			return a.hashCode() + b.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof pair) {
				if (((pair) o).a.equals(this.a) && ((pair) o).b.equals(this.b)
						|| ((pair) o).a.equals(this.b)
						&& ((pair) o).b.equals(this.a)) {
					return true;
				}
			}
			return false;
		}
	}

	public static class ruta {

		int peso;
		String name;

		public ruta(int peso, String name) {
			this.peso = peso;
			this.name = name;
		}

	}
	public static void impresion(String line){
		String cad[]=line.split(",");
		int inicio=tablaDatos.get(cad[0]);
		int fin=tablaDatos.get(cad[1]);
		Stack<Integer> pila=new Stack<Integer>();
		pila.add(fin);
		while(padres[inicio][fin]!=-1){
			pila.add(padres[inicio][fin]);
			fin=padres[inicio][fin];
		}
		
		String c1=inverse.get(pila.pop());
		long total=0;
		while(!pila.isEmpty()){
			System.out.print(c1+w.substring(0,21-c1.length()));
			String c2=inverse.get(pila.pop());
			System.out.print(c2+w.substring(0,21-c2.length()));
			ruta r=ruta.get(new pair(c1, c2));
			System.out.print(r.name+ w.substring(0,11-r.name.length()));
			System.out.print(w.substring(0,5-(r.peso+"").length())+ r.peso);
			System.out.println();
			total+=r.peso;
			c1=c2;
		}
		System.out.println("                                                     -----");
		System.out.println("                                          Total      "+w.substring(0,5-(total+"").length())+total);
		
		
	}
	public static int grafo[][];
	public static int distancias[][];
	public static int padres[][];
	public static final int INF = (Integer.MAX_VALUE - 1) / 2;
	public static String w="                                                                                                                                 ";
	public static int num = 0;

	public static HashMap<pair, ruta> ruta = new HashMap<pair, ruta>();
	public static HashMap<String, Integer> tablaDatos = new HashMap<String, Integer>();
	public static HashMap<Integer, String> inverse = new HashMap<Integer, String>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = " ";
		LinkedList<String> entrada = new LinkedList<String>();

		while (!(line = in.readLine()).equals("")) {
			entrada.add(line);
		}
		String cad[][] = new String[entrada.size()][];
		for (int i = 0; i < entrada.size(); i++) {
			cad[i] = entrada.get(i).split(",");
			if (!tablaDatos.containsKey(cad[i][0])) {
				tablaDatos.put(cad[i][0], num);
				inverse.put(num, cad[i][0]);
				num++;
			}
			if (!tablaDatos.containsKey(cad[i][1])) {
				tablaDatos.put(cad[i][1], num);
				inverse.put(num, cad[i][1]);
				num++;
			}
		}
		grafo = new int[num][num];
		distancias = new int[num][num];
		padres = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int k = 0; k < num; k++) {
				if(i!=k)
					grafo[i][k]=INF;
			}
		}

		for (int i = 0; i < cad.length; i++) {
			int a = tablaDatos.get(cad[i][0]);
			int b = tablaDatos.get(cad[i][1]);
			if (grafo[a][b] == 0) {
				grafo[a][b] = Integer.parseInt(cad[i][3]);
				grafo[b][a] = Integer.parseInt(cad[i][3]);
				ruta.put(new pair(cad[i][0], cad[i][1]),
						new ruta(Integer.parseInt(cad[i][3]), cad[i][2]));
				ruta.put(new pair(cad[i][1], cad[i][0]),
						new ruta(Integer.parseInt(cad[i][3]), cad[i][2]));
				
			} else {
				if (grafo[a][b] > Integer.parseInt(cad[i][3])) {
					grafo[a][b] = Integer.parseInt(cad[i][3]);
					grafo[b][a] = Integer.parseInt(cad[i][3]);
					ruta.put(new pair(cad[i][0], cad[i][1]),
							new ruta(Integer.parseInt(cad[i][3]), cad[i][2]));
					ruta.put(new pair(cad[i][1], cad[i][0]),
							new ruta(Integer.parseInt(cad[i][3]), cad[i][2]));
				}
			}

		}
		floyd(num);
		int times=0;
		while ((line = in.readLine()) != null) {
				System.out.println();
				System.out.println();
			
			System.out
					.println("From                 To                   Route      Miles");
			System.out
					.println("-------------------- -------------------- ---------- -----");
			impresion(line);
		}

	}
}
