package chapter10.inheritance;

public class Dog extends Animal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = (Dog) animal;
//        Dog dog = (Dog) new Animal();
        System.out.println(dog);
    }
//    private String name;
//    private boolean isSpayed;
//
//    public void bark() {
//        System.out.println("dog barks");
//    }
//
//    @Override
//    public void move() {
//        System.out.println("dog moves");
//    }
//
//    @Override
//    public void eatFood() {
//        System.out.println("dog eat food");
//    }
}
