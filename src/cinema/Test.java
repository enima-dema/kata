package cinema;

public class Test {

	public static void main(String[] arts) {
		test1();
	}

	private static void testing(long actual, long expected) {
		//assertEquals(expected, actual);
		System.out.println(actual);
		System.out.println(expected);
		System.out.println();
	}

	public static void test1() {
		System.out.println("Fixed Tests: movie");
		testing(Movie.movie(500, 15, 0.9), 43);
		testing(Movie.movie(100, 10, 0.95), 24);
	}

}
