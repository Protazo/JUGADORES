import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Clasificacion {
    Map<Integer, Jugador> clasificacion = new HashMap<>();

    public void anyadirAClas(int pos, Jugador j1) {
        clasificacion.put(pos, j1);
    }

    public void verClasificacion() {
        try {
        PrintWriter pw = new PrintWriter(
                new FileWriter("src/clasificacionjugadores.txt"));

        pw.println("Clasificacion");
        pw.println("Posición \t Nombre \t ELO \t Puntos");

        for (Map.Entry<Integer, Jugador> entry : clasificacion.entrySet()) {
            pw.println(entry.getKey() + entry.getValue().nombre + entry.getValue().fide);
        }

        } catch (IOException e) {}
    }
}
