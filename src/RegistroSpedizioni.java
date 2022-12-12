import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class RegistroSpedizioni {

    private Vector<Spedizione> registroSpedizioni;

    public RegistroSpedizioni() {
        registroSpedizioni = new Vector<Spedizione>();
    }

    /**
     * Metodo che permette di prenotare un certo viaggio, dati origine, destinazione, tipo di merce, kg, data-partenza o data-arrivo
     * @param spedizione != null
     */
    public void prenotaSpedizione(Spedizione spedizione) {
        registroSpedizioni.add(spedizione);
    }

    /**
     * Metodo che stampa tutte le spedizione contenute nel registro spedizioni
     */
    public void stampaElencoSpedizioniPrenotate() {

        System.out.println("Spedizioni prenotate:");

        for (int i = 0; i < registroSpedizioni.size(); i++) {
            System.out.println(registroSpedizioni.get(i).numeroSpedizione);
        }
    }

    /**
     * Metodo che permette di modificare il tragitto compiuto da un autocarro dato il suo numero di spedizione
     * @param numeroSpedizione deve appartenere al registro spedizioni
     * @param nuovaOrigine != null
     * @param nuovaDestinazione != null
     * @param percorsointermedio può anche essere null
     */
    public void reinstradaSpedizione(String numeroSpedizione, String nuovaOrigine, String nuovaDestinazione, String[] percorsointermedio) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if(Objects.equals(registroSpedizioni.get(i).numeroSpedizione, numeroSpedizione)) {
                registroSpedizioni.get(i).percorso = new Percorso(nuovaOrigine, nuovaDestinazione, percorsointermedio);
            }
        }
    }

    /**
     * Metodo che, dato un numero di spedizone, ne stampa luogo di partenza, di arrivo e il tragitto intermedio
     * @param numeroSpedizione deve appartenere al registro spedizioni
     */
    public void stampaPercorso(String numeroSpedizione) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if(Objects.equals(registroSpedizioni.get(i).numeroSpedizione, numeroSpedizione)) {
                System.out.println("L'origine della spedizione: "+numeroSpedizione+" è: "+ registroSpedizioni.get(i).percorso.getOrigine());
                System.out.println("La destinazione della spedizione: "+numeroSpedizione+" è: "+ registroSpedizioni.get(i).percorso.getDestinazione());
                System.out.println("Le città intermedie della spedizione: "+numeroSpedizione+" sono: "+Arrays.toString(registroSpedizioni.get(i).percorso.getCittaIntermedie()));
            }
        }
    }

    /**
     * Metodo che permette di sapere quali viaggi sono prenotati per una certa data, o origine, o destinazione, o autocarro
     * @param test può essere una data nel formato "Giorno mese", un luogo d'origine o una destinazione oppure un numero di spedizione
     */
    public void viaggiPrenotati(String test) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if (
                    (registroSpedizioni.get(i).tempistica.getDataPartenza().toString().equals(test)) ||
                    (Objects.equals(registroSpedizioni.get(i).percorso.getOrigine(), test)) ||
                    (Objects.equals(registroSpedizioni.get(i).percorso.getDestinazione(), test)) ||
                    (Objects.equals(registroSpedizioni.get(i).autocarro.getTarga(), test))
            ) {
                System.out.println("La spedizione "+registroSpedizioni.get(i).numeroSpedizione+" è prenotata");
            }
        }
    }
}
