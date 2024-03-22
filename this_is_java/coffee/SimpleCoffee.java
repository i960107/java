package this_is_java.coffee;

import this_is_java.coffee.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}
