public class Autocarro {

    private final String targa;
    enum tipoMerce {
        colliSfusi,
        liquidi,
        gas,
        daFrigo
    }

    public Autocarro (double quantitaMax, String targa, tipoMerce tipoMerce) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}
