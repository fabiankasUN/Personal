package Problemas;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Locale;

public class FormingQuizTeams {

	public static int cmp(final double x, final double y, final double eps) {
		return (x <= y + eps) ? (x + eps < y) ? -1 : 0 : 1;
	}

	public static double dist(Point a, Point b) {
		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow(a.y - b.y, 2));
	}

	public static class person {
		int id;
		Point p;

		public person(int id, Point p) {
			this.p = p;
			this.id = id;
		}

		public String toString() {
			return id + " x : " + p.x + " y : " + p.y;
		}

	}

	public static int parseo(String cad, int index) {
		return Integer.parseInt(cad.split(" ")[index]);
	}

	public static int n;
	static double matriz[][];
	static double res = Double.MAX_VALUE;
	static int mask;

	public static void dfs(int a, int index, double ac) {
		for (int i = index; i < n; i++) {
			if ((a & 1 << i) != 0)
				continue;
			for (int j = i + 1; j < n; j++) {
				if ((a & 1 << (j)) == 0 && (a & 1 << (i)) == 0) {
					int w = a;
					w = w | 1 << j;//se marca i como usado
					w = w | 1 << i;//se marca j como usado
					
					BigInteger b=new BigInteger(w+"");
					System.out.println(b.toString(2));
					System.out.println();
					if (ac + matriz[i][j] > res)
						continue;
					dfs(w, i + 1, ac + matriz[i][j]);
					if (w == mask) {
						if (ac + matriz[i][j] < res) {
							res = ac + matriz[i][j];
						}
					}

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int time = 1;
		while ((line = in.readLine()) != null) {
			int c = Integer.parseInt(line);
			if (c == 0)
				break;
			person arr[] = new person[2 * c];
			for (int i = 0; i < 2 * c; i++) {
				line = in.readLine();
				arr[i] = new person(i, new Point(parseo(line, 1), parseo(line,
						2)));
			}
			n = c * 2;
			mask = (int) Math.pow(2, n) - 1;
			matriz = new double[n][n];
			res = Double.MAX_VALUE;
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					if (matriz[i][j] == 0) {
						matriz[i][j] = dist(arr[i].p, arr[j].p);
						matriz[j][i] = matriz[i][j];
					}
				}
			}

			int x = 0;
			dfs(x, 0, 0);
			System.out.print("Case " + time + ": ");
			System.out.printf(Locale.US, "%.2f", res);
			System.out.println();
			time++;

		}
	}
}
