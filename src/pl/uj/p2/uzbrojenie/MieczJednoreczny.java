// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;

public class MieczJednoreczny extends Miecz {

    public MieczJednoreczny() { }

    public int policzPremie(InterfejsMunchkina munchkin) {
        if (munchkin.pobierzRasa() != null)
            return super.policzPremie(munchkin) * munchkin.pobierzRasa().pobierzPremie();
        return super.policzPremie(munchkin);
    }

}
