// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Klasa;
import pl.uj.p2.Rasa;

public class WypasionySrebrnyLuk extends Luk implements Srebrny {

    public WypasionySrebrnyLuk() { }

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
        if ((munchkin.pobierzRasa() == Rasa.Elf || munchkin.pobierzRasa() == Rasa.Gnom)
                && (munchkin.pobierzKlasa() != Klasa.Len && munchkin.pobierzKlasa() != Klasa.Osilek))
            return true;
        return false;
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzRasa() != null)
            return super.policzPremie(munchkin) * munchkin.pobierzRasa().pobierzPremie();
        return super.policzPremie(munchkin);
    }

}
