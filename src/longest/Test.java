package longest;

public class Test {

	public static void main(String[] arts) {
		
		//"abigailtheta"
		System.out.println(Longest.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
		//"dqqqaaabbboocccffuucccjjjkkkjyyyeehh
		System.out.println(Longest.longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1));
		//"ixoyx3452zzzzzzzzzzzz"
        System.out.println(Longest.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3));

	}

}
