import java.util.ArrayList;//Import Array list
public class Country {
	
	public static ArrayList<Country> countries = new ArrayList<>();//Array - list of countries and their details
	
	
	String shortCode; //Short Code (example. BD for Brunei
	String Name;		//Country Name
	double conversionRate;	//1000RM equivalent to the corresponding currency
	double price;		//Fare of one-way flight
	Country(){//Default country = Malaysia
		shortCode = "MY";
		Name = "Malaysia";
		conversionRate = 1000;
		price = 0;
	}
	
	Country(String shortCode, String Name, double conversionRate, double price){//Constructing a country
		this.shortCode = shortCode;
		this.Name = Name;
		this.conversionRate = conversionRate;
		this.price = price;
	}
	
	void addToArray(){//Adding countries to the array
		countries.add(this);
	}
	public static Country getCountry(String shortCode){//Getting country via shortCode
		for (Country i : countries)
		{
			if (i.shortCode.equals(shortCode.trim()))
				return i;
		}
		return new Country(); // An outcome that should never occur, but just in-case
	}
	
	public static boolean validCountryCode(String shortCode) {//Validating the country 
		for (Country i : countries)
		{
			if (i.shortCode.equals(shortCode.trim()))
				return true;
		}
		return false;
	}
	//double convertMoney(double inMYR) { //Converting money using conversion rate to display 1000 RM equivilant
	//	return (conversionRate/1000) * inMYR;
	//}
}
