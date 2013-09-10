import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MudPuddles {

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

	public static int arr[][];
	public static int max = 0;;
	public static int varX[] = { -1, 0, 1, 0 };
	public static int varY[] = { 0, 1, 0, -1 };

	public static int dfs() {
		Stack<Point> pila = new Stack<Point>();
		pila.add(new Point(0, 0));
		while (!pila.isEmpty()) {
			Point temp = pila.pop();
			if (temp.x < 0) {
				temp.x = temp.x * -1 + 500;
			}
			if (temp.y < 0) {
				temp.y = temp.y * -1 + 500;
			}
			for (int i = 0; i < varX.length; i++) {
				if (temp.x + varX[i] < 1000 && temp.x + varX[i] >= 0 && temp.y + varY[i] < 1000 && temp.y + varY[i] >= 0) {
					
				}
			}
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = in.readLine()) != null) {
			if (line.equals("0"))
				break;
			int values[] = atoi(line);
			int x = values[0];
			int y = values[1];
			int m = values[2];
			arr = new int[ 1002 ][ 1002 ];
			;

			for (int i = 0; i < m; i++) {
				values = atoi(in.readLine());
				arr[values[0]][values[1]] = 1;
			}
		}
	}
}
