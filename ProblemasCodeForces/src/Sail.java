import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sail {

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
		int values[] = atoi(line);
		int t = values[0];
		int xI = values[1];
		int yI = values[2];
		int xF = values[3];
		int yF = values[4];
		int step = 0;
		char cad[] = in.readLine().toCharArray();
		boolean es = false;
		if (xI == xF && yI == yF) {
			System.out.println(0);
			es = true;
		} else {
			for (int i = 0; i < cad.length; i++) {
				if (cad[i] == 'N') {
					if (yI < yF) {
						yI++;
					}
				}
				if (cad[i] == 'S') {
					if (yI > yF) {
						yI--;
					}
				}
				if (cad[i] == 'E') {
					if (xI < xF) {
						xI++;
					}
				}
				if (cad[i] == 'W') {
					if (xI > xF) {
						xI--;
					}
				}
				if (xI == xF && yI == yF) {
					System.out.println(step + 1);
					es = true;
					break;
				}
				step++;

			}
		}
		if (!es) {
			System.out.println(-1);
		}

	}

}
