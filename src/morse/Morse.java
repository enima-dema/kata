package morse;

public class Morse {

	public static String decodeBitsAdvanced(String bits) {

		System.out.println(bits);
		bits = replaceBeginning0(bits);
		bits = replaceEnding0(bits);
		bits = bits.trim();

		int hl1 = getHowLongShorterSymb(bits, "0");
		int hl0 =  getHowLongShorterSymb(bits, "1");
		int hl;
		if (hl1 > hl0){
			hl = hl0;
		}else {
			hl = hl1;
		}
		
		System.out.println("Unit = " + hl);

		String spaceBW = code(hl, "0000000");
		String spaceBL = code(hl, "000");
		String spaceBS = code(hl, "0");
		String dot = code(hl, "1");
		String dash = code(hl, "111");

		return traductToMorse(bits, spaceBW, spaceBL, spaceBS, dot, dash);
	}

	public static String replaceBeginning0(String bits) {
		for (int i = 0; i < bits.length(); ++i) {
			if (bits.charAt(i) == '0') {
				bits = bits.replaceFirst("0", " ");
			} else {
				i = bits.length();
			}
		}
		return bits;
	}

	public static String replaceEnding0(String bits) {
		for (int i = bits.length() - 1; i >= 0; --i) {
			if (bits.charAt(i) == '0') {
				bits = bits.substring(0, i);
			} else {
				i = 0;
			}
		}
		return bits;
	}

	
	public static int getHowLongShorterSymb(String bits, String noSymb) {
		String[] getOnes = bits.split(noSymb);
		
		for (int i = 1; i < bits.length(); ++i){
			for (int y = 0; y < getOnes.length; ++y){
				if (i == getOnes[y].length()){
					return i;
				}
			}
		}
		return bits.length();
	}

	public static boolean getIfSmallerSpace(String bits, int unit) {
		String[] getZero = bits.split("1");
		int x = unit / 3;
		if (x > 0) {
			String toTest = code(x, "0");
			System.out.println("ToTest = " + toTest);
			for (int i = 1; i < getZero.length; ++i) {
				if (getZero[i].equals(toTest)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String code(int i, String symb) {
		String string = "";
		for (int y = 0; y < i; ++y) {
			string = string.concat(symb);
		}
		return string;
	}

	public static String traductToMorse(String bits, String spaceBW, String spaceBL, String spaceBS, String dot,
			String dash) {
		String[] words = bits.split(spaceBW);

		String string = "";
		for (int i = 0; i < words.length; ++i) {
			for (String code : words[i].split(spaceBL)) {
				// Get each symbol !
				String lol = "";
				for (String symbol : code.split(spaceBS)) {
					if (symbol.equals(dot)) {
						lol = lol.concat(".");
					} else if (symbol.equals(dash)) {
						lol = lol.concat("-");
					} else {
						System.out.println("Erreur. Symbol = " + symbol);
					}
				}
				string = string.concat(lol + " ");
			}
			string = string.concat("  ");
		}

		System.out.println(string);
		return string;
	}

	public static String decodeMorse(String morseCode) {

		morseCode = morseCode.trim();
		String[] words = morseCode.split("   ");
		String string = "";

		for (int i = 0; i < words.length; ++i) {
			for (String code : words[i].split(" ")) {
				String bip = MorseCode.get(code);
				if (bip != null) {
					string = string.concat(bip);
					System.out.println("bip = " + bip);
				} else {
					System.out.println("bip = " + bip);
				}
			}

			if (i != words.length - 1) {
				string = string.concat(" ");
			}
		}

		return string;
	}
}
