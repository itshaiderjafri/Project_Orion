
public class Booking {
	Passenger[] passengers; //Passengers array
	String DestinationShortCode; 
	int disabled; //number of disabled passengers
	int tourType; //1-5 for corresponding tour type, 0 for no tour.
	boolean returnFlight; // 1 way = false, return = true
	//double fare;
	boolean tourGuide, disabledTransport, privateDriver, privateCar;//Boolean values for tour guide, transport for disabled, private car and/or driver.
	
	
	Booking(Passenger[] passengers, String Destination, int disabled, int tourType, boolean returnFlight, boolean tourGuide, boolean disabledTransport, boolean privateDriver, boolean privateCar){ //Booking construct is made up these variables
		this.passengers = passengers;
		this.DestinationShortCode = Destination; // convert this to Country
		this.disabled = disabled;
		this.tourType = tourType;
		this.returnFlight = returnFlight;
		//this.fare = fare;
		this.tourGuide = tourGuide; // 500
		this.disabledTransport = disabledTransport; // 100
		this.privateDriver = privateDriver; // 200
		this.privateCar = privateCar; // 300
	}

	double calculatePrice(Promotion promotion) {//Construct to calculate the price
		
		Country Destination = Country.getCountry(DestinationShortCode);//Executing country.java, invoking the construct
		double price = 0;//Final Price
		int pax = passengers.length;//Number of passengers
		int tourPrice = 0;//Tour price (tour types, tour assistance, tour transport)
		if (tourType != 0){
			switch (tourType) {
			case 1:
				tourPrice = 250;//Back-packing
				break;
			case 2:
				tourPrice = 200;//Sight-seeing
				break;
			case 3:
				tourPrice = 300;//Famous Landmarks
				break;
			case 4:
				tourPrice = 350;//Combine 2
				break;
			case 5:
				tourPrice = 450; //All
				break;
			}
		}
		price += tourPrice; //price + tourPrice
		if (tourGuide)//TourGuide
			price += 500;
		if (disabledTransport)//Transport for Disabled
			price += 100;
		if (privateDriver)//Private Driver (comes with a car)
			price += 300;
		if (!privateDriver && privateCar)
			price += 200; //(if no private driver) private car
		double airticketprice = pax*Destination.price; //ticket price = number of passengers * destination price
		if (returnFlight)
			airticketprice = airticketprice *2;//return flight, ticket price * 2
		price += airticketprice; // price + ticket price
		if (promotion!=null) { //if promotion is not null
			System.out.println("Before promotion final price :   " + price); //Price before discount
			System.out.println("Discount : " + (promotion.getDiscount()*price)/100);
			price = (price - ((promotion.getDiscount()*price)/100));
			System.out.println(promotion.getDiscount());
			System.out.println("After promotion final price :" + price);
		}
		return price; //return final price
	} 
	
	
	
}
