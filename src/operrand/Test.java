package operrand;

public class Test {
	public static void main(String[] arts) {
		String test = "1 2 3 + 3 * ";
		Evaluator eval = new Evaluator();
		System.out.println(test);
		System.out.println(eval.evaluate(test));
	}
}
