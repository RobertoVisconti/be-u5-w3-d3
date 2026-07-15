package robertovisconti.be_u5_w3_d3.chain;

public abstract class Ufficiale {
    private Ufficiale responsabile;
    private String grado;
    private int stipendio;

    public Ufficiale(String grado, int stipendio) {
        this.grado = grado;
        this.stipendio = stipendio;
    }

    public void setResponsabile(Ufficiale responsabile) {
        this.responsabile = responsabile;
    }

    public void controlloStipendio(int importo) {
        if (this.stipendio >= importo) {
            System.out.println("L'ufficiale con grado: " + grado + " percepisce: " + importo + " stipendio effettivo: " + stipendio);
        } else if (responsabile != null) {
            System.out.println(grado + " non guadagna abbastanza. Prossima richiesta a: " + responsabile.grado);
            responsabile.controlloStipendio(importo);
        } else {
            System.out.println("Nessun ufficiale nella catena guadagna almeno " + importo + "€.");
        }
    }

}
