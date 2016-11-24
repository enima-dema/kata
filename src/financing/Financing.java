package financing;

public class Financing {
	int days;
	int numberOfWeeks;
	long money;

	//Constructeur, prenant le nombre jour en param�tre afin de servir de base pour le reste des calculs
	public Financing(int days, int weeks) {
		this.days = days;
		this.numberOfWeeks = weeks+1;
		getAllTheMoney();
	}

	//Permet d'obtenir la quantit� d'argent que l'on obtient relativement au nombre de jour
	public void getAllTheMoney() {
		for (int i = 0; i < numberOfWeeks; ++i){
			getMoneyOneW(i);
		}
	}

	//Permet d'obtenir l'argent �conomis� en une semaine. 
	public void getMoneyOneW(int nope) {
		int x = 0;
		for (int i = 0; i < days; ++i) {
			if (i >= nope) {
				money = money + (nope * 2) + x;
				++x;
			}
		}
	}
}
