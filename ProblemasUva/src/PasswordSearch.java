import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class PasswordSearch {

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
		Scanner scan = new Scanner(System.in);
		Hashtable<String, Integer> tabla = new Hashtable<String, Integer>();
		String c = "";
		String p = "";
		String cadMax = "";
		int k = 0;
		int max = 0;
		while (scan.hasNext()) {
			int n = scan.nextInt();
			char cad[] = scan.next().trim().toCharArray();
			tabla.clear();
			c = "";
			for (int i = 0; i < n; i++) {
				c += cad[i];
			}

			tabla.put(c, 1);
			p = "";
			k = n;
			max = 1;
			cadMax = c;
			for (int i = 1; i < cad.length - n + 1; i++) {
				p = c.substring(1, c.length()) + cad[k];
				if (tabla.containsKey(p)) {
					int date = tabla.get(p) + 1;
					if (date > max) {
						max = date;
						cadMax = p;
					}
					tabla.put(p, date);
				} else {
					tabla.put(p, 1);
				}
				k++;
				c = p;
			}
			System.out.println(cadMax);
		}
	}
}
