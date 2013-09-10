import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlippingBurnedPancakes {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int maxStep;
	public static int correct[];
	public static int arr[];
	public static boolean res = false;;
	public static int times = 1;

	public static boolean ok() {
		for (int i = 0; i < correct.length; i++) {
			if (correct[i] != arr[i]) {
				return false;
			}
		}
		return true;
	}

	public static int k = 0;

	public static void dfs(int index, int ultimo, String cad) {
		if (res)
			return;
		if (maxStep == index - 1) {

		} else {
			for (int i = 1; i <= arr.length; i++) {
				if (i != ultimo) {

					int c[] = new int[ arr.length ];
					int temp[] = new int[ arr.length ];
					c = arr;
					/*
					 * for (int j = 0; j < c.length; j++) { c[j] = arr[j];//
					 * guardamos info }
					 */
					k = 0;
					for (int j = i - 1; j >= 0; j--) {
						temp[k] = -arr[j];
						k++;
					}
					for (int j = k; j < arr.length; j++) {
						temp[k] = arr[j];
						k++;
					}
					arr = temp;

					if (index == maxStep - 1) {
						if (ok()) {
							System.out.println(times + " " + cad.trim() + " " + (i));
							res = true;
						}
					}

					dfs(index + 1, i, cad + " " + (i) + "");
					arr = c;

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++) {
			String cad[] = in.readLine().split(" ");
			arr = new int[ cad.length - 1 ];
			correct = new int[ cad.length - 1 ];
			for (int j = 0; j < cad.length - 1; j++) {
				if (cad[j + 1].charAt(0) == '+')
					arr[j] = Integer.parseInt(cad[j + 1].substring(1, cad[j + 1].length()));
				else {
					arr[j] = -Integer.parseInt(cad[j + 1].substring(1, cad[j + 1].length()));
				}
				correct[j] = Math.abs(arr[j]);
			}
			Arrays.sort(correct);
			res = false;
			maxStep = 3 * arr.length - 2;
			dfs(0, -1, "");
			times++;
		}
	}
}
