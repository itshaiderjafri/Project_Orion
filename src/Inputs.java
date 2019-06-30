import java.util.Scanner;
public class Inputs {
	
	static Scanner input = new Scanner(System.in);

	public static int getInt (String prompt) { //Get method to get Integer inputs only
	        System.out.print(prompt);
	        do {
	            if (!input.hasNextInt()) {
	                System.out.println("Integer required ! - error");
	                System.out.print(prompt);
	                input.nextLine();
	            }
	        } while (!input.hasNextInt());
	        return input.nextInt();
	}
	public static String getString (String prompt) {//Get string method to get String inputs only
        System.out.print(prompt);
        do {
            if (!input.hasNext()) {
                System.out.println("String required ! - error");
                System.out.print(prompt);
                input.nextLine();
            }
        } while (!input.hasNext());
        return input.next();
	}
}
