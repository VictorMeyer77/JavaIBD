package Student;

import Mark.Mark;

import java.util.ArrayList;
import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int grade;
    private ArrayList<Mark> arrayNote;

    public Student(String firstName, String lastName, int grade){

        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        arrayNote = new ArrayList<Mark>();
    }

    public void addNote(Mark note){

        this.arrayNote.add(note);

    }

    public void deleteNote(String subject){

        for(int i = 0; i < this.arrayNote.size(); i += 1){

            if(subject.equals(this.arrayNote.get(i).getSubject())){

                this.arrayNote.remove(i);
                return;

            }

        }

    }

    public void modifyNote(String subject, Mark newNote){

        for(int i = 0; i < this.arrayNote.size(); i += 1){

            if(subject.equals(this.arrayNote.get(i).getSubject())){

                this.arrayNote.set(i, newNote);
                return;

            }

        }

    }

    public float getAverage(){

        float avg = 0;

        for(int i = 0; i < this.arrayNote.size(); i += 1){

            avg += this.arrayNote.get(i).getValue();

        }

        return avg / this.arrayNote.size();

    }

    public void readNote(){

        for(int i = 0; i < this.arrayNote.size(); i += 1){

            System.out.println("Student : " + this.getLastName() + ", subject : " + arrayNote.get(i).getSubject() + ", mark : " + arrayNote.get(i).getValue() );

        }

    }

    public int getComptSubject(){
        return this.arrayNote.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getGrade() == student.getGrade() &&
                getFirstName().equals(student.getFirstName()) &&
                getLastName().equals(student.getLastName()) &&
                Objects.equals(arrayNote, student.arrayNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGrade(), arrayNote);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", arrayNote=" + arrayNote +
                '}';
    }
}
