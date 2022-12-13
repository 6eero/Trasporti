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

public class Main {

     public static void main(String[] args) {

          Manager manager = new Manager();

          /*---------------------------------- Popolamento registro delle spedizioni ----------------------------------*/


          Spedizione spedizione1 = new Spedizione (
                  new Percorso("Udine", "Napoli", new String[]{"Udine", "Milano"}),
                  new Date("12 dicembre", "18 dicembre"),
                  new Autocarro(12.34, "BS 456GB", Autocarro.tipoMerce.daFrigo),
                  "#14456"
          );
          manager.prenotaSpedizione(spedizione1);

          Spedizione spedizione2 = new Spedizione (
                  new Percorso("San Daniele", "Mestre", new String[]{"Varese", "Belluno", "Firenze", "Milano"}),
                  new Date("28 dicembre", "4 gennaio"),
                  new Autocarro(1392, "SD 856PT", Autocarro.tipoMerce.liquidi),
                  "#74362"
          );
          manager.prenotaSpedizione(spedizione2);


          /*-----------------------------------------------------------------------------------------------------------*/

          manager.ricercaUnaSpedizione("SD 856PT", manager);


     }
}


