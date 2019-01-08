package TabEntier;

public class TabEntier {


    public static float avg(String[] tabNb){

        float avg = 0;
        float sum = 0;
        int comptOcc = 0;

        for(int i = 0; i < tabNb.length; i += 1){

            try{
                sum += Integer.parseInt(tabNb[i]);
                comptOcc += 1;
            }catch(Exception ConvertExcept){

                messageErrorConversion(i);

            }

        }

        avg = sum / comptOcc;

        return avg;
    }

    public static void messageErrorConversion(int indice){
        System.out.println("Erreur de conversion ligne : " + indice );
    }


    public static void main(String[] args){

        String[] tabNb = {"134", "768", "897", "patate", "896"};

        System.out.println(avg(tabNb));

    }


}
