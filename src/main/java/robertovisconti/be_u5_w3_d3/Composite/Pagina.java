package robertovisconti.be_u5_w3_d3.Composite;

public class Pagina implements ElementoLibro {

    private int numeroPagina;

    public Pagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    @Override
    public void stampa() {
        System.out.println("Pagina " + numeroPagina);
        System.out.println("Contenuto della pagina " + numeroPagina);
    }

    @Override
    public int getNumeroPagine() {
        return 1;
    }
}
