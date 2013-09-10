import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhatMedian {

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
		String line;
		ArrayList<Long> lista = new ArrayList<Long>(1002);
		while (scan.hasNext()) {
			lista.add(scan.nextLong());
			Collections.sort(lista);
			if (lista.size() == 2) {
				System.out.println((long)(lista.get(0) + lista.get(1)) / 2);
			} else if (lista.size() % 2 == 0) {
				System.out.println((long)(lista.get((lista.size() / 2) - 1) + lista.get((lista.size() / 2))) / 2);
			} else {
				System.out.println((long)lista.get(lista.size() / 2));
			}

		}

	}

}
