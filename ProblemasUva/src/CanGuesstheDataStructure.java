import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class CanGuesstheDataStructure {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
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

	
	public static StringBuilder br;

	public static void add(String cad) {
		if (br == null)
			br = new StringBuilder();
		br.append(cad).append("\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while ((line = in.readLine()) != null) {
			if (line.equals(""))
				break;
			int n = Integer.parseInt(line);
			Stack<Integer> pila = new Stack<Integer>();
			Queue<Integer> cola = new LinkedList<Integer>();
			PriorityQueue<Integer> priority = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					if (o1 > o2) {
						return -1;

					} else if (o1 > 02)
						return 1;
					return 0;
				}
			});
			boolean esPile = true;
			boolean esCola = true;
			boolean esPriority = true;
			for (int i = 0; i < n && (esPile || esCola || esPriority); i++) {
				int values[] = atoi(in.readLine());
				if (values[0] == 1) {
					if(esPile)pila.add(values[1]);
					if(esCola)cola.add(values[1]);
					if(esPriority)priority.add(values[1]);
				} else {

					if (pila.isEmpty() || pila.pop() != values[1])
						esPile = false;
					if (cola.isEmpty() || cola.poll() != values[1])
						esCola = false;
					if (priority.isEmpty() || priority.poll() != values[1])
						esPriority = false;

				}
			}
			if (esPile && !esCola && !esPriority) {
				add("stack");
			} else if (!esPile && esCola && !esPriority) {
				add("queue");
			} else if (!esPile && !esCola && esPriority) {
				add("priority queue");
				
			} else if (esPile || esCola || esPriority) {
				add("not sure");
			} else {
				add("impossible");
			}

		}
		System.out.print(br);
	}

}
