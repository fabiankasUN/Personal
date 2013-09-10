import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parallelepiped {

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
		int n[] = atoi(line);
		long res = 0;
		for (int i = 0; i < n.length; i++) {
			res += n[i] * 4;
		}
		System.out.println(res);
	}
}
