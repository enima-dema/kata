package weight;

import java.util.Arrays;
import java.util.Comparator;

public class Weight {

	public static String orderWeight(String string) {
		String[] arrayNumber = string.split(" ");
		Arrays.sort(arrayNumber, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				if (calculateWeight(o1) < calculateWeight(o2)) {
					return -1;
				} else if (calculateWeight(o1) > calculateWeight(o2)) {
					return 1;
				}
				return o1.compareTo(o2);
			}
		});
		String string2 = "";
		for (int i = 0; i < arrayNumber.length; ++i) {
			string2 = string2.concat(String.valueOf(arrayNumber[i]));
			if (i != arrayNumber.length - 1) {
				string2 = string2.concat(" ");
			}
		}
		return string2;
	}

	public static int calculateWeight(String string) {
		int u = 0;
		for (int i = 0; i < string.length(); ++i) {
			u += Character.getNumericValue(string.charAt(i));
		}

		return u;
	}

	public static void printTab(String[] string) {
		System.out.println("PRINT TAB");
		for (String lol : string) {
			System.out.print(lol + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void printTab(String[][] string) {
		System.out.println("PRINT TAB");
		for (String lol[] : string) {
			for (String mdr : lol) {
				System.out.print(mdr + " ");
			}
		}
		System.out.println();
	}

}
