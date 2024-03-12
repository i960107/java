package chapter04;

public class PrimitiveTypes {
    public void checkByte() {
        byte byteMin = -128;
        byte byteMax = 127;
        System.out.println("byteMin = " + byteMin);
        System.out.println("byteMax = " + byteMax);

        byteMin = (byte) (byteMin - 1);
        byteMax = (byte) (byteMax + 1);
        System.out.println("byteMin = " + byteMin);
        System.out.println("byteMax = " + byteMax);
    }

    public void checkOtherTypes() {
        short shortMax = 32767;
        System.out.println("shortMax = " + shortMax);
        shortMax = (short) (shortMax + 1);
        System.out.println("shortMax = " + shortMax);

        int intMax = 2147483647;
        System.out.println("intMax = " + intMax);
//        intMax = (intMax + 1);
        System.out.println("intMax  + 1= " + (intMax + 1));

        long longMax = 9223372036854775807L;
        System.out.println("longMax = " + longMax);
        longMax = longMax + 1;
        System.out.println("longMax + 1= " + longMax);
    }

    public static void main(String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.checkByte();
        types.checkOtherTypes();
        System.out.println('\u0041');
    }
}
