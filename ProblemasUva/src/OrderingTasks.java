import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OrderingTasks {

	public static ArrayList<arista> grafo[];// grafo
	public static int IN_Degree[];// nodos de entrada desde otros nodos al
									// nodo
									// i

	public static int v;// numero de nodos

	public void init(int v) {
		grafo = new ArrayList[ v ];
		IN_Degree = new int[ v ];
		for (int i = 0; i < grafo.length; i++) {
			grafo[i] = new ArrayList<arista>();
		}
	}

	public static StringBuilder br = new StringBuilder();

	public void topologicalSort() {
		Queue<Integer> cola = new LinkedList<Integer>();
		for (int i = 0; i < IN_Degree.length; i++) {
			if (IN_Degree[i] == 0) {
				cola.add(i);
			}
		}
		while (!cola.isEmpty()) {
			int actual = cola.poll();
			br.append(actual + 1).append(" ");
			// System.out.print(actual + 1);
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

	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			if (line.equals("0 0"))
				break;
			int values[] = atoi(line);
			int v = values[0];
			int aristas = values[1];
			OrderingTasks sort = new OrderingTasks();
			sort.init(v);

			for (int i = 0; i < aristas; i++) {
				String cad[] = in.readLine().trim().split(" ");
				int origen = Integer.parseInt(cad[0]) - 1;
				int destino = Integer.parseInt(cad[1]) - 1;
				sort.add(origen, destino);
			}
			sort.topologicalSort();
			br.deleteCharAt(br.length() - 1);
			br.append("\n");

		}
		System.out.print(br);
	}

}
