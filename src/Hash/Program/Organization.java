package Hash.Program;

import java.util.Comparator;

/**
 * Created by 131111 on 1/19/2018.
 */
public class Organization implements Comparable {
    private String name;
    private int students;

    public Organization(String name, int students){
        this.name = name;
        this.students = students;
    }


    @Override
    public int compareTo(Object o) {
        Organization org = (Organization)o;
        if(this.students > org.getStudents()){
            return -1;
        }if(this.students == org.getStudents() && this.getName().compareTo(org.getName()) < 0){
            return -1;
        }
        return 1;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public int getStudents(){
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name+" "+students;
    }
}
