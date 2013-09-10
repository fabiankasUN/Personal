import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Combinaciones {

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
		do {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if (a == 0 && b == 0)
				return;
			if (a == b) {
				System.out.println(a + " things taken " + b + " at a time is " + 1 + " exactly.");
			} else {
				BigInteger c = new BigInteger(a + "");
				BigInteger d = new BigInteger((b - a) + "");
				BigInteger e = new BigInteger((b) + "");
				for (int i = a - 1; i >= 2; i--) {
					c = c.multiply(new BigInteger(i + ""));
				}

				for (int i = a - b - 1; i >= 2; i--) {
					d = d.multiply(new BigInteger(i + ""));
				}

				for (int i = b - 1; i >= 2; i--) {
					e = e.multiply(new BigInteger(i + ""));
				}
				BigInteger res = c.divide(d.multiply(e));
				System.out.println(a + " things taken " + b + " at a time is " + res.abs() + " exactly.");
			}
		} while (scan.hasNext());

	}

}
