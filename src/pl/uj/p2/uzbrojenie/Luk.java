// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Rasa;

public class Luk implements Bron {

    public Luk() { }

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzRasa() == Rasa.Elf || munchkin.pobierzRasa() == Rasa.Gnom)
            return true;
        return false;
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        return 3;
    }

}
