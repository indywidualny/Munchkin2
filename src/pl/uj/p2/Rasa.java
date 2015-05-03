// Krzysztof Grabowski

package pl.uj.p2;


public enum Rasa {

    Czlowiek(-4),
    Elf(3),
    Gnom(5),
    Krasnolud(2),
    Ork(1);

    private String[] nieakceptowalneRasy;
    private int	premiaDoPoziomu;

    Rasa(int p) {
        premiaDoPoziomu = p;
    }

    boolean	czyRasaAkceptowalna(Klasa klasa) {
        return false;
    }

    int	pobierzPremie() {
        return premiaDoPoziomu;
    }

}
