import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameShowMath {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static char op[] = { '+', '-', '*', '/' };
	public static int res;
	public static int arr[];
	public static boolean visited[];
	public static int sum = 0;
	public static boolean es = false;
	public static ArrayList<Character> lista = new ArrayList<Character>(102);
	public static ArrayList<Byte> lista2 = new ArrayList<Byte>(102);

	public static void rec(int acum) {
		if (es)
			return;
		if (res == acum && sum == arr.length - 2) {
			for (int i = 0; i < lista2.size(); i++) {
				if (i > 0)
					System.out.print(lista.get(i - 1) + "" + lista2.get(i));
				else {
					System.out.print(lista2.get(i));
				}
			}
			System.out.print("=" + res);
			System.out.println();
			lista.clear();
			lista2.clear();

			// System.out.println(cad.substring(1, cad.length()) + "=" + res);
			es = true;
		} else {

			if (acum <= 32000 && acum >= -32000 && sum < arr.length - 2)
				for (int i = 1; i < arr.length - 1; i++) {
					if (!visited[i]) {
						visited[i] = true;
						for (int j = 0; j < op.length; j++) {
							if (op[j] == '+') {
								sum++;
								lista.add('+');
								lista2.add((byte) i);
								rec(acum + arr[i]);
								lista2.remove(lista2.size() - 1);
								lista.remove(lista.size() - 1);
								sum--;
							}
							if (op[j] == '-') {
								sum++;
								lista.add('-');
								lista2.add((byte) i);
								rec(acum - arr[i]);
								lista2.remove(lista2.size() - 1);
								lista.remove(lista.size() - 1);
								sum--;
							}
							if (op[j] == '*') {
								sum++;
								lista.add('*');
								lista2.add((byte) i);
								rec(acum * arr[i]);
								lista2.remove(lista2.size() - 1);
								lista.remove(lista.size() - 1);
								sum--;
							}
							if (op[j] == '/') {
								if (acum % arr[i] == 0) {
									lista.add('/');
									sum++;
									lista2.add((byte) i);
									rec(acum / arr[i]);
									lista2.remove(lista2.size() - 1);
									lista.remove(lista.size() - 1);
									sum--;
								}
							}
						}
						visited[i] = false;
					}
				}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++) {
			arr = atoi(in.readLine());
			res = arr[arr.length - 1];
			visited = new boolean[ arr.length ];
			rec(0);
			if (!es) {
				System.out.println("NO EXPRESSION");
			}
			es = false;
		}

	}

}
