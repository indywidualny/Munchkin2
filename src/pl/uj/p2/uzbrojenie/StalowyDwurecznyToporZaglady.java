// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Klasa;
import pl.uj.p2.Rasa;

public class StalowyDwurecznyToporZaglady extends Topor implements Stalowy {

    public StalowyDwurecznyToporZaglady() { }

    public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzRasa() == Rasa.Ork || munchkin.pobierzKlasa() == Klasa.Osilek)
            return true;
        return false;
    }

    public int policzPremie(InterfejsMunchkina munchkin) {
        return super.policzPremie(munchkin) * munchkin.pobierzSamPoziom();
    }

}
