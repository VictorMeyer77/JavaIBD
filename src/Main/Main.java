package Main;

import De.De;
import Game.Game;
import InvalidMiseError.InvalidMiseError;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws InvalidMiseError {

        Scanner scan = new Scanner(System.in);

        int miseParLancer = 0;
        int nbLancer = 0;
        String name = null;

        System.out.println("Rentrez votre nom");
        try {
            name = scan.nextLine();
        }
        catch (Exception e){
            System.out.println("Insérez votre prénom");
        }

        Game game = new Game(name);

        System.out.println("Bienvenue au casino " + game.getGamerName() + ". Vous disposez de : " + game.getGamerAccount());


        System.out.println("Quel mise par lancer");
        try {
            miseParLancer = scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Insérer un nombre positif");
        }

        System.out.println("Combien de lancer ?");
        try {
            nbLancer = scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Insérer un nombre positif");
        }

        game.lancerSession(nbLancer, miseParLancer);

    }
}
