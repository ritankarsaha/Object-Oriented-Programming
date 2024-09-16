
abstract class Employee{
    public abstract void display();
    public abstract void salary();
}

class FullTimeEmployee extends Employee{
    @Override
    public void display(){
       System.out.println("The employee details are that this is employee 1 ");
    }
    public void salary(){
      System.out.println("Employee has a salary of 20,000");
    }
}

class PartTimeEmployee extends Employee{
    @Override
    public void display(){
        System.out.println("The employee details are that this is employee 2 ");
    }
    public void salary(){
        System.out.println("Employee 2 has a salary of 40,000");
    }
}

public class Abstract1 {

    public static void main(String args[]){

    Employee fullTimeEmployee = new FullTimeEmployee();
    Employee partTimeEmployee = new PartTimeEmployee();
    fullTimeEmployee.display();
    fullTimeEmployee.salary();
    partTimeEmployee.display();
    partTimeEmployee.salary();
    }
    
}
