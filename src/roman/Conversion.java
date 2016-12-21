package roman;

import java.util.ArrayList;

public class Conversion {
	static String[][] tableSymb = new String[][] { { "I", "V", "X" }, { "X", "L", "C" }, { "C", "D", "M" },
			{ "M", "M", "M" } };
	static int[] tableValue = new int[] { 1, 5, 10 };

	public String solution(int n) {
		String numeral = String.valueOf(n);
		ArrayList<Character> sValues = new ArrayList<Character>();
		for (int i = 0; i < numeral.length(); ++i) {
			sValues.add(numeral.charAt(i));
		}
		String result = "";
		for (int i = sValues.size() - 1, y = 0; y < sValues.size(); i--, ++y) {
			result = result.concat(traduct(sValues.get(y), i));
		}
		return result;
	}

	public static String traduct(char num, int pow) {
		String result = "";
		int x = Character.getNumericValue(num);
		System.out.println(
				"| pow = " + tableValue[0] + " | pow + 1 = " + tableValue[1] + " | pow + 2 = " + tableValue[2]);
		if (x == 0) {
		} else if (x == tableValue[2] - tableValue[0]) {
			return tableSymb[pow][0] + tableSymb[pow][2];
		} else if (x >= tableValue[1]) {
			result = result.concat(tableSymb[pow][1]).concat(getUnit(x - tableValue[1], pow));
		} else if (x == tableValue[1]) {
			return tableSymb[pow][1];
		} else if (x == tableValue[1] - tableValue[0]) {
			result = result.concat(tableSymb[pow][0]).concat(tableSymb[pow][1]);
		} else {
			return getUnit(x, pow);
		}
		return result;
	}

	public static String getUnit(int y, int pow) {
		String result = "";
		for (int i = 0; i < y; ++i) {
			result = result.concat(tableSymb[pow][0]);
		}
		return result;
	}

}
