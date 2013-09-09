package AlgoritmosDeGrafos;

import java.util.Scanner;

public class Floyd {

	public static int grafo[][];
	public static int distancias[][];
	public static int padres[][];
	public static final int INF =(Integer.MAX_VALUE-1)/2;

	public void inint(int n) {
		grafo = new int[n][n];
		distancias = new int[n][n];
		padres = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if(i!=k)
					grafo[i][k]=INF;
			}
		}
	}

	void floyd(int rows) {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				distancias[i][j] = grafo[i][j];
				padres[i][j] = i;
				if (grafo[i][j] == INF || i == j) {
					padres[i][j] = -1;
				}
			}
		}
		print(padres);
		
		
		for (int k = 0; k < rows; k++) {
			//print(distancias);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++) {
					
					if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}	
		}
		
		
		print(distancias);
		System.out.println();
		print(padres);
	}
public static void print(int grafo[][]){
	for (int i = 0; i < grafo.length; i++) {
		for (int k = 0; k < grafo.length; k++) {
			System.out.print(grafo[i][k]+" ");
		}
		System.out.println();
	}
}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int E = scan.nextInt();
		Floyd floyd = new Floyd();
		floyd.inint(v);
		for (int i = 0; i < E; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int peso = scan.nextInt();
			grafo[a][b] = peso;
		}
		floyd.floyd(v);

	}
	/*
	  
	 5 9
	 0 1 3
	 0 2 8
	 0 4 -4
	 1 4 7
	 1 3 1
	 2 1 4
	 3 2 -5
	 3 0 2
	 4 3 6 
	 
	 4 7
	 0 1 1
	 0 2 3
	 1 2 1
	 2 1 3
	 2 3 5
	 3 1 2	
	 1 0 3
	   
	 4 6
	 0 1 8
	 0 3 1
	 1 2 1
	 2 0 4
	 3 1 2
	 3 2 9
	 
	 * */
	

}
