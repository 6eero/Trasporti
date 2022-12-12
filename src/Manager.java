/**
 * L’azienda di trasporti Logistic vuole usare un’app mobile per consentire ai propri manager di creare e modificare dei
 * viaggi che i propri autocarri possono svolgere. Ciascun viaggio, che va da una città di origine a una di destinazione
 * eventualmente passando per città intermedie, riguarda quantità (in kg) di merce di un certo tipo (colli sfusi, liqui-
 * di, gas, da-frigo) per conto di un cliente. Il viaggio deve essere svolto con autocarri (di tipo compatibile col tipo
 * di merce) e capacità di carico adeguata (eventualmente più di uno) in modo che la merce parta a una certa data oppure
 * arrivi a una certa data. I percorsi per tutte le coppie servite (orgine, destinazione) sono prefissati; in certi casi
 * esistono percorsi ridondanti (ad es. da UD a MI si può passare per Mestre o per Treviso e poi Castelfranco Veneto).
 * I percorsi sono simmetrici: se esiste (origine –> destinazione) esiste anche (destinazione –> origine) ed è l’inverso.
 * Un viaggio può servire a 1 o più clienti. Un manager deve poter:
 *   - prenotare un certo viaggio, dati origine, destinazione, tipo di merce, kg, data-partenza o data-arrivo
 *   - sapere quali viaggi sono prenotati per una certa data, o origine, o destinazione, o autocarro
 *   - reinstradare un viaggio su un percorso alternativo qualora sia necessario.
 * Si necessita di un’API che consenta di implementare queste operazioni.
 */

public class Manager {

     public static void main(String[] args) {

          RegistroSpedizioni registroSpedizioni = new RegistroSpedizioni();

          Percorso percorso1 = new Percorso("Roma", "Napoli", new String[]{"Udine", "Milano"});
          Date tempistiche1 = new Date("12 dicembre", "18 dicembre");
          Autocarro autocarro1 = new Autocarro(12, "BS 456GB", Autocarro.tipoMerce.daFrigo);
          String numeroSpedizione1 = "#14456";
          Spedizione spedizione1 = new Spedizione(percorso1, tempistiche1, autocarro1, numeroSpedizione1);

          registroSpedizioni.prenotaSpedizione(spedizione1);


          Percorso percorso2 = new Percorso("Udine", "Mestre", new String[]{"Lecce", "Livorno", "Bergamo", "Belluno"});
          Date tempistiche2 = new Date("11 dicembre", "23 gennaio");
          Autocarro autocarro2 = new Autocarro(9, "BS 895KD", Autocarro.tipoMerce.liquidi);
          String numeroSpedizione2 = "#41298";
          Spedizione spedizione2 = new Spedizione(percorso2, tempistiche2, autocarro2, numeroSpedizione2);

          registroSpedizioni.prenotaSpedizione(spedizione2);

          registroSpedizioni.stampaPercorso("#41298");
          registroSpedizioni.viaggiPrenotati("BS 895KD");

     }
}


