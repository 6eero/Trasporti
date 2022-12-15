public class Percorso {

    private final String origine;
    private final String destinazione;
    private String[] cittaIntermedie;

    public Percorso (String origine, String destinazione, String[] percorsoIntermedio) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.cittaIntermedie = percorsoIntermedio;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String[] getCittaIntermedie() {
        return cittaIntermedie;
    }

    public void setCittaIntermedie(String[] nuovoPercorsoIntermedio) {
        this.cittaIntermedie = nuovoPercorsoIntermedio;
    }
}
