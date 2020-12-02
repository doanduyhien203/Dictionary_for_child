package edmt.dev.androidgridlayout.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {     // Serializable dung de ghi va doc theo Object

    private static final long serialVersionUID = 1L;    // ID of Serializable
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // cac ham get, set gia tri cac bien
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + '}';
    }
    public static List<Student> wtiteS(){
        List<Student > list = new ArrayList<>();
        list.add(new Student("tuyen", 9));
        list.add(new Student("tuyen", 10));
        list.add(new Student("tuyen", 11));
        list.add(new Student("tuyen", 11));
        list.add(new Student("tuyen", 11));
        list.add(new Student("tuyen", 11));
        return list;
    }
}

