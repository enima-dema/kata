package scramble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Scramble {

	public static boolean scramble2(String str1, String str2) {
		System.out.println(str1);
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		boolean isThereChar;
		for (int i = 0; i < str2.length(); ++i) {
			isThereChar = false;
			for (int y = 0; y < str1.length(); ++y) {
				if (!indexs.contains(y)) {
					if (str2.charAt(i) == str1.charAt(y)) {
						isThereChar = true;
						indexs.add(y);
						y = str1.length();
					}
				}
			}
			if (!isThereChar) {
				return false;
			}
		}
		return true;
	}

	public static boolean scramble1(String str1, String str2) {
		for (int i = 0; i < str2.length(); ++i) {
			if (!str1.contains(String.valueOf(str2.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public static boolean scramble(String str1, String str2) {
		ArrayList<Character> char1 = new ArrayList<Character>();
		ArrayList<Character> char2 = new ArrayList<Character>();
		
		for (char c : str1.toCharArray()){
			char1.add(c);
		}
		for (char c : str2.toCharArray()){
			char2.add(c);
		}
		
		Collections.sort(char1);
		Collections.sort(char2);

		for (int i = 0; i < char1.size() ; ++i){
			if(!char2.contains(char1.get(i))){
				char1.remove(i);
			}
		}
		
		System.out.println(char1.toString());
		System.out.println(char2.toString());

		if (char2.equals(char1)){
			return true;
		}
		
		return false;
		
	}

}
