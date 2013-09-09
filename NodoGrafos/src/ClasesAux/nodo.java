package ClasesAux;


public class nodo {
	String nombre;
	int pesoNodo;
	int id;

	public nodo(String nombre, int id, int pesoNodo) {
		this.nombre = nombre;
		this.id = id;
		this.pesoNodo = pesoNodo;
	}

	public String toString() {
		return "id: " + id + " nombre: " + nombre + " peso nodo : " + pesoNodo;
	}
}