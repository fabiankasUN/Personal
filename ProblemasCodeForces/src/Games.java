import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Games {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	// split de String
	public static String[] atos(String cad) {
		return cad.split(" ");
	}

	// parsing de String a int
	public static int parseo(String cad, int index) {
		return Integer.parseInt(cad.split(" ")[index]);
	}

	// memory status
	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/"
				+ (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}

	// imprimir array
	static void printArrayInt(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

	// impresion de datos
	static void print(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(obj[i]);
		}
		System.out.println();
	}

	public static class equipo {
		int casa;
		int visit;

		public equipo(int casa, int visit) {
			this.casa = casa;
			this.visit = visit;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line.trim());
		equipo cad[] = new equipo[ n ];
		for (int i = 0; i < n; i++) {
			int arr[] = atoi(in.readLine());
			cad[i] = new equipo(arr[0], arr[1]);
		}
		int res=0;
		for (int i = 0; i < cad.length; i++) {
			for (int j = 0; j < cad.length; j++) {
				if(i!=j){
					if(cad[i].casa==cad[j].visit){
						res++;
					}
						
				}
			}
		}
		System.out.println(res);
		
	}

}
