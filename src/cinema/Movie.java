package cinema;

public class Movie {

	static int card;
	static int ticket;
	static double ticketCard;
	static double perc;

	public static int movie(int card, int ticket, double perc) {
		Movie.card = card;
		Movie.ticket = ticket;
		Movie.ticketCard = ticket;
		Movie.perc = perc;

		int numberOfGo = 0;

		do {
			++numberOfGo;
			//System.out.println();
		} while (getPrice(numberOfGo) < getPriceCard(numberOfGo));

		return numberOfGo;
	}

	public static int getPrice(int numberOfGo) {
		int ret = ticket * numberOfGo;
		return ret;
	}

	public static double getPriceCard(int numberOfGo) {
		double ret = card + ticketCard;
		ticketCard =  ticketCard * perc + ticketCard;
		System.out.println(ret);
		return ret;
	}
}
