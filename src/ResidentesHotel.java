import java.util.HashMap;
import java.util.Map;

public class ResidentesHotel {
    Map<Integer, Jugador> residentes = new HashMap<>();

    public void añadirJugador(Jugador jugador) {
        residentes.put(jugador.rank, jugador);
    }
}
