public class PersonData {
    public static void main(String[] args) {
        Student stud = new Student(3, "Rohan", 18);
        Teacher teach = new Teacher(10000, "Machine Learning", "Abhijit", 30);

        stud.introduce();
        teach.introduce();
    }
}

class Person {
    String name;
    int age;

    Person(String i, int j) {
        name = i;
        age = j;
    }
}

class Student extends Person {
    int semester;

    public Student(int sem, String i, int j) {
        super(i, j);
        semester = sem;
    }

    public void introduce() {
        System.out.println("Hello i am a student. my name is " + this.name + ". I am " + this.age
                + " years old in semester " + this.semester);
    }
}

class Teacher extends Person {
    int salary;
    String domain;

    public Teacher(int sal, String dom, String i, int j) {
        super(i, j);
        salary = sal;
        domain = dom;
    }

    public void introduce() {
        System.out.println("Hello i am a teacher. my name is " + this.name + ". I am " + this.age
                + " years old in the domain " + this.domain+". My salary is: "+this.salary+"/-");
    }
}