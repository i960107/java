package chapter03;

public class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public static void main(String[] args) {
        System.out.println("calculator class started");
        Calculator calc = new Calculator();
        int a = 5;
        int b = 10;
        System.out.println(calc.add(a, b));
        System.out.println(calc.subtract(a, b));
        System.out.println(calc.divide(a, b));
        System.out.println(calc.multiply(a, b));
    }
}
