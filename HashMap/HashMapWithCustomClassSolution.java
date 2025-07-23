package HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashMapWithCustomClassSolution {

    public static void main(String[] args) {

        HashMap<StudentSolution, String> studentHashMap = new HashMap<>();

        StudentSolution s1 = new StudentSolution("Neha", 101, "Designer");
        StudentSolution s2 = new StudentSolution("Rahul", 322, "Engineer");
        StudentSolution s3 = new StudentSolution("Sunil", 782, "HR");
        StudentSolution s4 = new StudentSolution("Neha", 101, "Designer" );

        studentHashMap.put( s1, "Working");
        studentHashMap.put( s2,"OOO");
        studentHashMap.put( s3, "Working");
        studentHashMap.put( s4, "Leave");

        //System.out.println(studentHashMap);
        System.out.println(studentHashMap.size());
        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));

        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));



    }
}

class StudentSolution {

    private int id;
    private String name;
    private String job;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StudentSolution(String name, int id, String job){
        this.name = name;
        this.id = id;
        this.job = job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }

        StudentSolution other = (StudentSolution) obj;

        return id == other.getId()
                && Objects.equals(name, other.name)
                && Objects.equals(job, other.job);


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