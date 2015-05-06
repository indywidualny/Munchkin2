// Krzysztof Grabowski

package pl.uj.p2;


public enum Klasa {

    Len(-1, ""),
    Mag(4, "Ork", "Gnom"),
    Osilek(5, "Gnom"),
    Palladyn(2, "Elf"),
    Szpieg(2, "Ork", "Krasnolud");

    private String[] nieakceptowalneRasy;
    private int	premiaDoPoziomu;

    Klasa(int premiaDoPoziomu, String... nieakceptowalneRasy) {
        this.premiaDoPoziomu = premiaDoPoziomu;
        this.nieakceptowalneRasy = nieakceptowalneRasy;
    }

    public boolean czyRasaAkceptowalna(Rasa rasa) {
        for (int i = 0; i < this.nieakceptowalneRasy.length; i++)
            if (rasa != null && rasa.toString().equals(this.nieakceptowalneRasy[i]))
                return false;

        return true;
    }

    public int pobierzPremie() {
        return this.premiaDoPoziomu;
    }

}
