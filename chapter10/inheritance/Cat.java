package chapter10.inheritance;

public class Cat extends Animal {
    private boolean isSpayed;

    @Override
    public void move() {
        System.out.println("cat moves");
    }

    @Override
    public void eatFood() {
        System.out.println("cat eats food");
    }

    public void groom() {
        System.out.println("cat grooms");
    }
}
