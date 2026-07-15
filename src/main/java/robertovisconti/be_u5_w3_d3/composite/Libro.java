package robertovisconti.be_u5_w3_d3.composite;

import java.util.List;

public class Libro {

    private String titolo;
    private List<String> autori;
    private double prezzo;
    private ElementoLibro contenuto;

    public Libro(String titolo, List<String> autori, double prezzo, ElementoLibro contenuto) {
        this.titolo = titolo;
        this.autori = autori;
        this.prezzo = prezzo;
        this.contenuto = contenuto;
    }

    public void stampaLibro() {
        System.out.println("LIBRO: " + titolo);
        System.out.println("AUTORI: " + String.join(", ", autori));
        System.out.println("PREZZO: " + prezzo + "€");

        contenuto.stampa();
    }

    public int numeroTotPagine() {
        return contenuto.getNumeroPagine();
    }
}
