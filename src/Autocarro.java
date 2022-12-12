public class Autocarro {

    private double quantitaMax;
    private String targa;
    enum tipoMerce {
        colliSfusi,
        liquidi,
        gas,
        daFrigo
    }
    private tipoMerce tipoMerce;

    public Autocarro (double quantitaMax, String targa, tipoMerce tipoMerce) {
        this.quantitaMax = quantitaMax;
        this.targa = targa;
        this.tipoMerce = tipoMerce;
    }

    public String getTarga() {
        return targa;
    }
}
