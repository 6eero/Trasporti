public class Autocarro {

    public double quantitaMax;
    public String targa;
    public enum tipoMerce {
        colliSfusi,
        liquidi,
        gas,
        daFrigo
    }
    public static tipoMerce tipoMerce;

    public Autocarro (double quantitaMax, String targa, tipoMerce tipoMerce) {
        this.quantitaMax = quantitaMax;
        this.targa = targa;
        this.tipoMerce = tipoMerce;
    }
}
