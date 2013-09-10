import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChoosingLaptop {

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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		int cost[] = new int[ n ];
		int speed[] = new int[ n ];
		int ram[] = new int[ n ];
		int hdd[] = new int[ n ];
		int minCost=Integer.MAX_VALUE;
		int maxSpeed;
		int maxRam;
		int maxHdd;
		boolean obsoleta[] = new boolean[ n ];
		for (int i = 0; i < obsoleta.length; i++) {
			int values[]=atoi(in.readLine());
			speed[i]=values[0];
			ram[i]=values[1];
			hdd[i]=values[2];
			cost[i]=values[3];
		}
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (i != k) {
					if (speed[k] > speed[i] && ram[k] > ram[i] && hdd[k] > hdd[i]) {
						obsoleta[i] = true;
					}
				}
			}
		}
		int index = 0;
		for (int i = 0; i < obsoleta.length; i++) {
			if(!obsoleta[i]){
				index=i;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (!obsoleta[i] && !obsoleta[k] && i != k) {
					if ((cost[i] < cost[k] && cost[i]<minCost)) {
						index = i;
						minCost=cost[i];
					}
				}
			}
		}
		
		System.out.println(index+1);

	}
}
