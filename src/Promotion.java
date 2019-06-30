import java.util.ArrayList;
public class Promotion {
	public static ArrayList<Promotion> promotions = new ArrayList<>();//Promotion Array. Promotion Details (promo, discount)
	
	private String promoCode;
	private int discount = 0;
	Promotion(){}
	Promotion(String promoCode, int discount){ //constructing promotion
		this.promoCode = promoCode;
		this.discount = discount;
	}
	void addToArray() { //Adding it to the array
		promotions.add(this);
	}
	public static Promotion getPromotion(String promoCode){//Getting promotion. If promo entered matches the one in array, return promo found
		for (Promotion promotion : promotions) {
			if (promotion.promoCode.equals(promoCode.trim())) {
				System.out.println("Promo found!");
				return promotion;
			}
		}
		return null;
	}
		
		
		/*for (Promotion i : promotions) {
		if (i.promoCode.equals(promoCode.trim()))
			System.out.println("Promo found");
			return i;
		}
	return new Promotion(); // should never happen but...
	}*/
	public static boolean validPromotion(String promoCode) {//Validating promotion
		for (Promotion i : promotions)
		{
			if (i.promoCode.equals(promoCode.trim()))
				return true;
		}
		return false;
	}
	public int getDiscount() {//Getting discount
		return discount;
	}
}
