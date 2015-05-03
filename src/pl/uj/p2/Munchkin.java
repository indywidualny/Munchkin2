// Krzysztof Grabowski

package pl.uj.p2;


import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.wyjatki.NiedozwolonaKlasa;
import pl.uj.p2.wyjatki.NiedozwoloneUzbrojenie;

public class Munchkin implements InterfejsMunchkina {

    private Bron bron;
    private Klasa klasa;
    private int poziom;
    private Rasa rasa;

    public Munchkin() {
        this.poziom = 1;
        this.klasa = null;
        this.rasa = null;
        this.bron = null;
    }

    public Munchkin(int poziom) {
        if (poziom < 0)
            this.poziom = 0;
        else
            this.poziom = poziom;

        this.klasa = null;
        this.rasa = null;
        this.bron = null;
    }

    public Bron pobierzBron() {
        return this.bron;
    }

    public Klasa pobierzKlasa() {
        return this.klasa;
    }

    public Rasa pobierzRasa() {
        return this.rasa;
    }

    public int pobierzSamPoziom() {
        return this.poziom;
    }

    public int policzCalkowityPoziom() {
        int calkowityPoziom = 0;
        // TODO: Metoda oblicza poziom Munchkina uwzględniając jego atrybuty.
        return calkowityPoziom;
    }

    public void przyjmijBron(Bron bron) {
        // TODO: Metoda ustawia bron Munchkina (nadpisuje wcześniej posiadaną)
        // - ale tylko wtedy, gdy klasa i rasa pozwalają nam używać broni.
    }

    public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
        // TODO: Metoda ustawia rasę Munchkina (nadpisuje wcześniej posiadaną)
        // - ale tylko wtedy, gdy klasa Munchkina nie wyklucza nowej rasy.
    }

    public void przyjmijRase(Rasa rasa) {
        // TODO: Metoda ustawia rasę Munchkina (nadpisuje wcześniej posiadaną)
        // - ale tylko wtedy, gdy klasa Munchkina nie wyklucza nowej rasy.
    }

    public void zmniejszSamPoziom(int delta) {
        // TODO: Metoda służy do zmniejszania wartości pola poziom.
    }

    public void zwiekszSamPoziom(int delta) {
        // TODO: Metoda służy do zwiększania wartości pola poziom.
    }

}
