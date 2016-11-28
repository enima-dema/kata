package minimum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Kata {
	public static long nextSmaller(long n) {
		char min = '0';

		// Create a String from the long
		String nString = String.valueOf(n);

		// Create a list from the String
		ArrayList<String> nList = new ArrayList<String>();
		for (int i = 0; i < nString.length(); ++i) {
			nList.add(String.valueOf(nString.charAt(i)));
		}

		// Sort the list
		Collections.sort(nList);

		// Deal with the 0
		if (nList.get(0).equals("0")) {
			// Get the second min, delete the entris and insert it at the
			// beginning of the table
			String secondMin;
			for (int i = 0; i < nList.size(); ++i) {
				if (!nList.get(i).equals("0")) {
					secondMin = nList.get(i);
					nList.remove(i);
					nList.add(0, secondMin);
					i = nList.size();
				}
			}
		}

		// Create the int
		String nFin = "";
		for (String number : nList) {
			nFin = nFin.concat(number);
		}
		return Integer.valueOf(nFin);
	}

	public static void printList(ArrayList<String> lol) {
		for (String string : lol) {
			System.out.print(string);
		}
	}
}