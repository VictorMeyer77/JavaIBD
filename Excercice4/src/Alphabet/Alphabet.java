package Alphabet;
import java.io.Console;
import java.util.Scanner;

public class Alphabet {

    public static void getVeocity(String alphabet, String word){

        int comptUnvalidLetter = 0;
        int indPresence = 0;

        try {
            for (int i = 0; i < word.length(); i += 1) {

                indPresence = 0;

                for (int j = 0; j < alphabet.length(); j += 1) {

                    if (word.charAt(i) == alphabet.charAt(j)) {
                        indPresence = 1;
                    }

                }

                if (indPresence == 0) {
                    comptUnvalidLetter += 1;
                }

            }

            if (comptUnvalidLetter > 0) {
                System.out.println("A character of the word is not present in the alphabet");
            } else {
                System.out.println("Valid word");
            }
        }catch (Exception e) {

            System.out.println("Error during validiation f the word");

        }

    }

    public static String permutate(int lengthRotation, String word, String direction){

        String newWord = "";
        try {
            if (lengthRotation > word.length()) {
                System.out.println("Number of rotation superior of word length");
                return null;
            }

            if (direction.toLowerCase().equals("g") == false && direction.toLowerCase().equals("d") == false) {
                System.out.println("Invalid direction, \"G\" et \"D\" autorized ");
                return null;
            }

            if (direction.toLowerCase().equals("g")) {

                for (int i = word.length() - lengthRotation; i < word.length(); i += 1) {

                    newWord.concat(Character.toString(word.charAt(i)));

                }
                for (int i = 0; i < word.length() - lengthRotation; i += 1) {

                    newWord.concat(Character.toString(word.charAt(i)));

                }

                return newWord;

            }

        } catch (Exception e) {

            System.out.println("Error during the permutation");

        }

        return newWord;

    }

    public static boolean isAnagram(String word){

        String anagram = "";
        Scanner scan = new Scanner(System.in);
        boolean compar = false;
        StringBuffer anagramBuff;
        StringBuffer wordBuff = new StringBuffer(word);
        int i = 0;
        int j = 0;

        try{

            System.out.println("Veuillez rentrer une chaine pour vérifier si elle est anagramme du précédent mot");
            anagram = scan.nextLine();
            anagramBuff = new StringBuffer(anagram);

            while(i < anagramBuff.length()){

                j = 0;
                while(j < wordBuff.length()){

                    if(wordBuff.charAt(i) == anagramBuff.charAt(j)){

                        wordBuff.deleteCharAt(j);
                        anagramBuff.deleteCharAt(i);
                        j -= 1;
                        i -= 1;
                        break;

                    }

                    j += 1;

                }

                i += 1;

            }
            System.out.println(wordBuff + " " + anagramBuff);
            if(anagramBuff.length() == 0)
                compar = true;

        } catch (Exception e){

            System.out.println("Error anagram Test");

        }

        return  compar;

    }

    public static String deletePart(String word){

        StringBuffer wordBuff = new StringBuffer(word);
        Scanner scan = new Scanner(System.in);
        String partWord = "";
        String cleanWord = "Aucune correspondance";
        int i = 0;

        try {

            System.out.println("Rentrez la chaine à chercher dans le mot");
            partWord = scan.nextLine();

            while(i < word.length()){

                if(i + partWord.length() < wordBuff.length() && partWord.equals((word.subSequence(i, i + partWord.length()).toString()))){

                    wordBuff.delete(i, i + partWord.length());
                    cleanWord = wordBuff.toString();
                    break;
                }
                i += 1;

            }

        } catch (Exception e) {

            System.out.println("Error during the serach of a part in word");

        }

        return cleanWord;
    }

    public static void main(String[] args){

        String alphabet = "";
        String word = "";

        while(alphabet.length() == 0) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Veuillez rentrer un alphabet");

            try {
                alphabet = scan.nextLine();
            } catch (Exception alphabetError) {
                System.out.println("Erreur de saisi de l'alphabet");
            }
        }

        while(word.length() == 0) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Veuillez rentrer un mot");

            try {
                word = scan.nextLine();
            } catch (Exception alphabetError) {
                System.out.println("Erreur de saisi du mot");
            }
        }

        getVeocity(alphabet, word);

        String permutWord = permutate(3, word, "g");
        System.out.println(permutWord);

        if (isAnagram(word)) {
            System.out.println("Anagramme !");
        } else {
            System.out.println("Not anagramme");
        }

       System.out.println(deletePart(word));

    }

}
