// Krzysztof Grabowski

package pl.uj.p2.uzbrojenie;


import pl.uj.p2.InterfejsMunchkina;

public class MieczJednoreczny extends Miecz {

    public MieczJednoreczny() { }

    public int policzPremie(InterfejsMunchkina munchkin) {
        return 2 * munchkin.pobierzKlasa().pobierzPremie();
    }

}
