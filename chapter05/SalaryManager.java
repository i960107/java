package chapter05;

public class SalaryManager {
    private static double TAX_RATE = 12.5;
    private static double HEALTH_INSURANCE_RATE = 13.5;
    private static double NATIONAL_PENSION_RATE = 8.1;

    public double getMonthlySalary(int yearlySalary) {
        double monthSalary = yearlySalary / 12.0;
        double tax = calculateTax(monthSalary);
        double pension = calculateNationalPension(monthSalary);
        double healthInsurance = calculateHealthInsurance(monthSalary);
        monthSalary -= (tax + pension + healthInsurance);
        return monthSalary;
    }

    public double calculateTax(double monthSalary) {
        double tax = monthSalary * TAX_RATE / 100;
        System.out.println(tax);
        return tax;
    }

    public double calculateNationalPension(double monthSalary) {
        double pension = monthSalary * NATIONAL_PENSION_RATE / 100;
        System.out.println(pension);
        return pension;
    }

    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * HEALTH_INSURANCE_RATE / 100;
        System.out.println(healthInsurance);
        return healthInsurance;
    }

    public static void main(String[] args) {
        SalaryManager sm = new SalaryManager();
        int yearlySalary = 20000000;
        double monthlySalary = sm.getMonthlySalary(yearlySalary);
        System.out.println("monthlySalary = " + monthlySalary);
    }

    public void test(int point) {
        if (point > 90) {
            System.out.println("A");
        }
        if (point <= 90 && point > 80) {
            System.out.println("B");
        }
        if (point <= 80 && point > 70) {
            System.out.println("C");
        }
        if (point <= 70) {
            System.out.println("D");
        }
    }
}
