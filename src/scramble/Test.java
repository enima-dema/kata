package scramble;

public class Test {

	public static void main(String[] arts) {
		
		System.out.println(Scramble.scramble("rkqodlw", "world"));// true);
		System.out.println(Scramble.scramble("cedewaraaossoqqyt", "codewars"));// true);
		System.out.println(Scramble.scramble("katas", "steak"));// false);
		System.out.println(Scramble.scramble("scriptjavx", "javascript"));// false);
		System.out.println(Scramble.scramble("scriptingjava", "javascript"));// true);
		System.out.println(Scramble.scramble("scriptsjava", "javascripts"));// true);
		System.out.println(Scramble.scramble("javscripts", "javascript"));// false);
		System.out.println(Scramble.scramble("aabbcamaomsccdd", "commas"));// true);
		System.out.println(Scramble.scramble("commas", "commas"));// true;
		System.out.println(Scramble.scramble("sammoc", "commas"));// true;
		
	}

}
