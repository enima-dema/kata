package financing;

public class Test {

	public static void main(String[] arts) {
		Financing fin = new Financing(7, 6);	
		System.out.println(fin.money);
		
		Financing flip = new Financing(8, 5);	
		System.out.println(flip.money);
		
		Financing flop = new Financing(9, 9);	
		System.out.println(flop.money);
		
		Financing flup = new Financing(10, 10);	
		System.out.println(flup.money);
		
		Financing flap = new Financing(11, 2);	
		System.out.println(flap.money);
		
		Financing xorgTheInfinityDestructor = new Financing(5000, 35000);	
		System.out.println(xorgTheInfinityDestructor.money);
	}
	
	
	
}
