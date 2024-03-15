package chapter20;

public class NumberObjects {
    public static void main(String[] args) {
        NumberObjects numberObjects = new NumberObjects();
        numberObjects.parseLong("1");
        numberObjects.parseLong("r1024");
        numberObjects.printOtherBase(102);
    }

    public long parseLong(String data) {
        long result;
        try {
            result = Long.parseLong(data);
        } catch (NumberFormatException exception) {
            result = -1;
            System.out.println(data + "is not a number.");
        }
        return result;
    }

    public void printOtherBase(long value){
        System.out.println("Original: " + value);
        System.out.println("Binary: " + Long.toBinaryString(value));
        System.out.println("Hex: " + Long.toHexString(value));
        System.out.println("Octal: " + Long.toOctalString(value));
    }

}
