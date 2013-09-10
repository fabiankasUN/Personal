import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Manipulation {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);

		line = in.readLine();
		// line = line.replaceAll("ñ", "{");
		char arr[] = line.toCharArray();
		char cad[] = new char[ line.length() * n ];
		boolean visited[] = new boolean[ cad.length ];
		ArrayList<Integer> lista[] = new ArrayList[ 26 ];

		for (int i = 0; i < 26; i++) {
			lista[i] = new ArrayList<Integer>();
		}
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr.length; j++) {
				cad[k] = arr[j];
				k++;
				lista[arr[j] - 'a'].add(k - 1);
			}
		}

		int num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			String values[] = in.readLine().split(" ");
			int w = Integer.parseInt(values[0]);
			char car = values[1].charAt(0);
			visited[lista[car - 'a'].get(w - 1)] = true;
			lista[car - 'a'].remove(w - 1);
		}
		StringBuilder br = new StringBuilder();

		for (int i = 0; i < cad.length; i++) {
			if (visited[i] == false) {
				br.append(cad[i] + "");
			}
		}
		System.out.println(br);
	}

}
