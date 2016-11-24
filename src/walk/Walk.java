package walk;

public class Walk {

	public static void main(String[] arts) {

		System.out.println(isValid(new char[] { 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's' }));
		System.out.println(isValid(new char[] { 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e' }));
		System.out.println(isValid(new char[] { 'w' }));
		System.out.println(isValid(new char[] { 'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's' }));

	}

	public static boolean isValid(char[] walk) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < walk.length; ++i) {
			if (walk[i] == 'n') {
				y += 1;
			} else if (walk[i] == 's') {
				y -= 1;
			} else if (walk[i] == 'e') {
				x += 1;
			} else if (walk[i] == 'w') {
				x -= 1;
			}
		}

		System.out.println( x + " " + y);
		
		if (x == 0 && y == 0 && walk.length == 10) {
			return true;
		}
		return false;
	}
}
