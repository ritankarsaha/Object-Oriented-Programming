public class University {
    public static void main(String[] args) {
   
        Department[] dept = {new Department(), new Department(), new Department()};
        for (Department elem : dept) {
            Student[] stud = elem.getStudents();
            for (Student el : stud) {
                System.out.println("name: " + el.name + ", age: " + el.age);
            }
        }
    }
}


class Student {
    int age;
    String name;

   
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


class Department {
    String name;

    Department() {}


    public Student[] getStudents() {

        Student[] stud = {new Student(10, "Rohan"), new Student(15, "Ritankar")};
        return stud;
    }
}