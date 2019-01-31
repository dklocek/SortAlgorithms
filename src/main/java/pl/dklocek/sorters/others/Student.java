package pl.dklocek.sorters.others;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student implements Comparable<Student>{
    @JsonProperty("name")
    protected  String name;
    @JsonProperty("surname")
    private String surname;

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("age")
    public void setAge(int age) {
        this.age = age;
    }

    @JsonProperty("id")
    private int id;
    @JsonProperty("age")
    private int age;

    public Student(String name, String surname, int id, int age) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
    }
    @JsonCreator
    public Student(@JsonProperty("name") String name,@JsonProperty("surname") String surname,
                   @JsonProperty("id")String id,@JsonProperty("age") String age) {
        this.name = name;
        this.surname = surname;
        this.id = Integer.parseInt(id);
        this.age = Integer.parseInt(age);
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }


    public int compareBy(Student student, String compareBy){

        switch (compareBy){
            case "name":
                if(this.name.compareToIgnoreCase(student.getName())>0)return 1;
                else if(this.name.compareToIgnoreCase(student.getName())<0)return -1;
                else if(this.name.compareToIgnoreCase(student.getName())==0 && this.name.compareTo(student.getName())>0)return 1;
                else if(this.name.compareToIgnoreCase(student.getName())==0 && this.name.compareTo(student.getName())<0)return -1;
                else {
                    if(this.surname.compareToIgnoreCase(student.getSurname())>0)return 1;
                    else if(this.surname.compareToIgnoreCase(student.getSurname())<0)return -1;
                    else if(this.surname.compareToIgnoreCase(student.getSurname())==0 && this.surname.compareTo(student.getSurname())>0)return 1;
                    else if(this.surname.compareToIgnoreCase(student.getSurname())==0 && this.surname.compareTo(student.getSurname())<0)return -1;
                    else return 0;
                }
            case "surname":
                if(this.surname.compareToIgnoreCase(student.getSurname())>0)return 1;
                else if(this.surname.compareToIgnoreCase(student.getSurname())<0)return -1;
                else if(this.surname.compareToIgnoreCase(student.getSurname())==0 && this.surname.compareTo(student.getSurname())>0)return 1;
                else if(this.surname.compareToIgnoreCase(student.getSurname())==0 && this.surname.compareTo(student.getSurname())<0)return -1;
                else {
                    if(this.name.compareToIgnoreCase(student.getName())>0)return 1;
                    else if(this.name.compareToIgnoreCase(student.getName())<0)return -1;
                    else if(this.name.compareToIgnoreCase(student.getName())==0 && this.name.compareTo(student.getName())>0)return 1;
                    else if(this.name.compareToIgnoreCase(student.getName())==0 && this.name.compareTo(student.getName())<0)return -1;
                    else return 0;
                }
            case "age":
                if(this.age>student.getAge())return 1;
                else if(this.age==student.getAge())return 0;
                else return -1;
            default:
                if(this.id>student.getId())return 1;
                else if(this.id==student.getId())return 0;
                else return -1;

        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return toString().compareTo(o.toString());
    }


}
