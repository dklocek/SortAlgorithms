package pl.dklocek.sorters.others;

public class Student implements Comparable<Student>{

    protected  String name;
    private String surname;
    private int id;
    private int age;

    public Student(String name, String surname, int id, int age) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
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

    public int compareByName(Student student){
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
    }

    public int compareBySurname(Student student){
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
    }

    public int compareById(Student student){

         if(this.id>student.getId())return 1;
         else if(this.id==student.getId())return 0;
         else return -1;
    }

    public int compareByAge(Student student){

        if(this.age>student.getAge())return 1;
        else if(this.age==student.getAge())return 0;
        else return -1;
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
