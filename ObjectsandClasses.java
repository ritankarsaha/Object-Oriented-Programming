public class ObjectsandClasses {

    public static void main(String args[]){
        Student stud = new Student("Ritankar",28,2);
        Teacher teacher = new Teacher("Hello", 29, 3);
        stud.introduce();
        teacher.introduce();
    }
    
}


class Person{
    String name;
    int age;

    Person(String i, int j){
        name = i;
        age =j;

    }
}

class Student extends Person{
    int semester;
    
    public Student(String i, int j, int sem){
        super(i,j);
        semester = sem;

    }

    public void introduce(){
        System.out.println("My name is"+this.name+" and I am "+this.age+" years old. I am in semester "+this.semester);
    }
}

class Teacher extends Person{
    int semester;

    public Teacher(String i, int j, int sem){
        super(i,j);
        semester = sem;
    }

    public void introduce(){
        System.out.println("My name is"+this.name+" and I am "+this.age+" years old. I am teaching semester "+this.semester);
    }
}