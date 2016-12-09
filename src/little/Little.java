package little;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;

public class Little {

	public static void main(String[] arts) {
		String st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        Integer[]we = new Integer[] {1, 3, 5, 5, 3, 6};
		System.out.println(nthRank(st, we, 2));
	}

	static List<String> alphaList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

	public static String nthRank(String st, Integer[] we, int n) {
		if (st.isEmpty()) {
			return "No participants";
		}
		String[] names = st.split(",");
		 if (n > names.length) {
			return "Not enough participants";
		}
		String[][] weigth = new String[names.length][2];
		for (int i = 0; i < names.length; i++) {
			weigth[i][0] = names[i];
			weigth[i][1] = getWeigth(names[i], we[i]);
		}
		Arrays.sort(weigth, new Comparator<String[]>() {
			public int compare(String[] one, String[] two) {
				if (Integer.valueOf(one[1]) < Integer.valueOf(two[1])) {
					return 1;
				} else if (Integer.valueOf(one[1]) > Integer.valueOf(two[1])) {
					return -1;
				} else {
					two[0].compareTo(one[0]);
				}
				return 0;
			}
		});
		
		for(String[] string1 : weigth){
			for (String string2 : string1){
				System.out.println(string2);
			}
		}

		return weigth[n - 1][0];
	}

	public static String getWeigth(String st, int w) {
		int u = 0;
		for (int i = 0; i < st.length(); ++i) {
			u += alphaList.indexOf(String.valueOf(st.charAt(i)).toUpperCase());
		}
		u += st.length();
		u *= w;
		return String.valueOf(u);
	}

	public static String playPass(String s, int n) {
		String string = "";
		for (int i = 0; i < s.length(); ++i) {
			if (i % 2 == 0) {
				string = string.concat(getLetter(s.charAt(i), n).toUpperCase());
			} else {
				string = string.concat(getLetter(s.charAt(i), n).toLowerCase());
			}
		}
		return new StringBuilder(string).reverse().toString();
	}

	public static String getLetter(char one, int n) {
		if (Character.isDigit(one)) {
			return String.valueOf(9 - Character.getNumericValue(one));
		} else if (Character.isAlphabetic(one)) {
			int index = alphaList.indexOf(String.valueOf(one)) + n;
			do {
				if (index < alphaList.size()) {
					return (alphaList.get(index));
				} else {
					index -= alphaList.size();
				}
			} while (index > alphaList.size());
			return (alphaList.get(index));
		} else {
			return String.valueOf(one);
		}
	}

	static String[] alpha = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static long digPow(int n, int p) {
		String number = String.valueOf(n);
		double u = 0;
		for (int i = 0; i < number.length(); ++i) {
			u += Math.pow(Character.getNumericValue(number.charAt(i)), p + i);
		}

		Float x = (float) (u / n);
		if (x == x.longValue()) {
			return x.longValue();
		}
		return -1;
	}

	public static char findMissingLetter(char[] array) {
		int index = 0;
		for (int i = 0; i < alpha.length; ++i) {
			if (alpha[i].equalsIgnoreCase(String.valueOf(array[0]))) {
				for (int y = i; y < alpha.length; ++y) {
					if (!alpha[y].equalsIgnoreCase(String.valueOf(array[index]))) {
						if (String.valueOf(array[index]).equals(String.valueOf(array[index]).toUpperCase())) {
							return alpha[y].toUpperCase().charAt(0);
						}
						return alpha[y].charAt(0);
					}
					++index;
				}
			}
		}
		return ' ';
	}

	public int min(int[] list) {
		int min = list[0];
		for (int i : list) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public int max(int[] list) {
		int max = list[0];
		for (int i : list) {
			if (max < i) {
				max = i;
			}
		}
		return max;
	}

	public static String switchItUp(int number) {
		switch (number) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		}
		return "";
	}

	public static double getPrice(int startPrice, double percentageLossByMonth) {
		double result = startPrice - (startPrice * (percentageLossByMonth / 100));

		return result;
	}

	static int[] lol;

	public static int findEvenIndex(int[] arr) {
		lol = arr;
		for (int i = 0; i < arr.length; ++i) {
			if (getBefore(i) == getAfter(i)) {
				return i;
			}
		}

		return -1;
	}

	public static int getBefore(int index) {
		int result = 0;
		for (int i = 0; i < index; ++i) {
			result += lol[i];
		}
		return result;
	}

	public static int getAfter(int index) {
		int result = 0;
		for (int i = index + 1; i < lol.length; ++i) {
			result += lol[i];
		}
		return result;
	}

	public static int persistence(long n) {
		int count = 0;
		int lol = (int) n;
		String number = String.valueOf(lol);
		do {
			number = String.valueOf(lol);
			int u = 1;

			for (int i = 0; i < number.length(); ++i) {
				String s = String.valueOf(number.charAt(i));
				u *= Long.valueOf(s);
			}

			lol = u;
			System.out.println("Value of u " + u + " Value of number " + number + "Value of lol " + lol);
			++count;
		} while (number.length() > 1);

		return count - 1;
	}
}
