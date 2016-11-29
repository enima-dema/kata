package minimum;

import java.util.ArrayList;
import java.util.Collections;

public class Kata2 {
	public static long nextSmaller(long n) {

		/**
		 * We try to fin a smaller ones on the last digits, we try each time a
		 * little more if there is a smaller one possible (?) : We got the first
		 * number, and we take the min right after. If there is one, we stop,
		 * and we switch the number. If there is none, we go to the nex number.
		 * If no number match that condition, we go to the new number.
		 */

		// Get if the number is only one digit
		if (n < 10) {
			return -1;
		}

		// Create a String from the long
		String nString = String.valueOf(n);

		// Create a list of Number from the String
		ArrayList<Integer> nList = new ArrayList<Integer>();
		for (int i = 0; i < nString.length(); ++i) {
			nList.add(Character.getNumericValue(nString.charAt(i)));
		}

		// Travel through the list
		for (int i = nList.size() - 2; i >= 0; --i) {
			// Travel through i to the end of the list wich is the max inferior
			// to the digit
			int max = -1;
			int index = 0;
			for (int y = i; y < nList.size(); ++y) {
				if (nList.get(i) > nList.get(y) && nList.get(y) > max) {
					max = nList.get(y);
					index = y;
				}
			}

			if (max != -1) {
				nList.remove(index);
				nList.add(i, max);
				String string = "";
				for (int y : nList) {
					string = string.concat(String.valueOf(y));
				}
				if (string.charAt(0) == '0') {
					return -1;
				}
				return Integer.valueOf(string);
			}
		}

		return -1;
	}

	public static void printListInteger(ArrayList<Integer> lol) {
		System.out.print("IMPRESSION : ");
		for (int string : lol) {
			System.out.print(string);
		}
		System.out.println();
	}

	public static void printList(ArrayList<String> lol) {
		for (String string : lol) {
			System.out.print(string);
		}
		System.out.println();
	}
}