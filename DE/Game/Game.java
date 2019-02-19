package Game;

import De.De;
import InvalidMiseError.InvalidMiseError;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    public String gamerName;
    private int gamerAccount;
    public De de;

    public Game(String gamerName){

        setGamerName(gamerName);
        this.gamerAccount = 500;
        de = new De();
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public int getGamerAccount() {
        return gamerAccount;
    }

    public void lancerSession(int nbLancer, int miseParLancer) throws InvalidMiseError {

        int resOne;
        int resTwo;

        try{
            if(nbLancer * miseParLancer > this.gamerAccount){
               throw new InvalidMiseError();
            }

            for(int i = 0; i < nbLancer; i += 1){
                de.lanceDe();
                resOne = de.getValeur();
                de.lanceDe();
                resTwo = de.getValeur();

                if(resOne > resTwo){
                    this.gamerAccount += miseParLancer;
                    System.out.println("Gagné ! Votre lancer : " + resOne + ", lancer du croupier " + resTwo + ". Solde : " + getGamerAccount());
                }
                else if(resOne == resTwo){
                    System.out.println("Null ! Votre lancer : " + resOne + ", lancer du croupier " + resTwo + ". Solde : " + getGamerAccount());
                }
                else{
                    this.gamerAccount -= miseParLancer;
                    System.out.println("Perdu ! Votre lancer : " + resOne + ", lancer du croupier " + resTwo + ". Solde : " + getGamerAccount());
                }
            }
        }catch (InvalidMiseError e){
            System.out.println("Invalid session");
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return getGamerAccount() == game.getGamerAccount() &&
                getGamerName().equals(game.getGamerName()) &&
                de.equals(game.de);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGamerName(), getGamerAccount(), de);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gamerName='" + gamerName + '\'' +
                ", gamerAccount=" + gamerAccount +
                ", de=" + de +
                '}';
    }
}
