package chapter08;

public class Student {
    public String name;
    public String address;
    public String phone;
    public String email;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " + address + " " + phone + " " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }

        Student other = (Student) o;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) { //other.name == null인 경우도 포함.
            return false;
        }
        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) { //other.name == null인 경우도 포함.
            return false;
        }
        if (phone == null) {
            if (other.phone != null) return false;
        } else if (!phone.equals(other.phone)) { //other.name == null인 경우도 포함.
            return false;
        }
        return true;
    }
}
