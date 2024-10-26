package hospitall;

class Patient extends Person {
    private String illness;

    public Patient(String name, int age, String illness, int consultationfees ) {
        super(name, age,consultationfees );
        this.illness = illness;
    }

    public String getIllness() {
        return illness;
    }
    
    public String getName() {
    	return name;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Illness: " + illness);
    }
}