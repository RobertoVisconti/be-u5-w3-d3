package robertovisconti.be_u5_w3_d3.Composite;

import java.util.ArrayList;
import java.util.List;

public class Sezione implements ElementoLibro {

    private String nomeSezione;

    private List<ElementoLibro> sottoElementi = new ArrayList<>();

    public Sezione(String nomeSezione) {
        this.nomeSezione = nomeSezione;
    }

    public void aggiungi(ElementoLibro elementoLibro) {
        sottoElementi.add(elementoLibro);
    }


    @Override
    public void stampa() {
        System.out.println(nomeSezione);
        sottoElementi.forEach(ElementoLibro::stampa);
    }

    @Override
    public int getNumeroPagine() {
        return sottoElementi.stream()
                .mapToInt(ElementoLibro::getNumeroPagine)
                .sum();
    }
}
