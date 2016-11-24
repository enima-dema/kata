package walkreduction;

public class Test {
	public static void main(String[] arts) {
		
		String one[] = Walk.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});//West
		String two[] = Walk.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}); //No reduction
		String three[] = Walk.dirReduc(new String[]{"NORTH", "SOUTH"}); //No reduction

		printTab(one);
		printTab(two);
		printTab(three);
		
	}
	
	public static void printTab(String[] tab){
		for (String string : tab){
			System.out.println(string);
		}
	}


}
