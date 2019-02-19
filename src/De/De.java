package De;

import java.util.Objects;
import java.util.Random;

public class De {

    private int valeur;

    public De(){

    }

    public int getValeur() {
        return valeur;
    }

    public void lanceDe(){

        Random rand = new Random();
        this.valeur = rand.nextInt(6) + 1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof De)) return false;
        De de = (De) o;
        return getValeur() == de.getValeur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValeur());
    }

    @Override
    public String toString() {
        return "De{" +
                "valeur=" + valeur +
                '}';
    }


}
