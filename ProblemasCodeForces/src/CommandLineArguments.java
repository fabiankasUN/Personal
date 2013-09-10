import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineArguments {

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
		System.out.println(in.readLine().trim());
		char cad2[] = in.readLine().toCharArray();
		String c = "";
		boolean a = false;
		for (int i = cad2.length-1; i >= 0; i--) {
			if (a) {
				c += cad2[i];
			} else if (cad2[i] == ' ') {

			} else {
				a = true;
				c += cad2[i];
			}
		}
		String d;
		d=new StringBuffer(c).reverse().toString();
		char cad[] = d.toCharArray();
		int k = 0;
		StringBuilder br = new StringBuilder();
		while (k < cad.length) {
			if (cad[k] == '"') {
				br.append("<");
				k++;
				while (cad[k] != '"') {
					br.append(cad[k]);
					k++;
				}
				br.append(">").append("\n");
				k++;
			} else if (cad[k] == ' ') {
				if (k < cad.length - 1) {
					if (cad[k + 1] == '"') {
						br.append("<");
						k++;
						k++;
						while (cad[k] != '"') {
							br.append(cad[k]);
							k++;
						}
						br.append(">").append("\n");
						k++;
					} else {
						br.append("<");
						while (cad[k] == ' ')
							k++;
						;
						if (cad[k] != '"') {
							while (cad[k] != ' ' && k<cad.length) {
								br.append(cad[k]);
								k++;
							}
						} else {
							k++;
							while (cad[k] != '"') {
								br.append(cad[k]);
								k++;
							}
							k++;
						}
						
						br.append(">").append("\n");
					}
				}
			}
		}
		System.out.print(br);
	}

}
