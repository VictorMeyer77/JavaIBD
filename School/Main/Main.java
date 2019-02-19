package Main;

import Application.Application;
import Student.Student;
import Mark.Mark;

public class Main {


    public static void main(String args[]) {

        Student eleveOne = new Student("Jean", "Dulam", 2);
        Student eleveTwo = new Student("Laurent", "Lowitztch", 1);
        Student eleveThree = new Student("Fanny", "Laurier", 4);
        Student eleveFour = new Student("Dominique", "Kanstrauss", 5);

        Application application = new Application();

        application.addStudent(eleveOne);
        application.addStudent(eleveTwo);
        application.addStudent(eleveThree);
        application.addStudent(eleveFour);

        //ajout de notes
        application.addNote(0, 17, "Francais");
        application.addNote(0, 13.5f, "Maths");
        application.addNote(0, 14.5f, "EPS");
        application.addNote(1, 14, "Francais");
        application.addNote(1, 17, "Maths");
        application.addNote(1, 18.1f, "Anglais");
        application.addNote(1, 8.5f, "Physique");
        application.addNote(2, 10, "Espagnol");
        application.addNote(3, 15.1f, "SVT");
        application.addNote(3, 17.75f, "Maths");
        application.addNote(3, 6.75f, "Technologie");

        // affichage tableau
        System.out.println(" /n Tableau des notes :");
        application.printAllNote();

        //calcul moyenne etudiant
        System.out.println(" /n Moyenne du deuxième étudiant :");
        application.getAverage(1);


        //plus de matieres évalués
        System.out.println(" /n Plus de matière évalué : " + application.maxSubjectEval());

        //tableau des moyennes
        float arrayAvg[] = application.getTabAvg();

        for(int i = 0; i < arrayAvg.length ; i += 1 ){


            System.out.println(arrayAvg[i]);

        }


    }
}
