public class Spedizione {

    Percorso percorso;
    Date tempistica;
    Autocarro autocarro;
    String numeroSpedizione;

    public Spedizione(Percorso percorso, Date tempistica, Autocarro autocarro, String numeroSpedizione) {
        this.percorso = percorso;
        this.tempistica = tempistica;
        this.autocarro = autocarro;
        this.numeroSpedizione = numeroSpedizione;
    }


}
