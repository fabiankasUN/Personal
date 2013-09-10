import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestRectangleinHistogram {

	public static class SegTree {
		int hPresent;
		int start;
		int end;
		int maxVal;
		SegTree left;
		SegTree right;

		SegTree(int start, int end) {
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

		public void set(int pos, int val) {
			if (this.start == this.end && this.start == pos) {
				this.maxVal = val;
				this.hPresent = val;
				return;
			}

			int mid = (start + end) / 2;

			if (pos <= mid)
				left.set(pos, val);
			else
				right.set(pos, val);

			int min = Math.min(left.hPresent, right.hPresent);
			if (min * (end - start + 1) > left.maxVal && min * (end - start + 1) > right.maxVal) {
				this.maxVal = min * (end - start + 1);
				this.hPresent = Math.min(left.hPresent, right.hPresent);
			} else {
				if (left.maxVal > right.maxVal) {
					this.maxVal = left.maxVal;
					this.hPresent = left.hPresent;
				} else {
					this.maxVal = right.maxVal;
					this.hPresent = right.hPresent;
				}
			}
		}

		int getMax(int start, int end) {
			if (this.start == start && this.end == end)
				return maxVal;
			int mid = (this.start + this.end) / 2;
			if (start <= mid && end <= mid)
				return left.getMax(start, end);
			if (start > mid && end > mid)
				return right.getMax(start, end);
			return Math.max(left.getMax(start, mid), right.getMax(mid + 1, end));
		}

	}

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
		String line;
		while ((line = in.readLine()) != null) {
			int arr[] = atoi(line);
			SegTree arbol = new SegTree(1, arr.length - 1);
			for (int i = 0; i < arr.length - 1; i++) {
				arbol.set(i + 1, arr[i + 1]);
			}
			System.out.println(arbol.getMax(1, arr.length - 1));
		}

	}

}
