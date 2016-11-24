package operrand;

import java.text.ParseException;
import java.util.ArrayList;

public class Evaluator {
	String expression;
	String[] expressions = new String[2];
	String[] all;
	String[] couples;
	ArrayList<Long> bigTab = new ArrayList<>();
	long result;
	char[] operrands;

	public long evaluate(String s) {
		expression = s;

		getAll();
		getCouple();
		getNumberAndOperrand();

		long result = calculateII();

		printTest();
		return result;
	}

	private boolean isAnOpperand(char test) {
		if (test == '*' || test == '/' || test == '+' || test == '-') {
			return true;
		}
		return false;
	}

	private void getAll() {
		all = expression.split(" ");
	}

	private void getCouple() {
		couples = new String[3];
		for (int i = 0; i < all.length; ++i) {
			String s = all[i];
			if (isAnOpperand(s.charAt(0))) {
				if (isInteger(all[i - 1]) && isInteger(all[i - 2])) {
					couples[0] = all[i - 2];
					all[i - 2] = "boop";
					couples[1] = all[i - 1];
					all[i - 1] = "boop";
					couples[2] = all[i - 0];
					all[i] = "boop";
					bigTab.add(resolveEquation(couples));
				}
			}
		}
	}

	private long resolveEquation(String[] equation) {
		printTab(couples);
		if (equation[2].equals("+")) {
			return (Long.valueOf(equation[0]) + Long.valueOf(equation[1]));
		} else if (equation[2].equals("-")) {
			return (Long.valueOf(equation[0]) - Long.valueOf(equation[1]));
		} else if (equation[2].equals("*")) {
			return (Long.valueOf(equation[0]) * Long.valueOf(equation[1]));
		} else if (equation[2].equals("/")) {
			return (Long.valueOf(equation[0]) / Long.valueOf(equation[1]));
		}
		return -1;
	}

	private boolean isInteger(String s) {
		try {
			int x = Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private int getNumberOfOp() {
		int nbre = 0;
		for (int i = 0; i < all.length; ++i) {
			if (isAnOpperand(all[i].charAt(0))) {
				++nbre;
			}
		}

		return nbre;
	}

	private void getNumberAndOperrand() {
		int x = 0;
		operrands = new char[getNumberOfOp()];
		for (int i = 0; i < all.length; ++i) {
			if (isAnOpperand(all[i].charAt(0))) {
				operrands[x] = all[i].charAt(0);
				++x;
			}
		}
		for (int i = all.length - 1; i >= 0; --i) {
			if (isInteger(all[i])) {
				bigTab.add(Long.valueOf(all[i]));
			}
		}

		if (bigTab.size() != (operrands.length - 1)) {

		}
	}

	private long calculateII() {
		int x = 0;
		for (int i = 0; i < bigTab.size() - 1; ++i) {
			try {
				if (i == 0) {
					if (operrands[i] == '+') {
						result = bigTab.get(x) + bigTab.get(x + 1);
					} else if (operrands[i] == '-') {
						result = bigTab.get(x) - bigTab.get(x + 1);
					} else if (operrands[i] == '*') {
						result = bigTab.get(x) * bigTab.get(x + 1);
					} else if (operrands[i] == '/') {
						result = bigTab.get(x) / bigTab.get(x + 1);
					}
				} else {
					if (operrands[i] == '+') {
						result += bigTab.get(x + 1);
					} else if (operrands[i] == '-') {
						result -= bigTab.get(x + 1);
					} else if (operrands[i] == '*') {
						result *= bigTab.get(x + 1);
					} else if (operrands[i] == '/') {
						result /= bigTab.get(x + 1);
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				if (i != 0) {
					result *= bigTab.get(x + 1);

				} else {
					result = bigTab.get(x) * bigTab.get(x + 1);
				}
				System.out.println("erreur");
			}
			++x;
		}
		return result;
	}

	private void printTest() {
		printTab(all);

		for (long i : bigTab) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (char x : operrands) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	private void printTab(String[] lol) {
		for (int i = 0; i < lol.length; ++i) {
			System.out.print(lol[i]);
		}
		System.out.println();
	}

}
