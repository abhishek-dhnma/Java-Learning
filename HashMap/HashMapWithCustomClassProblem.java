package HashMap;

import java.util.HashMap;

public class HashMapWithCustomClassProblem {

    public static void main(String[] args) {

        HashMap<Student, String> studentHashMap = new HashMap<>();

        Student s1 = new Student("Neha", 101, "Designer");
        Student s2 = new Student("Rahul", 322, "Engineer");
        Student s3 = new Student("Sunil", 782, "HR");
        Student s4 = new Student("Neha", 101, "Designer" );

        studentHashMap.put( s1, "Working");
        studentHashMap.put( s2,"OOO");
        studentHashMap.put( s3, "Working");
        studentHashMap.put( s4, "Leave");

        //System.out.println(studentHashMap);
        System.out.println(studentHashMap.size());
        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));

        System.out.println("Size should be 3 not 4 and Neha status should change from working to leave beacuse here we are using new keyword and " +
                "so it will create a new memory and hashcode will generate different So here they are two different students not one." +
                "how to overcome this???????");



    }
}

class Student {

    private int id;
    private String name;
    private String job;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(String name, int id, String job){
        this.name = name;
        this.id = id;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}