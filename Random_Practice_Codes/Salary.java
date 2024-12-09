
abstract class Employee {
    public abstract void display();
    public abstract void salary();
}

class FullTimeEmployee extends Employee {
    @Override
    public void display() {
        System.out.println("Employee's name is Employee 1 and he is a good employee");
    }
    public void salary(){
       System.out.println("He has a salary of"+ 72.90);
    }
}

class PartTimeEmployee extends Employee {
    @Override
    public void display() {
        System.out.println("Employee's name is Employee 2 and he is a bad employee");
    }
    public void salary(){
        System.out.println("He has a salary of"+ 72222.90);
     }
}


public class Salary {
    public static void main(String[] args) {
 
        Employee FullTimeEmployee = new FullTimeEmployee();
       Employee PartTimeEmployee = new PartTimeEmployee();
        FullTimeEmployee.display();
        FullTimeEmployee.salary();
        PartTimeEmployee.display();
        PartTimeEmployee.salary();
    }
}
