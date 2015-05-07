// Krzysztof Grabowski

package pl.uj.p2;


import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.wyjatki.NiedozwolonaKlasa;
import pl.uj.p2.wyjatki.NiedozwolonaRasa;
import pl.uj.p2.wyjatki.NiedozwoloneUzbrojenie;
import pl.uj.p2.wyjatki.WyjatekMunchkina;

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
        return this.poziom + klasa.pobierzPremie() + rasa.pobierzPremie();
    }

    public void przyjmijBron(Bron bron) throws NiedozwoloneUzbrojenie {
        if (bron.czyMoznaUzbroicMunchkina(this))
            this.bron = bron;
    }

    public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
        if (klasa.czyRasaAkceptowalna(this.rasa))
            this.klasa = klasa;
    }

    public void przyjmijRase(Rasa rasa) throws NiedozwolonaRasa, NiedozwoloneUzbrojenie {
        if (rasa.czyKlasaAkceptowalna(this.klasa))
            this.rasa = rasa;
    }

    public void zmniejszSamPoziom(int delta) {
        this.poziom = this.poziom - delta;
    }

    public void zwiekszSamPoziom(int delta) {
        this.poziom = this.poziom + delta;
    }

}
