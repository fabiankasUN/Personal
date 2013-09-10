import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Ilyaconsultas {

	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		System.out.printf(Locale.US,"",0);

		while ((line = in.readLine()) != null) {
			StringBuilder br = new StringBuilder();
			char cad[] = line.toCharArray();
			int n = Integer.parseInt(in.readLine());
			arr = new int[ cad.length ];
			for (int i = 1; i < cad.length; i++) {
				if (cad[i] == cad[i - 1]) {
					arr[i] = arr[i - 1] + 1;
				} else {
					arr[i] = arr[i - 1];
				}
			}
			for (int i = 0; i < n; i++) {
				int dates[] = atoi(in.readLine());
				br.append(arr[dates[1] - 1] - arr[dates[0] - 1]).append("\n");
			}
			System.out.print(br);
		}
	}

}
