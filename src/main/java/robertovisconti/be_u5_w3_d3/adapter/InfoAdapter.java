package robertovisconti.be_u5_w3_d3.adapter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class InfoAdapter implements DataSource {

    private final Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        Date dataNascita = info.getDataDiNascita();
        if (dataNascita == null) {
            return 0;
        }

        // converto la date in local date
        LocalDate dataNascitaLD = dataNascita.toInstant()  // Instant rappresenta un punto preciso sulla linea di tempo, misurato in nanosecondi a partire dal 1 gennaio 1970 UTC
                .atZone(ZoneId.systemDefault()) // addocio al fuso orario su cui gira il mio programma
                .toLocalDate(); // estraggo solo la componente della data giorno - mese - anno

        LocalDate oggi = LocalDate.now();

        return Period.between(dataNascitaLD, oggi) // calcolo la distanza temporale esatta tra la data di nascita e oggi
                .getYears(); // estraggo solo la parte degli anni
    }
}
