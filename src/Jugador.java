public class Jugador {
    int rank;
    String titulo;
    String nombre;
    String fed;
    int fide;
    int fide_id;
    String origen;
    String info;

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
