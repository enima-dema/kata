package morse;

public class Test {

	public static void main(String[] arts) {
		String bits = "1100110011001100000011000000"
				+ "1111110011001111110011111100000000000000"
				+ "11001111110011111100111111000000"
				+ "1100110011111100000011111100"
				+ "11001100000011";
		
		String bits2 = "111";
		String bits3 = "1";
		String bits4 = "01110";
		String bits5 = "1110111";
		String bits6 = "11111100111111";
		String bits7 = "0000000011011010011100000"
				+ "1100000011111101001111100111111"
				+ "000000000001110111111110"
				+ "111110111110000001011000"
				+ "11111100000111110011101100000"
				+ "100000";
		
		//System.out.println(MorseCode.get("---.."));

		//System.out.println(Morse.decodeMorse("   .... . -.--   .--- ..- -.. ."));

		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits2)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits3)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits4)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits5)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits6)));
		System.out.println();
		System.out.println(Morse.decodeMorse(Morse.decodeBitsAdvanced(bits7)));

	}

}
