package hospitall;

class Person {
    protected String name;
    protected int age;
    public int consultationfees;

    public Person(String name, int age, int consultationfees) {
        this.name = name;
        this.age = age;
        this.consultationfees = consultationfees;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    public int getConsultationFees() {
    	return consultationfees;
    }
}