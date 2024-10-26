package TravelBooking;

 class Flight extends booking {
	 public int Year;
	 public Flight(String bookingid, String reg) {
		 super(bookingid,reg);
	 }
	 public Flight(String bookingid,String reg,int Year) {
		 super(bookingid,reg);
	 }
	 public String bookingid() {
		 return bookingid;
	 }
	 @Override
	 public double BookingPrice() {
		 return 9000.0;
	 }
	 @Override
	 public void displayDetails() {
		 super.displayDetails();
		 System.out.println("The booking Price is:- "+BookingPrice());
	 }
	 
	 

}
