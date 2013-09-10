import java.util.*;


public class Prueba {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		String S = in.next();
		myString[] string = new myString[ K ];
		for (int i = 0; i < K; i++)
			string[i] = new myString(S);

		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int p = in.nextInt();
			char c = in.next().charAt(0);

			int count = 0;
			for (int t = 0; t < K; t++) {
				if (count + string[t].freq[c - 'a'] < p) {
					count += string[t].freq[c - 'a'];
					continue;
				}

				string[t].freq[c - 'a']--;
				int tmp = 0;
				for (int k = 0; k < string[t].sb.length(); k++) {
					if (string[t].sb.charAt(k) == c)
						tmp++;
					if (tmp == p - count) {
						string[t].sb = string[t].sb.deleteCharAt(k);
						break;
					}
				}
				break;
			}
		}

		for (myString ms : string) {
			System.out.printf(ms.sb.toString());
		}

	}

	public static class myString {
		StringBuilder sb;
		int freq[];

		public myString(String s) {
			sb = new StringBuilder(s);
			freq = new int[ 26 ];
			for (int i = 0; i < s.length(); i++)
				freq[s.charAt(i) - 'a']++;
		}
	}
}
