//Están los ejercicios 10 y 11 aquí
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        boolean continuar = false;
        ResidentesHotel hotel = new ResidentesHotel();
        Clasificacion clasificacion = new Clasificacion();
        jugadoresHotel("src/jugadores.txt", hotel);
        do {
            System.out.println("El 10 y el 11 están aquí");
            System.out.println("Menu de opciones: ");
            System.out.println("1. Jugadores alojados en el hotel");
            System.out.println("2. Jugadores de la comunidad valenciana");
            System.out.println("3. Clasificacion general");
            System.out.println("4. Salir");

            try {
                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();

                switch (opcion) {

                    case 1 -> {
                        alojados("src/alojados.txt", hotel);
                    }

                    case 2 -> {
                        cv("src/jugadoresCV.txt", hotel);
                    }

                    case 3 -> {
                        leerClas(clasificacion, hotel);
                    }

                    case 4 -> {
                        continuar = true;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Solo números permitidos");
            }


        } while (!continuar);
    }

    public static void jugadoresHotel(String ruta, ResidentesHotel hotel) {
        Scanner scan = ficheroDeLectura(ruta);

        scan.nextLine();
        scan.nextLine();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(";");
            Jugador j1 = new Jugador(tokens);
            hotel.añadirJugador(j1);
        }
    }

    public static Scanner ficheroDeLectura(String ruta) {
        try {
            Scanner scan = new Scanner(
                    new FileReader(ruta)
            );
            return scan;
        } catch (FileNotFoundException e) {}
        return null;
    }

    public static void alojados(String ruta, ResidentesHotel hotel) {
        int contador = 1;
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(new FileWriter(ruta)
                    )
            );
            while (contador <= hotel.residentes.size()) {
                if (hotel.residentes.get(contador).info.contains("H")) {
                    Jugador j1 = hotel.residentes.get(contador);
                    pw.println(j1.rank + " - " + j1.nombre);
                }
                contador++;
            }
            pw.close();
        } catch (IOException e) {}

    }

    public static void cv(String ruta, ResidentesHotel hotel) {
        int contador = 1;
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(new FileWriter(ruta)
                    )
            );
            while (contador <= hotel.residentes.size()) {
                if (hotel.residentes.get(contador).info.contains("CV")) {
                    Jugador j1 = hotel.residentes.get(contador);
                    pw.println(j1.rank + " - " + j1.nombre);
                }
                contador++;
            }
            pw.close();
        } catch (IOException e) {}

    }

    public static void leerClas(Clasificacion clasificacion, ResidentesHotel hotel) {
        try {
            Scanner scan = new Scanner(new FileReader("src/clasificacion.csv"));
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                String[] split = line.split(";");
                System.out.println(split[10]);
                System.out.println(split[5]);
                hotel.residentes.get(split[1]).setPuntos(Double.parseDouble(split[5]));
                hotel.residentes.get(split[1]).setElo(Integer.parseInt(split[10]));
                System.out.println(hotel.residentes.get(split[1]));
            }

        } catch (FileNotFoundException e) {}

    }
}