/*Proyecto Final Desarrollo de Sistema Distribuidos
4CM14 Tavares Rizo, Manuel Alexis
4CM12 Vazquez Perez, Denzel Omar
4CM13 Lopez Gonzalez, Enrique

*/

package frontEnd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class FrontendSearchResponse {
        private final String cadena;
        private final int cantidad;
}
