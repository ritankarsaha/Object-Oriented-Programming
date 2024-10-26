package TravelBooking;


abstract class booking{
	protected String bookingid;
	protected  String reg;
	
	public booking(String bookingid, String reg) {
		this.bookingid=bookingid;
		this.reg=reg;
	}
	
	public abstract double BookingPrice();
	
	public void displayDetails() {
		System.out.println("Booking Id:-"+bookingid);
		System.out.println("Registration Number:-"+reg);

	}
}

