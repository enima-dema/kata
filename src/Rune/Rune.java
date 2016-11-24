package Rune;

public class Rune {

	static String expressionTemp;
	static String[] firstTab;
	static String[] secondTab;
	static String firstDigit, secondDigit, resultDigit;
	static int first, second, result;
	static double factFirst = 0;
	static double factSecond = 0;
	static double factResult = 0;
	static String operator;
	static char op;
	static boolean isFirst0 = false;
	static boolean isSecond0 = false;
	static boolean isResult0 = false;

	public static int solveExpression(final String expression) {
		int missingDigit = -1;
		expressionTemp = expression;
		String expressionII;
		// Get operator
		operator = getOperator(expression);

		// Transform expression if minus minus minus
		if (operator == ";") {
			if (expression.charAt(0) == '-') {
				expressionII = expression.replaceFirst("-", ";");
				expressionII = expressionII.replaceFirst("-", ";");
				expressionII = expressionII.replaceFirst(";", "-");
			} else {
				expressionII = expression.replaceFirst("-", ";");
			}
		} else {
			expressionII = expression;
		}

		// Get the digits
		getTheDigit(expressionII, operator);

		// getFact
		int countFirst = 0;
		while (firstDigit.contains("?")) {
			factFirst += getFact(firstDigit);
			firstDigit = transformDigit(firstDigit);
			++countFirst;
		}
		if (countFirst == firstDigit.length() && firstDigit.length() != 1) {
			isFirst0 = true;
		}

		int countSecond = 0;
		while (secondDigit.contains("?")) {
			factSecond += getFact(secondDigit);
			secondDigit = transformDigit(secondDigit);
			++countSecond;
		}
		if (countSecond == secondDigit.length() && secondDigit.length() != 1) {
			isSecond0 = true;
		}

		int countResult = 0;
		while (resultDigit.contains("?")) {
			factResult += getFact(resultDigit);
			resultDigit = transformDigit(resultDigit);
			++countResult;
		}
		if (countResult == resultDigit.length() && resultDigit.length() != 1) {
			isResult0 = true;
		}

		first = transformInInt(firstDigit);
		second = transformInInt(secondDigit);
		result = transformInInt(resultDigit);

		// Test the equality
		int end = findEquality(first, firstDigit, second, secondDigit, result, resultDigit);
		factFirst = factSecond = factResult = 0;
		isFirst0 = isSecond0 = isResult0 = false;
		return end;
	}

	private static String getOperator(String expression) {
		// Get the digits
		if (expression.contains("+")) {
			return "+";
		} else if (expression.contains("*")) {
			return "*";
		} else if (expression.contains("-")) {
			return ";";
		}
		return "nope";
	}

	private static void getTheDigit(String expression, String operator) {
		firstTab = expression.split("\\" + operator);
		secondTab = firstTab[1].split("=");
		firstDigit = firstTab[0];
		secondDigit = secondTab[0];
		resultDigit = secondTab[1];
		op = operator.charAt(0);
	}

	private static double getFact(String digit) {
		double fact;
		fact = digit.length() - (digit.indexOf("?") + 1);
		fact = Math.pow(10, fact);
		if (digit.contains("-")) {
			fact = fact * -1;
		}
		return fact;
	}

	private static String transformDigit(String digit) {
		digit = digit.replaceFirst("\\?", "0");
		return digit;
	}

	private static int transformInInt(String digit) {
		return Integer.valueOf(digit);
	}

	private static int findEquality(int digit1, String firstDigit, int digit2, String secondDigit, int digitResult,
			String resultDigit) {
		int temp1 = digit1;
		int temp2 = digit2;
		int tempResult = digitResult;
		for (int i = 0; i < 10; ++i) {

			if (!isFirst0 && !isSecond0 && !isResult0) {
				if (factFirst != 0) {
					if (!firstDigit.contains(String.valueOf(i))) {
						first = (int) (temp1 + (factFirst * i));
					}
				}

				if (factSecond != 0) {
					if (!secondDigit.contains(String.valueOf(i))) {
						second = (int) (temp2 + (factSecond * i));
					}
				}

				if (factResult != 0) {
					if (!resultDigit.contains(String.valueOf(i))) {
						result = (int) (tempResult + (factResult * i));
					}
				}

				if (testIfAlready(i)) {
					if (testEquality()) {
						return i;
					}
				}

			} else {
				isFirst0 = isSecond0 = isResult0 = false;
			}
		}
		return -1;
	}

	private static boolean testIfAlready(int i) {
		if (expressionTemp.contains(String.valueOf(i))) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean testEquality() {
		if (operator.equals("+")) {
			return (first + second == result);
		} else if (operator.equals(";")) {
			return (first - second == result);
		} else if (operator.equals("*")) {
			return (first * second == result);
		} else {
			return false;
		}
	}
}
