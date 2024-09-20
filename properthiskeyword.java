public class properthiskeyword {

    public static void main(String args[]){
        Student s1 = new Student("John", 20);
        Student s2 = new Student();
        s1.display();
        s2.display();
        // s1.incrementAge();
        s1.updateAge(s1);
        s1.display();
    }
    
}


class Student{

    //instance variables
    String name;
    int age;
    // using this operator to refer to the proper instance variables
    Student(String name, int age){
        this.name = name;
        this.age =age;
    }

    //constructor chaining use fo this keyword
    Student(){
        this("Ritankar", 20);
    }

    // use of this keyword is optional over here.
    public void display(){
        System.out.println(this.age+" "+this.name);
    }

    public void updateAge(Student s){
        this.age = s.age+2;
    }

    // public void incrementAge(){
    //     this.updateAge(this);
    // }

}