import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Botones {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		int arr[] = new int[ n + 1 ];
		arr[1] = n;
		for (int i = 2; i < n+1; i++) {
			arr[i] = arr[i - 1] + (n - i + 1) * (i - 1);
		}
		System.out.println(arr[arr.length - 1]);

	}
}
