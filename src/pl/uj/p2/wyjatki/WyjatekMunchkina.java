// Krzysztof Grabowski

package pl.uj.p2.wyjatki;


public class WyjatekMunchkina extends java.lang.Exception {

    protected String message;

    public WyjatekMunchkina() { }

    public WyjatekMunchkina(java.lang.String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
