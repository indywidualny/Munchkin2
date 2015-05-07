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
        if (bron == null)
            this.bron = null;
        else if (bron.czyMoznaUzbroicMunchkina(this))
            this.bron = bron;
        else {
            this.bron = null;
            throw new NiedozwoloneUzbrojenie("Niedozwolone bron");
        }
    }

    public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
        if (klasa == null) {
            this.klasa = null;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else if (this.rasa == null) {
            this.klasa = klasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else if (this.rasa.czyKlasaAkceptowalna(klasa)) {
            this.klasa = klasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else
            throw new NiedozwolonaKlasa("Niedozwolona klasa");
    }

    public void przyjmijRase(Rasa rasa) throws NiedozwolonaRasa, NiedozwoloneUzbrojenie {
        if (rasa == null) {
            this.rasa = null;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else if (this.klasa == null ) {
            this.rasa = rasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else if (this.klasa.czyRasaAkceptowalna(rasa)) {
            this.rasa = rasa;
            if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this)) {
                this.bron = null;
                throw new NiedozwoloneUzbrojenie("Niedozwolona bron");
            }
        } else
            throw new NiedozwolonaRasa("Niedozwolona rasa");
    }

    public void zmniejszSamPoziom(int delta) {
        if (this.poziom - delta < 0)
            this.poziom = 0;
        else
            this.poziom = this.poziom - delta;
    }

    public void zwiekszSamPoziom(int delta) {
        if (this.poziom + delta < 0)  // w razie zwiekszania o ujemna
            this.poziom = 0;
        else
            this.poziom = this.poziom + delta;
    }

}
