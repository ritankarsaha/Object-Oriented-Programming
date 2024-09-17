public class ObjectsAndClasses2 {

    
    public static void main(String args[]){
        Cricket cricket = new Cricket();
    Football football = new Football();
    cricket.start();
    cricket.playCricket();
    football.start();
    football.playFootball();
    }
    
}


class Sports{
    public void start(){
        System.out.println("The sport is starting. ");
    }
}


class Cricket extends Sports{
    public void playCricket(){
        System.out.println("I have started playing cricket!");
    }

    @Override
    public void start(){
        System.out.println("The cricket match is starting. ");
    }
}

class Football extends Sports{
    public void playFootball(){
        System.out.println("I have started playing football!");
    }

    @Override
    public void start(){
        System.out.println("The football match is starting. ");
    }
}