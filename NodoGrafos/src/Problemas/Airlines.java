package Problemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

public class Airlines {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static double grafo[][];
	public static double distancias[][];
	public static int padres[][];
	public static HashMap<String, Integer> tabla = new HashMap<String, Integer>();
	public static double INF = Double.POSITIVE_INFINITY;
	public static double R = 6378;
	public static double PI = 3.141592653589793;

	public static double dist(double lt1, double ln1, double lt2, double ln2) {
		double D = Math.acos(Math.cos(lt1) * Math.cos(lt2)
				* Math.cos(ln1 - ln2) + Math.sin(lt1) * Math.sin(lt2))
				* R;
		return D;
	}

	public static class city {
		double lt;
		double ln;
		String name;

		public city(double lt, double ln, String name) {
			this.lt = (lt * PI) / 180;
			this.ln = (ln * PI) / 180;
			this.name = name;
		}

	}

	public static int cmp(final double x, final double y) {
		double eps = 0.000001;
		return (x <= y + eps) ? (x + eps < y) ? -1 : 0 : 1;
	}

	public static void floyd(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				distancias[i][k] = grafo[i][k];
				padres[i][k] = i;
				if (grafo[i][k] == INF || i == k) {
					padres[i][k] = -1;
				}
			}
		}
		for (int k = 0; k < n; k++) {
			// print(distancias);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (cmp(distancias[i][j], distancias[i][k]
							+ distancias[k][j]) > 0) {
						distancias[i][j] = distancias[i][k] + distancias[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int times = 0;
		while ((line = in.readLine()) != null) {
			if (line.equals("0 0 0"))
				break;
			if (times > 0) {
				System.out.println();
			}
			times++;
			int values[] = atoi(line);
			int n = values[0];
			int m = values[1];
			int q = values[2];
			city cities[] = new city[n];
			grafo = new double[n][n];
			distancias = new double[n][n];
			padres = new int[n][n];
			tabla = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String datos[] = in.readLine().split(" ");
				cities[i] = new city(Double.parseDouble(datos[1]),
						Double.parseDouble(datos[2]), datos[0]);

				tabla.put(datos[0], i);
			}

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					grafo[i][k] = INF;
				}
			}

			for (int i = 0; i < m; i++) {
				String d[] = in.readLine().split(" ");
				int a = tabla.get(d[0]);
				int b = tabla.get(d[1]);
				double f = dist(cities[a].lt, cities[a].ln, cities[b].lt,
						cities[b].ln);
				grafo[a][b] = (int) (f + 0.5);
			}

			floyd(n);
			System.out.println("Case #" + times);
			for (int i = 0; i < q; i++) {
				String dates[] = in.readLine().split(" ");
				int a = tabla.get(dates[0]);
				int b = tabla.get(dates[1]);
				double res = distancias[a][b];

				if ((res + "").equals("Infinity")) {
					System.out.println("no route exists");
				} else {
					System.out.format(Locale.US, "%.0f km\n", res);
				}
			}

		}
	}
}
