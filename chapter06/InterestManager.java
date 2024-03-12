package chapter06;

public class InterestManager {
    public double getInterestRate(int day) {
        double rate;
        if (day <= 90) {
            rate = 0.005;
        } else if (day <= 180) {
            rate = 0.01;
        } else if (day <= 364) {
            rate = 0.02;
        } else {
            rate = 0.056;
        }
        return rate;
    }

    public double calculateInterest(int day, long amount) {
        return amount + amount * getInterestRate(day);
    }

    public static void main(String[] args) {
        InterestManager interestManager = new InterestManager();
        double amount = 1000000;
        for (int day = 1; day < 366; day = day + 10) {
            double interest = amount * interestManager.getInterestRate(day);
            System.out.println("interest = " + interest);
            amount += interest;
        }

    }
}
