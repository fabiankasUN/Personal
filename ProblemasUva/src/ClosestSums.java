import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClosestSums {

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

	public static int n;
	public static int res[];

	public static int binarySearch(int seach) {
		int ini = 0;
		int fin = res.length - 1;
		int mid = 0;
		int dif = Integer.MAX_VALUE;
		int index = -1;
		while (ini <= fin) {
			mid = (ini + fin) / 2;
			if (Math.abs(res[mid] - seach) < dif) {
				dif = Math.abs(res[mid] - seach);
				index = res[mid];
			}
			if (res[mid] > seach) {
				fin = mid - 1;
			} else {
				ini = mid + 1;
			}

		}
		return index;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int times = 1;
		StringBuilder br = new StringBuilder();
		while ((line = in.readLine()) != null) {
			if (line.equals("0"))
				break;
			n = Integer.parseInt(line);
			int arr[] = new int[ n ];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(in.readLine());
			}
			res = new int[ (((n - 1) * (n)) / 2) ];
			int k = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (i != j) {
						res[k] = arr[i] + arr[j];
						k++;
					}
				}
			}

			Arrays.sort(res);

			int q = Integer.parseInt(in.readLine());
			// System.out.println("case " + times + ":");
			br.append("case " + times + ":").append("\n");
			for (int i = 0; i < q; i++) {
				int date = Integer.parseInt(in.readLine());
				if (date > res[res.length - 1]) {
					br.append("Closest sum to " + date + " is " + res[res.length - 1] + ".").append("\n");
					// System.out.println("Closest sum to " + date + " is " +
					// res[res.length - 1] + ".");
				} else if (date < res[0]) {
					br.append("Closest sum to " + date + " is " + res[0] + ".").append("\n");
					// System.out.println("Closest sum to " + date + " is " +
					// res[0] + ".");
				} else
					br.append("Closest sum to " + date + " is " + binarySearch(date) + ".").append("\n");
				// System.out.println("Closest sum to " + date + " is " +
				// binarySearch(date) + ".");
			}
			times++;

		}
		System.out.print(br);
	}
}
