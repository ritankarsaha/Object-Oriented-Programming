package hospitall;
class Doctor extends Person {
    private String specialization;
	private boolean availabilty;
    
    public Doctor(String name, int age, String specialization,int consultationfees ) {
        super(name, age,consultationfees);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        
    }
    
    public void setAvailable() {
    	this.availabilty=true;
    }
    
   
    
    
    
}
