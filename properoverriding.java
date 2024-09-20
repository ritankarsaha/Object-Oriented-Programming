public class properoverriding {

    public static void main(String args[]){
   Dog dog = new Dog("Tommy", "Labrador");
    dog.sound();
    dog.display();
}
}


class Animal{

    public void sound(){
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal{

    String name, breed;
    Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    @Override
    public void sound(){
        super.sound();
        System.out.println("Dog makes a sound");
    }

    public void display(){
        System.out.println("Name of the dog is: "+name);
        System.out.println("Breed of the dog is: "+breed);

    }
}