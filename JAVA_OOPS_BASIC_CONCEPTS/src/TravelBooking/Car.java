package TravelBooking;

 class Car extends booking {
	 public int Year;
	 public Car(String bookingid, String reg) {
		 super(bookingid,reg);
	 }
	 public Car(String bookingid,String reg,int Year) {
		 super(bookingid,reg);
	 }
	
	 @Override
	 public double BookingPrice() {
		 return 9000.0;
	 }
	 
	 public String bookingid() {
		 return bookingid;
	 }
	 
	 @Override
	 public void displayDetails() {
		 super.displayDetails();
		 System.out.println("The booking Price is:- "+BookingPrice());
	 }
	 
	 

}
