package this_is_java;

import java.util.Scanner;

public class Chapter04 {
    public static void main(String[] args) {
        Chapter04 chapter04 = new Chapter04();
        chapter04.exercise3();
        chapter04.exercise4();
        chapter04.exercise5();
        chapter04.exercise6();
        chapter04.exercise7();
    }

    public void exercise3() {
        int sum = 0;
        for (int i = 3; i <= 100; i += 3) {
            sum += i;
        }
        System.out.printf("3의 배수의 합: %d \n", sum);

    }

    public void exercise4() {
        while (true) {
            // Math.random() = 0 ~ 0.99
            int num1 = (int) (Math.random() * 6) + 1;
            int num2 = (int) (Math.random() * 6) + 1;
            System.out.printf("(%d, %d) \n", num1, num2);
            if (num1 + num2 == 5) {
                break;
            }
        }
        System.out.println();
    }

    public void exercise5() {
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    System.out.printf("(%d, %d)\n", x, y);
                }
            }
        }
    }

    public void exercise6() {
        for (int i = 1; i <= 5; i++) {
            for(int j = 1; j <=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void exercise7() {
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            System.out.println("---------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("---------------");
            System.out.print("선택> ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.print("예금액 > ");
                    int amount = Integer.valueOf(scanner.nextLine());
                    balance += amount;
                    break;
                }
                case "2": {
                    System.out.print("출금액 > ");
                    int amount = Integer.valueOf(scanner.nextLine());
                    balance -= amount;
                    break;
                }
                case "3": {
                    System.out.printf("잔고 : %d\n", balance);
                    break;
                }
                case "4": {
                    run = false;
                }
            }
        }
        System.out.println("프로그램 종료");
    }
}
