import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cryptoquote {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line.trim());
		int times=1;
		for (int i = 0; i < n; i++) {
			char cad[] = in.readLine().trim().toCharArray();
			//char letter[] = in.readLine().trim().toCharArray();
			//System.out.print (times+" ");
			//for (int j = 0; j < cad.length; j++) {
				//if (cad[j] != ' ')
			//		System.out.print(letter[cad[j] - 'A']);
			//	else
		//			System.out.print(" ");
		//	}
		//	System.out.println();
		//	times++;
			System.out.println("0");
		}
	}

}
