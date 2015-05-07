// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Klasa;

public class Topor implements Bron {

    public Topor() { }

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzKlasa() == Klasa.Szpieg)
            return false;
        return true;
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzKlasa() == Klasa.Osilek)
            return 10;
        return 5;
    }

}
