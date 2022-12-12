import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class RegistroSpedizioni {

    private Vector<Spedizione> registroSpedizioni;

    public RegistroSpedizioni() {
        registroSpedizioni = new Vector<Spedizione>();
    }

    public void prenotaSpedizione(Spedizione spedizione) {
        registroSpedizioni.add(spedizione);
    }

    public void stampaElencoSpedizioniPrenotate() {

        System.out.println("Spedizioni prenotate:");

        for (int i = 0; i < registroSpedizioni.size(); i++) {
            System.out.println(registroSpedizioni.get(i).numeroSpedizione);
        }
    }

    public void reinstradaSpedizione(String numeroSpedizione, String nuovaOrigine, String nuovaDestinazione, String[] percorsointermedio) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if(Objects.equals(registroSpedizioni.get(i).numeroSpedizione, numeroSpedizione)) {
                registroSpedizioni.get(i).percorso = new Percorso(nuovaOrigine, nuovaDestinazione, percorsointermedio);
            }
        }
    }

    public void stampaPercorso(String numeroSpedizione) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if(Objects.equals(registroSpedizioni.get(i).numeroSpedizione, numeroSpedizione)) {
                System.out.println("L'origine della spedizione: "+numeroSpedizione+" è: "+ registroSpedizioni.get(i).percorso.origine);
                System.out.println("La destinazione della spedizione: "+numeroSpedizione+" è: "+registroSpedizioni.get(i).percorso.destinazione);
                System.out.println("Le città intermedie della spedizione: "+numeroSpedizione+" sono: "+Arrays.toString(registroSpedizioni.get(i).percorso.cittaIntermedie));
            }
        }
    }

    public void viaggiPrenotati(String test) {
        for (int i = 0; i < registroSpedizioni.size(); i++) {
            if (
                    (registroSpedizioni.get(i).tempistica.dataPartenza.toString().equals(test)) ||
                    (Objects.equals(registroSpedizioni.get(i).percorso.origine, test)) ||
                    (Objects.equals(registroSpedizioni.get(i).percorso.destinazione, test)) ||
                    (Objects.equals(registroSpedizioni.get(i).autocarro.targa, test))
            ) {
                System.out.println("La spedizione "+registroSpedizioni.get(i).numeroSpedizione+" è prenotata");
            }
        }
    }
}
