import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresentfromLena {

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
		String arr = "                                                                        ";
		int k = 1;
		int cont = 0;
		int p = (2 * n) + 1;
		for (int i = 0; i <n; i++) {
			System.out.print(arr.substring(0, p - 1));
			cont=0;
			for (int j = 0; j < k; j++) {
				if (j != k - 1)
					System.out.print(cont + " ");
				else
					System.out.print(cont);
				if (j < k / 2) {
					cont++;
				} else {
					cont--;
				}
			}
			k += 2;
			p -= 2;
			System.out.println();
		}
		cont=0;
		for (int i = 0; i < (2 * n) + 1; i++) {
			if (i != ((2 * n) + 1) - 1)
				System.out.print(cont + " ");
			else
				System.out.print(cont);
			
			if (i < ((2 * n) + 1) / 2) {
				cont++;
			} else {
				cont--;
			}
		}
		System.out.println();
		k = ((2 * n) + 1) - 2;
		p = 3;
		for (int i = n; i >= 0; i--) {
			System.out.print(arr.substring(0, p - 1));
			cont=0;
			for (int j = 0; j < k; j++) {
				if (j != k - 1)
					System.out.print(cont + " ");
				else
					System.out.print(cont);
				if (j < k / 2) {
					cont++;
				} else {
					cont--;
				}
			}
			p += 2;
			k -= 2;
			;
			System.out.println();
		}

	}
}
