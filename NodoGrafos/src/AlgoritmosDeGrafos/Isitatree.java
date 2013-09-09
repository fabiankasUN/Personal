package AlgoritmosDeGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Isitatree {

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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = in.readLine()) != null) {
			if (line.equals("0"))
				break;
			int values[] = atoi(line);
			HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> tabla2 = new HashMap<Integer, Integer>();
			int index = 0;
			boolean es = true;
			for (int i = 0; i < values[1]; i++) {
				int date[] = atoi(in.readLine());
				if (!tabla.containsKey(date[0])) {
					tabla.put(date[0], index++);
				} else {
				}
				if (!tabla2.containsKey(date[1])) {
					tabla2.put(date[1], index++);
				} else {
					es = false;
				}
			}
			if(es){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}

}
