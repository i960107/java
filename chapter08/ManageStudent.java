package chapter08;

public class ManageStudent {
    public Student[] addStudent(Student[] students) {
        students = new Student[3];
        students[0] = new Student("lim");
        students[1] = new Student("kim");
        students[2] = new Student("sook", "seoul", "010xxxxxx", "ask@godofjava.com");
        return students;
    }

    public void printStudent(Student student) {
        System.out.println(student);
    }

    public static void main(String[] args) {
        ManageStudent ms = new ManageStudent();

//        Student[] students = null;
//        students = ms.addStudent(students);
//
//        for (Student student : students) {
//            ms.printStudent(student);
//        }

        ms.checkEquals();

    }

    public void checkEquals() {
        Student a = new Student("Min", "Seoul", "010XXXXXXX", "ask@godofjava.com");
        Student b = new Student("Min", "Seoul", "010XXXXXXX", "ask@godofjava.com");

        if (a.equals(b)) {
            System.out.println("equal");
        } else {
            System.out.println("not euqal");
        }
    }
}
