import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LakeCounting {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int count = 1;
	public static char arr[][];

	public static void dfs(int i, int j) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 'W')
			return;
		arr[i][j] = (char) count;
		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j - 1);
		dfs(i, j + 1);	
		dfs(i + 1, j + 1);
		dfs(i - 1, j + 1);
		dfs(i - 1, j - 1);
		dfs(i + 1, j - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int values[] = atoi(in.readLine());
		arr = new char[ values[0] ][ values[1] ];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'W') {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(--count);

	}
}
