//Payment details
public class Payment {
	Booking booking;
	int status;
	double price;
	int discount;
	String promo;
	
	Payment(Booking booking)
	{
		this.booking = booking;
	}
	boolean applyPromo(String promo) {
		if (Promotion.validPromotion(promo))
		{
			return true;
		}
		else return false;
	}
}
