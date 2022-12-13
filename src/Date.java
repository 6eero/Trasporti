public class Date {

    private final String dataPartenza;
    private final String dataArrivo;

    public Date (String p, String a) {
        dataPartenza = p;
        dataArrivo = a;
    }

    public String getDataPartenza() {
        return dataPartenza;
    }

    public String getDataArrivo() {
        return dataArrivo;
    }
}
