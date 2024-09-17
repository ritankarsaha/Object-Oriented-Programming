public class thisusing {

    public static void main(String args[]){
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("The area of the circle is "+circle.area());
        System.out.println("The area of the rectangle is "+rectangle.area());
    }
    
}

class Shape{
    public double area(){
        return 0.0;
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double width,height;
    public Rectangle(double width, double height){
        this.height = height;
        this.width=width;

    }
    @Override
    public double area(){
        return width * height;
    }
}