package robertovisconti.be_u5_w3_d3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import robertovisconti.be_u5_w3_d3.Composite.Libro;
import robertovisconti.be_u5_w3_d3.Composite.Pagina;
import robertovisconti.be_u5_w3_d3.Composite.Sezione;
import robertovisconti.be_u5_w3_d3.adapter.DataSource;
import robertovisconti.be_u5_w3_d3.adapter.Info;
import robertovisconti.be_u5_w3_d3.adapter.InfoAdapter;
import robertovisconti.be_u5_w3_d3.adapter.UserData;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class BeU5W3D3Application {

    public static void main(String[] args) {
        SpringApplication.run(BeU5W3D3Application.class, args);


        // ******************************** ADAPTER ********************************

        Info infoPersona = new Info();
        infoPersona.setNome("Jane");
        infoPersona.setCognome("Doe");

        Calendar cal = new GregorianCalendar(1993, Calendar.JULY, 7); // uso il calendar poichè Info accetta un oggetto di tipo Date
        infoPersona.DataDiNascita(cal.getTime());

        DataSource adapter = new InfoAdapter(infoPersona);

        UserData userData = new UserData();

        userData.getData(adapter);

        System.out.println(userData);


        // ******************************** COMPOSITE ********************************

        // PAGINA SINGOLA
        Pagina p1 = new Pagina(1);
        Pagina p2 = new Pagina(2);
        Pagina p3 = new Pagina(3);
        Pagina p4 = new Pagina(4);
        Pagina p5 = new Pagina(5);

        // SOTTO SEZIONE
        Sezione sottoSezione1 = new Sezione("Sottosezione 1");
        sottoSezione1.aggiungi(p2);
        sottoSezione1.aggiungi(p4);

        // SEZIONE PRINCIPALE
        Sezione sezionePrincipale = new Sezione("Capitolo 1");
        sezionePrincipale.aggiungi(p1);
        sezionePrincipale.aggiungi(sottoSezione1);
        sezionePrincipale.aggiungi(p5);

        // SEZIONE INDIPENDENTE
        Sezione appendice = new Sezione("Appendice R");
        appendice.aggiungi(p3);

        // SEZIONE COMPLETA
        Sezione sezioneCompleta = new Sezione("Indice Generale");
        sezioneCompleta.aggiungi(sezionePrincipale);
        sezioneCompleta.aggiungi(appendice);

        // LIBRO
        Libro libro = new Libro("Composite", Arrays.asList("Riccardo", "Gulin"), 49.99, sezioneCompleta);

        System.out.println("Numero totale di pagine del libro: " + libro.numeroTotPagine());
        System.out.println("Numero pagine nel capitolo 1: " + sezionePrincipale.getNumeroPagine());
        System.out.println("Numero pagina:");
        p3.stampa();
        System.out.println("Stampa sezione:");
        sottoSezione1.stampa();
        System.out.println("Stampa libro:");
        libro.stampaLibro();

    }

}
