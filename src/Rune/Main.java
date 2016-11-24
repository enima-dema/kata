package Rune;

public class Main {

	public static void main(String[] arts) {
		assertEquals("Answer for expression '1+1=?' ", 2, Rune.solveExpression("1+1=?"));
		assertEquals("Answer for expression '1?3+1?3=?46' ", 2, Rune.solveExpression("1?3+1?3=?46"));
		assertEquals("Answer for expression '123*45?=5?088' ", 6, Rune.solveExpression("123*45?=5?088"));
		assertEquals("Answer for expression '-5?*-1=5?' ", 0, Rune.solveExpression("-5?*-1=5?"));
		assertEquals("Answer for expression '19--45=5?' ", -1, Rune.solveExpression("19--45=5?"));
		assertEquals("Answer for expression '??*??=302?' ", 5, Rune.solveExpression("??*??=302?"));
		assertEquals("Answer for expression '?*11=??' ", 2, Rune.solveExpression("?*11=??"));
		assertEquals("Answer for expression '-1?-1?=?4", 2, Rune.solveExpression("-1?-1?=-?4"));
	}
	
	public static void assertEquals(String exp, int numb, int sol){
		System.out.println(exp);
		if (sol == numb){
			System.out.println("La bonne réponse était bien " + sol + " bravo !");
		}else{
			System.out.println(sol + " n'était pas la bonne réponse, essaie encore.");
		}
		System.out.println();
	}
}
