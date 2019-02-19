package Application;

import Mark.Mark;
import Student.Student;

import java.util.ArrayList;
import java.util.Objects;

public class Application {

    private ArrayList<Student> arrayStudent;

    public Application(){

        this.arrayStudent = new ArrayList<Student>();

    }

    public void addStudent(Student student){

        this.arrayStudent.add(student);

    }

    public void deleteStudent(String firstName, String lastName){

        for(int i = 0; i < this.arrayStudent.size(); i += 1){

            if(this.arrayStudent.get(i).getFirstName().equals(firstName) && this.arrayStudent.get(i).getLastName().equals(lastName)){

                this.arrayStudent.remove(i);

            }

        }

    }

    public void printAllNote(){

        for(int i = 0; i < this.arrayStudent.size(); i += 1){

            this.arrayStudent.get(i).readNote();

        }

    }

    public void getAverage(int position){

        System.out.println(this.arrayStudent.get(position).getAverage());

    }

    public void addNote(int position, float note, String subject){

        Mark mark = new Mark(note, subject);
        this.arrayStudent.get(position).addNote(mark);


    }

    public int maxSubjectEval(){

        int max = this.arrayStudent.get(0).getComptSubject();

        for(int i = 1; i < this.arrayStudent.size(); i += 1){

            if(max < this.arrayStudent.get(i).getComptSubject()){

                max = this.arrayStudent.get(i).getComptSubject();

            }
        }

        return max;
    }

    public float[] getTabAvg(){

        float[] arrayAvg = new float[this.arrayStudent.size()] ;
        float temp;

        for(int i = 0; i < this.arrayStudent.size(); i += 1) {

            arrayAvg[i] = this.arrayStudent.get(i).getAverage();
        }

        for(int i = 0; i < arrayAvg.length; i += 1) {

            for(int j = i + 1; j < arrayAvg.length; j += 1 ){

                if(arrayAvg[j] < arrayAvg[i]){
                    temp = arrayAvg[j];
                    arrayAvg[j] = arrayAvg[i];
                    arrayAvg[i] = temp;
                }

            }
        }

        return arrayAvg;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;
        Application that = (Application) o;
        return Objects.equals(arrayStudent, that.arrayStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayStudent);
    }

    @Override
    public String toString() {
        return "Application{" +
                "arrayStudent=" + arrayStudent +
                '}';
    }
}

