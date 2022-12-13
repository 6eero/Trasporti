import java.util.Objects;
import java.util.function.Predicate;

public class Filtro implements Predicate<Spedizione> {

        private final String s;

        Filtro(String s) {

            this.s = s;
        }

    /**
     *
     * @param spedizione the input argument
     * @return true se all'interno del registro spedizioni c'è una spedizione che soddisfa i reqs richiesti
     */
    @Override
        public boolean test(Spedizione spedizione) {
            return (
                    (spedizione.tempistica.getDataPartenza().equals(s)) || (Objects.equals(spedizione.percorso.getOrigine(), s)) ||
                    (Objects.equals(spedizione.percorso.getDestinazione(), s)) || (Objects.equals(spedizione.autocarro.getTarga(), s))
            );
        }
}

