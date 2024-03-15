package chapter15;

public class StringSample {
    public static void main(String[] args) {
        String str = "The String class represents character strings";

        StringSample ss = new StringSample();
        ss.printWords(str);
        ss.findString(str, "string");
        ss.findAnyCaseString(str, "string");
        ss.countChar(str, 's');
        ss.printContainWords(str, "ss");
    }

    public void printWords(String str) {
        for (String s : str.split(" ")) {
            System.out.println(s);
        }
    }

    public void findString(String str, String findStr) {
        int index = str.indexOf(findStr);
        System.out.println("string is appeared at " + index);
    }

    public void findAnyCaseString(String str, String findStr) {
        int index = str.toLowerCase().indexOf(findStr.toLowerCase());
        System.out.println("string is appeared at " + index);
    }

    public void countChar(String str, char c) {
        int count = 0;
        for (char partC : str.toCharArray()) {
            if (partC == c) {
                count++;
            }
        }
        System.out.println("char 's' count is " + count);
    }

    public void printContainWords(String str, String findStr) {
        for (String s : str.split(" ")) {
            if (s.contains(findStr)) {
                System.out.println("String contains " + findStr);
            }
        }
    }
}
