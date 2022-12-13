import java.util.Objects;
import java.util.function.Predicate;

public class Filtro implements Predicate<Spedizione> {

        private final String s;

        Filtro(String s) {
            this.s = s;
        }

        @Override
        public boolean test(Spedizione spedizione) {
            return ((spedizione.tempistica.getDataPartenza().equals(s)) ||
                    (Objects.equals(spedizione.percorso.getOrigine(), s)) ||
                    (Objects.equals(spedizione.percorso.getDestinazione(), s)) ||
                    (Objects.equals(spedizione.autocarro.getTarga(), s)));
        }
}

