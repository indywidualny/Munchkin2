// Krzysztof Grabowski

package pl.uj.p2;


import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.uzbrojenie.Srebrny;
import pl.uj.p2.uzbrojenie.Stalowy;
import pl.uj.p2.wyjatki.NiedozwolonaKlasa;
import pl.uj.p2.wyjatki.NiedozwolonaRasa;
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
        int premiaRasy = 0;
        if (this.rasa != null)
            premiaRasy = rasa.pobierzPremie();

        int premiaKlasy = 0;
        if (this.klasa != null)
            premiaKlasy = klasa.pobierzPremie();

        int premiaUzbrojenia = 0;
        if (this.bron != null)
            premiaUzbrojenia = this.pobierzBron().policzPremie(this);

        int extra = 0;
        if (this.rasa == rasa.Ork && this.bron instanceof Stalowy)
            extra = 20;
        else if (this.klasa == klasa.Palladyn && this.bron instanceof Srebrny)
            extra = 25;

        return this.poziom + premiaRasy + premiaKlasy + premiaUzbrojenia + extra;
    }

    public void przyjmijBron(Bron bron) throws NiedozwoloneUzbrojenie {
        if (bron.czyMoznaUzbroicMunchkina(this))
            this.bron = bron;
        else
            throw new NiedozwoloneUzbrojenie("Niedozwolone uzbrojenie");
    }

    public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
        if (klasa.czyRasaAkceptowalna(this.rasa))
            this.klasa = klasa;
        else
            throw new NiedozwolonaKlasa("Niedozwolona klasa");
    }

    public void przyjmijRase(Rasa rasa) throws NiedozwolonaRasa, NiedozwoloneUzbrojenie {
        if (rasa.czyKlasaAkceptowalna(this.klasa))
            this.rasa = rasa;
        else
            throw new NiedozwolonaRasa("Niedozwolona rasa");
    }

    public void zmniejszSamPoziom(int delta) {
        this.poziom = this.poziom - delta;
    }

    public void zwiekszSamPoziom(int delta) {
        this.poziom = this.poziom + delta;
    }

}
