package mixing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mixing {
	public static <T> String mix(String s1, String s2) {
		String[] strings = new String[] { s1, s2 };
		// Extract data into map
		ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 2; i++) {
			for (int y = 0; y < strings[i].length(); ++y) {
				String s = String.valueOf(strings[i].charAt(y));
				String address = String.valueOf(i);
				int x = getIndex(map, address, s);
				System.out.println(" x = " +x+ "/ address = " +address+ "/ s = " +s);
				if (x == -1) {
					ArrayList<String> add = new ArrayList<String>();
					add.add(s); // Which letter
					add.add(String.valueOf(i)); // Address
					add.add(String.valueOf(1)); // Weight
					map.add(add);
				} else {
					ArrayList<String> update = map.get(x);
					int v = Integer.valueOf(update.get(2)) + 1;
					System.out.println("v = " +v);
					update.set(2, String.valueOf(v));
					map.set(x, update);
				}
			}
		}
		
		printList(map);
		// Get only pertinent data
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < map.size(); i++) {
			ArrayList<String> toCompare = map.get(i);
			if (isItValid(toCompare.get(0), Integer.valueOf(toCompare.get(2)))) {
				results = addTest(results, toCompare);
			}
		}

		// Sort
		Collections.sort(results, new Comparator<ArrayList<String>>() {
			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {
				if (Integer.valueOf(o1.get(2)) < Integer.valueOf(o2.get(2))) {
					return 1;
				} else if (Integer.valueOf(o1.get(2)) > Integer.valueOf(o2.get(2))) {
					return -1;
				} else {
					if (Integer.valueOf(o1.get(1)) < Integer.valueOf(o2.get(1))) {
						return -1;
					} else if (Integer.valueOf(o1.get(1)) > Integer.valueOf(o2.get(1))) {
						return 1;
					} else {
						return o1.get(0).compareTo(o2.get(0));
					}
				}
			}
		});
		// Build the string
		String result = "";
		for (int i = 0; i < results.size(); ++i) {
			ArrayList<String> toGet = results.get(i);
			result = result.concat(toGet.get(1) + ":" + getString(Integer.valueOf(toGet.get(2)), toGet.get(0)));
			if (i != results.size() - 1) {
				result = result.concat("/");
			}
		}
		result = result.replaceAll("3", "=");
		return result;
	}

	public static int getIndex(ArrayList<ArrayList<String>> strings, String address, String s) {
		for (int i = 0; i < strings.size(); ++i) {
			if (strings.get(i).get(0).equals(s) && strings.get(i).get(1).equals(address)) {
				return i;
			}
		}
		return -1;
	}

	public static int getIndex(ArrayList<ArrayList<String>> strings, String s) {
		for (int i = 0; i < strings.size(); ++i) {
			if (strings.get(i).contains(s)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<ArrayList<String>> addTest(ArrayList<ArrayList<String>> results,
			ArrayList<String> toCompare) {
		int x = getIndex(results, toCompare.get(0));
		if (x != -1) {
			if (Integer.valueOf(results.get(x).get(2)) < Integer.valueOf(toCompare.get(2))) {
				toCompare.set(1, String.valueOf(Integer.valueOf(toCompare.get(1)) + 1));
				results.set(x, toCompare);
			} else if (Integer.valueOf(results.get(x).get(2)) == Integer.valueOf(toCompare.get(2))) {
				toCompare.set(1, "3");
				results.set(x, toCompare);
			}
		} else {
			toCompare.set(1, String.valueOf(Integer.valueOf(toCompare.get(1)) + 1));
			results.add(toCompare);
		}
		return results;
	}

	public static boolean isItValid(String s, int weight) {
		if (Character.isAlphabetic(s.charAt(0)) && s.toLowerCase().equals(s) && weight > 1) {
			return true;
		}
		return false;
	}

	public static String getString(int weight, String c) {
		String result = "";
		for (int i = 0; i < weight; ++i) {
			result = result.concat(c);
		}
		return result;
	}

	public static void printList(ArrayList<ArrayList<String>> lists) {
		for (ArrayList<String> strings : lists) {
			for (String string : strings) {
				System.out.print(string);
			}
			System.out.println();
		}
		System.out.println("-----------------------");

	}
}
