
class Sports {
    public void start() {
        System.out.println("the game is starting");
    }
}

class Cricket extends Sports {
    public void playCricket() {

        System.out.println("You are starting cricket right now! ");
    }
    @Override
    public void start() { 
       System.out.println("You are starting cricket 1 right now! ");
    }
}  

class Football extends Sports {
    public void playFootball() {
        System.out.println("You are starting football right now! ");
    } 
    @Override
    public void start() {
       System.out.println("You are starting football 1 right now! ");
    }
}


public class Main1 {
    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        Football football = new Football();
        football.start();
        cricket.start();
    }
}