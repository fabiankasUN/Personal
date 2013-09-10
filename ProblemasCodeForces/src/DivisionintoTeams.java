import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DivisionintoTeams {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	// split de String
	public static String[] atos(String cad) {
		return cad.split(" ");
	}

	// parsing de String a int
	public static int parseo(String cad, int index) {
		return Integer.parseInt(cad.split(" ")[index]);
	}

	// memory status
	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/"
				+ (Runtime.getRuntime().totalMemory() >> 20) + " MB";
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

	// impresion de datos
	static void print(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(obj[i]);
		}
		System.out.println();
	}

	public static int dif;
	public static nums arr[];

	public static class nums implements Comparable<nums> {
		int num;
		int index;

		public nums(int num, int index) {
			this.num = num;
			this.index = index;
		}

		@Override
		public int compareTo(nums o) {
			if (this.num < o.num)
				return -1;
			else if (this.num > o.num)
				return 1;

			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);

		arr = new nums[ n ];
		String c[] = in.readLine().split(" ");
		for (int i = 0; i < c.length; i++) {
			arr[i] = new nums(Integer.parseInt(c[i]), i + 1);

		}

		Arrays.sort(arr);
		StringBuilder br1 = new StringBuilder();
		StringBuilder br2 = new StringBuilder();
		br1.append(arr[arr.length - 2].index);
		br2.append(arr[arr.length - 1].index);
		int sum1 = 1;
		int sum2 = 1;
		for (int i = arr.length - 3; i >= 0; i--) {
			if (sum2 <= sum1) {
				br2.append(" " + arr[i].index);
				sum2++;
			} else {
				br1.append(" " + arr[i].index + " ");
				sum1++;
			}
		}
		System.out.println(sum2);
		System.out.println(br2);
		System.out.println(sum1);
		System.out.println(br1);
	}
}
