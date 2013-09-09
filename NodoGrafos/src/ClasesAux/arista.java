package ClasesAux;

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