package chapter01;

public class Calculator {
    public int add(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    public int subtract(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    public int multiply(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    public int divide(int num1, int num2) {
        int result = num1 / num2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("calculator class started");
    }
}
