package livre;

import utils.Ask;

public class Main {

	public static void main(String[] arts) {
		
		Ask salary = new Ask("Veuillez renseigner le montant de votre salaire");
		Ask elec = new Ask("Veuillez renseigner le montant de votre facture d'électricité.");
		Ask gaz= new Ask("Veuillez renseigner le montant de votre facture de gaz.");
		Ask internet = new Ask("Veuillez renseigner le montant de votre facture d'internet.");

		salary.askIntInput();
		elec.askIntInput();
		gaz.askIntInput();
		internet.askIntInput();
		
		int[] bills = new int[]{elec.getIntInput(),gaz.getIntInput(),internet.getIntInput()};
		int totalBill = elec.getIntInput()+ gaz.getIntInput() + internet.getIntInput();
		int left = salary.getIntInput() - totalBill;
		
		System.out.println("Le montant total de vos facture est de " + totalBill);
		System.out.println("Il vous reste " +left+ " livres pour vivre.");
		
		int howManyFive = left/5;
		
		if (howManyFive > 5) {
			System.out.println("Vous pouvez disposer de "+howManyFive+ " billets de 5 livres.");
		}else {
			System.out.println("Vous disposez de 0 billet de 5 livres");
		}

		
	}
}
