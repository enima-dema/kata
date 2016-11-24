package walkreduction;

import java.util.ArrayList;

public class Walk {
	static boolean again = false;
	static String west = "WEST";
	static String east = "EAST";
	static String north = "NORTH";
	static String south = "SOUTH";

	public static String[] dirReduc(String[] arr) {
		String[] string = arr;

		do {
			again = false;
			string = reducII(string);
		} while (again);

		return string;
	}

	public static String[] reducII(String[] arr) {
		String[] temp = new String[0];
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] != null) {
				if (getIfCancel(arr[i], arr[i + 1])) {
					arr[i] = null;
					arr[i + 1] = null;
					again = true;
				} else {
					list.add(arr[i]);
				}
			}
		}
		if (arr.length > 0) {
			if (arr[arr.length - 1] != null) {
				list.add(arr[arr.length - 1]);
			}
		}

		System.out.println(list);

		temp = new String[list.size()];
		for (int i = 0; i < temp.length; ++i) {
			temp[i] = list.get(i);
		}

		return temp;
	}

	public static boolean getIfCancel(String one, String two) {
		if (one.equals(north) && two.equals(south)) {
			return true;
		} else if (one.equals(south) && two.equals(north)) {
			return true;
		} else if (one.equals(west) && two.equals(east)) {
			return true;
		} else if (one.equals(east) && two.equals(west)) {
			return true;
		}
		return false;
	}
}
