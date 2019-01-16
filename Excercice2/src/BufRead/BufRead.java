package BufRead;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;



public class BufRead {

    private static String line;
    private static BufferedReader reader;
    private static ArrayList<Integer> listScore = new ArrayList<Integer>();

    BufRead() {

        try {

            reader = new BufferedReader(new FileReader("dataSet.txt"));
            reader.mark(10000);
            this.hydrateList();


        }catch (Exception e){

            System.out.println("Erreur lors de l'instanciation");
            System.exit(0);
        }

    }

    public void printList(){

        try {

            reader.reset();

            while((line = reader.readLine()) != null ){

                System.out.println(line);

            }
        }catch (Exception e1){

            System.out.println("PrintList error");

        }

    }

    private void hydrateList() {

        int score = 0;
        String scoreStr = "";

        try{

            while ((line = reader.readLine()) != null) {


                scoreStr = line.substring(line.indexOf(':') + 2);
                score = Integer.parseInt(scoreStr);
                listScore.add(score);

            }

        }catch (Exception ex){
            System.out.println("Error Hydrate List");
        }

    }

    public float getAvg(){

        int sum = 0;
        float avg = 0;

        try{

            for(int i = 0; i < listScore.size(); i += 1 ){
                sum += listScore.get(i);
            }

            avg = sum / listScore.size();

        }catch (Exception ce){
            System.out.println("Error Getavg");
        }

        return avg;
    }

    public static int getScore(){

        int score = 0;
        String mail = "";
        String mailComp = "";

        while(mail.length() == 0) {


            Scanner adresse = new Scanner(System.in);
            System.out.println("Saisissez un mail");

            try {
                mail = adresse.nextLine();
            } catch (Exception e) {

                System.out.println("Veuillez rentrez une chaine de charactere");
            }

        }

        int ind = 0;
        try {
            reader.reset();
            while((line = reader.readLine()) != null ){

                mailComp = line.substring(0, line.indexOf(':') - 1);
                if(mailComp.equals(mail)){
                    score = listScore.get(ind);
                    break;
                }
                ind += 1;
            }

        }catch (Exception ex){
            System.out.println("Recherche d'adresse impossible");
        }

        return score;
    }

    public static void main(String[] args){
        Instant start = Instant.now();
        BufRead bfOne = new BufRead();
        bfOne.printList();
        System.out.println(bfOne.getAvg());
        System.out.println(bfOne.getScore());
        Duration duration = Duration.between(start, Instant.now());
        System.out.println(duration);

    }

}

