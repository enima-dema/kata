package minimum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Kata {
	public static long nextSmaller(long n) {
		char min = '0';
		String value = String.valueOf(n);
		char[] eachNumberChar = value.toCharArray();
		Arrays.sort(eachNumberChar);

		if (Arrays.asList(eachNumberChar).contains('0')) {
			// Temp tab where you delete each 0
			ArrayList<Character> temp = new ArrayList<Character>();
			for (char u : eachNumberChar) {
				temp.add(u);
			}
			// Get the min)
			min = Collections.min(temp);

			//create LIst
			ArrayList<Character> fin = new ArrayList<Character>();
			fin.remove(min);
			fin.add(0, min);
		}else {
			
		}

		for (char u : eachNumberChar) {
			System.out.println(u);
		}

		return n;
	}
}