import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;
import java.util.function.Predicate;

public class Manager {

    private final Vector<Spedizione> registroSpedizioni;

    public Manager() {
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
     * Metodo che permette di sapere quali viaggi sono prenotati per una certa data, o origine, o destinazione, o autocarro
     * @param campoDiRicerca devessere una data, un luogo di partenza o destinazione oppure una targa di un autocarro
     * @param manager deve esistere, può anche essere vuoto
     */
    public void ricercaUnaSpedizione(String campoDiRicerca, Manager manager) {

        Iterator<Spedizione> i = manager.viaggiPrenotati(new Filtro(campoDiRicerca));

        while (i.hasNext()) {
            System.out.println("La spedizione "+i.next().numeroSpedizione+" è prenotata");
        }
    }

    /**
     * @return un oggetto di tipo iteratore che contiene le spedizioni che soddisfano il criterio di ricerca
     */
    private Iterator<Spedizione> viaggiPrenotati(Predicate<Spedizione> predicate) {
        return registroSpedizioni.stream().filter(predicate).iterator();
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
     * Metodo che stampa tutte le spedizione contenute nel registro spedizioni
     */
    public void stampaElencoSpedizioniPrenotate() {

        System.out.println("Spedizioni prenotate:");

        for (int i = 0; i < registroSpedizioni.size(); i++) {
            System.out.println(registroSpedizioni.get(i).numeroSpedizione);
        }
    }

}
