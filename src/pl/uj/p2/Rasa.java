// Krzysztof Grabowski

package pl.uj.p2;


public enum Rasa {

    Czlowiek(4, ""),
    Elf(3, "Palladyn"),
    Gnom(5, "Osilek"),
    Krasnolud(2, "Szpieg"),
    Ork(1, "Szpieg", "Mag");

    private String[] nieakceptowalneKlasy;
    private int	premiaDoPoziomu;

    Rasa(int premiaDoPoziomu, String ... nieakceptowalneKlasy) {
        this.premiaDoPoziomu = premiaDoPoziomu;
        this.nieakceptowalneKlasy = nieakceptowalneKlasy;
    }

    public boolean czyKlasaAkceptowalna(Klasa klasa) {
        for (int i = 0; i < this.nieakceptowalneKlasy.length; i++)
            if (klasa != null && klasa.toString().equals(this.nieakceptowalneKlasy[i]))
                return false;
        return true;
    }

    int	pobierzPremie() {
        return premiaDoPoziomu;
    }

}
