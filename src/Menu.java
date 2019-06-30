import java.util.*;
public class Menu {
	void showmenu () {															//Menu method, displays menu. Enter the corresponding number to continue. 1-3 returns back to menu. 4 Exits application.
		while(true)
		{
			System.out.println("MAIN MENU");
			int menuSelection = Inputs.getInt("1. Book A Flight \n"
											+ "2. Register for Membership \n"
											+ "3. Terms & Conditions \n"
											+ "4. Exit\n");
			switch (menuSelection) {
			case 1: newBooking();
			break;
			
			case 2: registerMembership();
			break;
			
			case 3: rulesforBooking();
			break;
			
			case 4: System.exit(0);
			}
		}
	}
	void rulesforBooking() {													//Terms & Conditions
	System.out.println("Terms & Conditions");//go back to the menu->						
	}
																				//Section 1
	void newBooking() {			//Booking a Flight
		
		boolean returnFlight = false;											//Pre-setting boolean values to false
		boolean tourGuide = false;
		boolean bookdisabledTransport = false;
		boolean bookprivateDriver = false;
		boolean bookprivateCar = false;
		
		
		System.out.println("------Section 1------");
		System.out.println("Passenger Details");

		
		int passengerAdults = Inputs.getInt("How many Adult passengers?");				//Number of Passengers (Adult, Children) (Disabled) (Total = Adult+Children)
		int passengerChildren = Inputs.getInt("How many Children passengers?");
		
		int disabledPassengers = Inputs.getInt("How many disabled passengers?");
		int totalPassengers = passengerAdults + passengerChildren;
		
		
		Passenger[] passengers = new Passenger[totalPassengers];				//Getting details of the Passsengers
		for (int x=0; x < totalPassengers; x++){
			String name = Inputs.getString("Name: ");
			int age = Inputs.getInt("Age: ");
			String email = Inputs.getString("email address: ");
			String passportSerial = Inputs.getString("Passport Number : #");
			passengers[x] = new Passenger(name,age,email,passportSerial);
		}
		
		System.out.println("------Section 2------");
		System.out.println("Membership Details");										//If Member = Yes, Enter ID. 
		int havemember = Inputs.getInt("Are you a member? (1 for yes, 0 for no)");						//Verify ID. If yes, print welcome back message or
		if (havemember == 1)													//if no, register?
		{
			int memberid = Inputs.getInt("Enter member ID: ");
			if (Membership.isMember(memberid))
			{
				System.out.println("Welcome back!"); 
			}
			else
			{
				System.out.println("No Account found");
				int registerNow = Inputs.getInt("Would you like to register?");
				if (registerNow == 1)
				{
					registerMembership();										//Register now function
				// if registernow is 1 then is member
				}
			}
		}
		else {
			int registerNow = Inputs.getInt("Would you like to register for membership?");
			if (registerNow ==1) {
				registerMembership();
			}
		}
		String destinationCode;
		System.out.println("------Section 3------");
		System.out.println("Travel Details");


		do {
		destinationCode = Inputs.getString("Enter Destination Code:\n"			//Section 2 - Travel Details
						+  "1. ID Bali, Indonesia.\n" 							//Select Country by typing country CODE
						+  "2. PH Philipines\n"
						+  "3. SG Singapore\n"
						+  "4. BR Brunei\n"
						+  "5. TH Thailand\n");
		System.out.println(destinationCode);
		} while(!(Country.validCountryCode(destinationCode)));
		int oneWayOrReturn = Inputs.getInt("Is it a one-way flight or return? (1- one-way, 2- return\n");	//Asking if it is a one-way flight or return. If return, the price is twice the price of a one-way flight.
		String departureDate = Inputs.getString("Enter departure date (dd/mm/yy):  \n"); //Departure Dates, only printing
		if (!(oneWayOrReturn == 1))
		{
			String returnDate = Inputs.getString("Enter arrival date (dd/mm/yy): \n"); //Only asked, if return is true.
		}
		System.out.println("------Section 4------");
		System.out.println("Tour Details");

		int tourType = Inputs.getInt("What kind of tour?\n" 							//Tour Choice 0=no tour
									+"1. Backpacking\n" // 100							
									+"2. Sightseeing\n" // 200
									+"3. Famous Landmarks\n" // 250
									+"4. Combine\n" // 300								//Combine all, the preference depends on passengers when they go and travel.
									+"5. All\n");//0 for no tour
		//fare pricing with if else statements - Booking.java
		
		//boolean tourGuide, disabledTransport, privateDriver, privateCar;
		if (oneWayOrReturn == 2){
			returnFlight = true;
		}
		if (tourType > 0){
			int tourguides = Inputs.getInt("Do you require a tour guide? \n");
			tourGuide = true;
		}
		if (disabledPassengers>0) {
			int disabledTransport = Inputs.getInt("Do you require special transport assistance?\n");
			if(disabledTransport > 0) {
				bookdisabledTransport = true;
			}
		}
		int privateDriver = Inputs.getInt("Do you require a private driver? \n");
		if(privateDriver>0) {
			bookprivateDriver = true;
		}
		else {
			int privateCar = Inputs.getInt("Do you require a private car?\n");
			if (privateCar>0) {
				bookprivateCar = true;
			}
		}
		System.out.println("------Section 5------");
		System.out.println("Payment & Receipt");

		Booking booking = new Booking(passengers,destinationCode,disabledPassengers,tourType, returnFlight,tourGuide,bookdisabledTransport, bookprivateDriver, bookprivateCar); //Booking class is 
		String promo = Inputs.getString("Enter promotion code if any:  ");
		System.out.println("Total Price - " + booking.calculatePrice(Promotion.getPromotion(promo)));
		
		Payment pay = new Payment(booking); //Temporary Save
		Transaction transaction = new Transaction(); //Transaction class - Transaction process(only for display, no function)
		
		
		transaction.processTransaction(booking);
		if (transaction.processTransaction(booking)) {
			System.out.println("Transaction Successful");
		}
		else {
			System.out.println("Transaction Unsuccessful");
		}
		
	}
	
	//boolean tourGuide, boolean disabledTransport, boolean privateDriver, boolean privateCar){
	void displayDestinations() {
		System.out.println();
		
	}
	void registerMembership() {//Registering for membership
		String email = Inputs.getString("Email : ");
		Membership newmember = new Membership(email);
		newmember.addMember();
		System.out.println("Congratulations! You have recieved a new promotion for signing up as a member. The promo is : welcometoorion");
	}
}
