import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntervalProduct {

	// split de array
	public static int[] atoi(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[ read.length ];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static class SegTree {
		char maxValue;
		int start;
		int end;
		SegTree left;
		SegTree right;

		public SegTree(int start, int end) {
			this.start = start;
			this.end = end;
			if (start == end) {
				left = null;
				right = null;
			} else {
				int mid = (start + end) / 2;
				left = new SegTree(start, mid);
				right = new SegTree(mid + 1, end);
			}
		}

		public void set(int pos, char val) {
			if (start == end && start == pos) {
				this.maxValue = val;
				return;
			} else {
				int mid = (start + end) / 2;
				if (pos <= mid) {
					left.set(pos, val);
				} else {
					right.set(pos, val);
				}
			}
			if ((left.maxValue == '+' && right.maxValue == '+') || (left.maxValue == '-' && right.maxValue == '-')) {
				maxValue = '+';
			} else if ((left.maxValue == '+' && right.maxValue == '-') || (left.maxValue == '-' && right.maxValue == '+')) {
				maxValue = '-';
			} else
				maxValue = '0';

		}

		public char getMaxValue(int start, int end) {
			if (this.start == start && this.end == end) {
				return maxValue;
			} else {
				int mid = (this.start + this.end) / 2;
				if (start <= mid && end <= mid) {
					return left.getMaxValue(start, end);
				} else if (start > mid && end > mid) {
					return right.getMaxValue(start, end);
				} else {
					char a = left.getMaxValue(start, mid);
					char b = right.getMaxValue(mid + 1, end);
					if (a == '+' && b == '+' || a == '-' && b == '-') {
						return '+';
					} else if (a == '+' && b == '-' || a == '-' && b == '+') {
						return '-';
					} else {
						return '0';
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder br = new StringBuilder();
		while ((line = in.readLine()) != null) {

			int values[] = atoi(line);
			int arr[] = atoi(in.readLine());
			SegTree arbol = new SegTree(1, arr.length);
			char actual;
			for (int i = 0; i < values[0]; i++) {
				if (arr[i] > 0)
					actual = '+';
				else if (arr[i] < 0)
					actual = '-';
				else
					actual = '0';
				arbol.set(i + 1, actual);
			}
			for (int i = 0; i < values[1]; i++) {
				String cad[] = in.readLine().split(" ");
				int start = Integer.parseInt(cad[1]);
				int end = Integer.parseInt(cad[2]);
				char type = cad[0].charAt(0);
				if (type == 'C') {
					char a = end > 0 ? '+' : end < 0 ? '-' : '0';
					arbol.set(start, a);
				} else {
					int res = arbol.getMaxValue(start, end);
					if (res == '-') {
						br.append("-");
					} else if (res == '+') {
						br.append('+');
					} else
						br.append("0");
				}
			}
			br.append("\n");

		}
		System.out.print(br);

	}
	
	
	
	
}
