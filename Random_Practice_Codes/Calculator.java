public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum1 = calculator.add(5, 10);
        System.out.println("Sum of 5 and 10: " + sum1);
        double sum2 = calculator.add(3.5, 2.8);
        System.out.println("Sum of 3.5 and 2.8: " + sum2);
        int sum3 = calculator.add(1, 2, 3);
        System.out.println("Sum of 1, 2, and 3: " + sum3);
    }
}