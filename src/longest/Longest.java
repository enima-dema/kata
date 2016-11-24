package longest;

public class Longest {

	public static int findIt(int[] A) {
		int odd;
		int count;
		for (int i = 0; i < A.length ; ++i){
			count = 0;
			for (int y = 0; y < A.length; ++y){
				if (A[i] == A[y]) ++count;
			}
			if (isOdd(count)){
				return A[i];
			}
		}
	  	return -1;
	  }
	public static boolean isOdd(int x){
		if (x%2 != 0){
			return true;
		}
		return false;
	}
	
	public static String longestConsec(String[] strarr, int k) {
		String string = "";
		
		if (strarr.length == 0 || strarr.length < k || k <=0){
			return string;
		}
		int longest = 1;
		int index = -1;
		
		for (int i = 0; i < strarr.length-(k-1); ++i){
			string = "";
			for (int y = i; y < i+k; ++y){
				string = string.concat(strarr[y]);
			}
			
			if (string.length() > longest){
				longest = string.length();
				index = i;
			}
			//System.out.println("i = " + i + " longest = " + longest + " Index = " + index);
		}
		
		String def ="";
		for (int y = index; y < index+k; ++y){
			def = def.concat(strarr[y]);
			
			}
		return def;
    }
}
