package review;

public class CalculateSalary {
    public static void main(String[] args) {
        CalculateSalary cs = new CalculateSalary();
        cs.calculateSalaries();
    }

    public long getSalaryIncrease(Employee employee) {
        double ratio;
        switch (employee.getType()) {
            case 1: {
                ratio = -0.95;
                break;
            }
            case 2: {
                ratio = 0.1;
                break;
            }
            case 3: {
                ratio = 0.2;
                break;
            }
            case 4: {
                ratio = 0.3;
                break;
            }
            case 5: {
                ratio = 1.0;
                break;
            }
            default: {
                ratio = 0.0;
            }

        }
        return (long) (employee.getSalary() * (1 + ratio));
    }

    public void calculateSalaries() {
        Employee[] employees = {
                new Employee("LeeDaeRi", 1, 1000000000),
                new Employee("KimManager", 2, 100000000),
                new Employee("WhanDesign", 3, 70000000),
                new Employee("ParkArchi", 4, 80000000),
                new Employee("LeeDevelop", 5, 60000000),
        };

        for (Employee employee : employees) {
            long increasedSalary = getSalaryIncrease(employee);
            System.out.println(employee.getName() + " = " + increasedSalary);

        }
    }
}
