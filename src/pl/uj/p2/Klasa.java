// Krzysztof Grabowski

package pl.uj.p2;


public enum Klasa {

    Len(-1),
    Mag(4),
    Osilek(5),
    Palladyn(2),
    Szpieg(2);

    private String[] nieakceptowalneRasy;
    private int	premiaDoPoziomu;

    Klasa(int p) {
        this.premiaDoPoziomu = p;
    }

    public boolean czyRasaAkceptowalna(Rasa rasa) {
        return false;
    }

    public int pobierzPremie() {
        return this.premiaDoPoziomu;
    }


/*    // TODO: No way to override it so leave it default
    public static Klasa valueOf(String name) {
        if (name.equals("Len"))
            return Len;
        else if (name.equals("Mag"))
            return Mag;
        else if (name.equals("Osilek"))
            return Osilek;
        else if (name.equals("Palladyn"))
            return Palladyn;
        else if (name.equals("Szpieg"))
            return Szpieg;
        else return null;

    }

    public static Klasa[] values() {
        return null;
    }*/

}
