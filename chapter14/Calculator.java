package chapter14;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.printDivide(1, 2);
            calculator.printDivide(1, 0); // Infinite 발생.
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void printDivide(double d1, double d2) throws RuntimeException {

        if (d2 == 0) {
            throw new RuntimeException("Second value can't be Zero");
        }
        double result = d1 / d2;
        System.out.println(result);
    }
}
