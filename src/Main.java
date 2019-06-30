//

import java.util.Scanner;
public class Main {
	private static void addCountries() //Adding countries to the array
	{
		Country Malaysia = new Country();
		Malaysia.addToArray();
		Country Indonesia = new Country("ID","Indonesia", 3486371.33, 550); //(countryCode, country, 1000RM in Indonesian Currency, Fare of one-way flight)
		Indonesia.addToArray();
		Country Brunei = new Country("BR", "Brunei", 347.04, 393);//(countryCode, country, 1000RM in Brunein Currency, Fare of one-way flight)
		Brunei.addToArray();
		Country Phillipines = new Country("PH", "Phillipines", 13171.04, 1100 );//(countryCode, country, 1000RM in Phillipines Currency, Fare of one-way flight)
		Phillipines.addToArray();
		Country Thailand = new Country("TH", "Thailand",8031.53, 734 );//(countryCode, country, 1000RM in Thai Currency, Fare of one-way flight)
		Thailand.addToArray();
		Country Singapore = new Country("SG", "Singapore", 347.04, 350);//(countryCode, country, 1000RM in Singaporean Currency, Fare of one-way flight)
		Singapore.addToArray();
	}
	
	private static void addPromotions() { 								//Adding promotions to the array
		Promotion newMember = new Promotion("welcometoorion", 10);//(promo, percentage of discount)
		newMember.addToArray();
		Promotion oldPromo = new Promotion("summerdelight", 20);//(promo, percentage of discount)
		oldPromo.addToArray();
	}
	
	private static void addMembers() {//Adding Members to the array
		//member details
	}
	public static boolean termsAndConditions () { //Terms & Conditions
		System.out.println("Orion Tourism ");			//Title
		System.out.println("");					
		Scanner input = new Scanner(System.in);
		int termsandconditions = Inputs.getInt("Terms & Conditions: .... (Press 1 to proceed, or anything else to exit)\n");	//Terms and Conditions are displayed only once. Input 1 proceeds, else exit.
		
		if (termsandconditions == 1) {
			return true;
		}
		System.exit(0);
		return false;
		
	}

	  public static void main (String [] args) {//Main.java
		  termsAndConditions();//Terms and Conditions are displayed once, if yes proceeds to adding countries, promos and members to their array.
		  addCountries();
		  addPromotions();
		  
		  
		  Menu menu = new Menu();//Executing menu.java, invoke the constructor.
		  
		  menu.showmenu(); //invoke the method
		  
	  }
}
