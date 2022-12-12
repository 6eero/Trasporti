public class Percorso {

    public String origine;
    public String destinazione;
    public String[] cittaIntermedie;

    public Percorso (String origine, String destinazione, String[] percorsoIntermedio) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.cittaIntermedie = percorsoIntermedio;
    }
}
