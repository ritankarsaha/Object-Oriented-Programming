package TravelBooking;

 class Hotel extends booking {
	 public int Year;
	 public Hotel(String bookingid, String reg) {
		 super(bookingid,reg);
	 }
	 public Hotel(String bookingid,String reg,int Year) {
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
