package chapter08;

public class ReferencePass {
    public void callPassByValue() {
        int a = 10;
        String b = "b";

        System.out.println("before pass by value");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        passByValue(a, b);

        System.out.println("after pass by value");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void passByValue(int a, String b) {
        a = 20;
        b = "z";
        System.out.println("in passbyValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void callPassByReference() {
        MemberDto member = new MemberDto("sangmin");

        System.out.println("before pass by reference");
        System.out.println("member name= " + member.name);

        passByReference(member);

        System.out.println("after pass by reference");
        System.out.println("member name= " + member.name);
    }

    public void passByReference(MemberDto member) {
        System.out.println("in passbyReference");
        member.name = "soohyun";
        System.out.println("member name= " + member.name);
    }

    public static void main(String[] args) {
        ReferencePass rp = new ReferencePass();
        rp.callPassByValue();
        rp.callPassByReference();

    }

    class MemberDto {
        public String name;

        public MemberDto(String name) {
            this.name = name;
        }
    }
}
