package esami2013.appello06.e1;

/**
 * This enumeration models the concept of a month, with a method getDays to get how many days are present in this month.
 * This method generally takes the current year since February has a year-specific number of days
 * Please be sure to check and run the 'main' below to understand how this enumeration works
 */

public enum Month {
	// -1 down here means the number of days is year-specific
	JANUARY(31), FEBRUARY(-1), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), 
	AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

	private int days;

	private Month(int days) {
		this.days = days;
	}

	public int getDays(int year) {
		switch (this) {
		case FEBRUARY:
			return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0) ? 29 : 28;
		default:
			return this.days;
		}
	}

	public static void main(String[] args) {
		// method values of Enumeration gives you an array of all months
		Month[] all = Month.values();
		for (int i = 0; i < all.length; i++) {
			// method ordinal and toString give position and string
			System.out.println("Mese: " + all[i] + " Numero: "
					+ all[i].ordinal() + " Giorni nel 2014: "
					+ all[i].getDays(2014));
		}
		// remember you can use the month's name directly
		Month m2 = FEBRUARY;
		for (int i = 2010; i < 2020; i++) {
			System.out.println("Mese: " + m2 + " Numero: " + m2.ordinal()
					+ " Giorni nel " + i + ": " + m2.getDays(i));
		}
	}
}
