package morse;

public class MorseCode {

	 static String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
             "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
             "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
             "9", "0", " " };
	 
     static String[] dottie = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
             "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
             "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
             "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
             "-....", "--...", "---..", "----.", "-----", "|" };
     
	public static String get(String string){
		
		for (int i = 0; i < dottie.length; ++i){
			if (string.equals(dottie[i])){
				return alpha[i];
			}
		}
		return null;
	}
}
