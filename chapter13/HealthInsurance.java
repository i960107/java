package chapter13;

public enum HealthInsurance {
    LEVEL_ONE(1000, 1.0),
    LEVEL_TWO(2000, 2.0),
    LEVEL_THREE(3000, 3.2),
    LEVEL_FOUR(4000, 4.5),
    LEVEL_FIVE(5000, 5.6),
    LEVEL_SIX(6000, 7.1),
    UNDEFINED(Integer.MAX_VALUE, Double.MAX_VALUE);

    int maxSalary;
    double ratio;

    HealthInsurance(int maxSalary, double ratio) {
        this.maxSalary = maxSalary;
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public static HealthInsurance getHealthInsurance(int salary) {
//        for (HealthInsurance level : HealthInsurance.class.getEnumConstants()) {
        for (HealthInsurance level : HealthInsurance.values()) {
            if (salary <= level.maxSalary) {
                return level;
            }
        }
        return UNDEFINED;
    }

    public static void main(String[] args) {
        int count = 3;
        int salaryArray[] = {1500, 5500, 8000};
        HealthInsurance[] insurances = new HealthInsurance[3];
        for (int i = 0; i < count; i++) {
            insurances[i] = HealthInsurance.getHealthInsurance(salaryArray[i]);
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("%d = %s, %f\n", salaryArray[i], insurances[i], insurances[i].getRatio());
        }
    }
}
