public class Jugador {
    int rank;
    String titulo;
    String nombre;
    String fed;
    int fide;
    int fide_id;
    String origen;
    String info;
    double puntos;
    int elo;

    public Jugador(String[] str) {
        this.rank = Integer.parseInt(str[0]);
        this.titulo = str[1];
        this.nombre = str[2];
        this.fed = str[3];
        this.fide = Integer.parseInt(str[4]);
        this.fide_id = Integer.parseInt(str[5]);
        this.origen = str[6];
        this.info = str[7];
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "rank=" + rank +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fed='" + fed + '\'' +
                ", fide=" + fide +
                ", fide_id=" + fide_id +
                ", origen='" + origen + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
