package chapter04;

public class ProfilePrint {
    public byte age;
    public String name;
    public boolean isMarried;

    public void setAge(byte age){
        this.age=  age;
    }
    public byte getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setMarried(boolean isMarried){
        this.isMarried = isMarried;
    }

    public boolean isMarried(){
        return this.isMarried;
    }

    public static void main(String [] args){
        ProfilePrint profilePrint = new ProfilePrint();
        profilePrint.setAge((byte)20);
        profilePrint.setName("kim");
        profilePrint.setMarried(false);

        System.out.println("age = " + profilePrint.getAge());
        System.out.println("name = " + profilePrint.getName());
        System.out.println("isMarried = " + profilePrint.isMarried());

    }
}
