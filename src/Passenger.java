//Passenger details
public class Passenger {
	String name;
	int age;
	String email;
	String passportSerial;
	Passenger(){}
	
	
	Passenger(String name, int age, String email, String passportSerial){ //Passenger construct
		this.name = name;
		this.age = age;
		this.email = email;
		this.passportSerial = passportSerial;
	}
}
