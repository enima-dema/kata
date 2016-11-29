package little;

public class Little {

	public static void main(String[] arts) {
		
		System.out.println(findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' })); // e
		
		System.out.println(findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' })); // P
	}

	static String[] alpha = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static char findMissingLetter(char[] array) {
		int index = 0;
		for (int i = 0; i < alpha.length; ++i) {
			if (alpha[i].equalsIgnoreCase(String.valueOf(array[0]))) {
				for (int y = i; y < alpha.length; ++y){
					if (!alpha[y].equalsIgnoreCase(String.valueOf(array[index]))){
						if (String.valueOf(array[index]).equals(String.valueOf(array[index]).toUpperCase())){
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
