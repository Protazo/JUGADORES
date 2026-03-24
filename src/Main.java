import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Quieres ver los jugadores que se alojan en el hotel (1)");
            System.out.println("o los que están federados en la comunidad valenciana (2)?");
            String opcion = sc.nextLine();

            Scanner scan = new Scanner(
                    new FileReader("src/jugadores.txt")
            );


            PrintWriter pw = ficherodefault("src/alojados.txt");
            PrintWriter cv = ficherodefault("src/jugadoresCV.txt");

            scan.nextLine();
            scan.nextLine();
            String line = "";



            while (scan.hasNext()) {
                line = scan.nextLine();
                String mayusculas = line.toUpperCase();
                String[] split = line.split(";");
                String[] splitmayus = mayusculas.split(";");

                if (opcion.equals("1")) {
                    if (splitmayus[7].contains("H")) {

                        System.out.println(split[0] + " - " + split[2]);
                        pw.println(split[0] + " - " + split[2]);
                    }
                }

                if (opcion.equals("2")) {
                    if (splitmayus[7].contains("CV")) {

                        System.out.println(split[0] + " - " + split[2]);
                        cv.println(split[0] + " - " + split[2]);
                    }
                }
            }

            cv.close();
            pw.close();
        } catch (Exception e) {}
    }

    public static PrintWriter ficherodefault(String str) {
        try {

            PrintWriter pw = new PrintWriter(
                    new FileWriter(str));
            if (!str.contains("CV")) {
                pw.println("Lista de jugadores alojados en Hotel Meli�");
                pw.println();
                pw.println("Ranking        Nombre");
                pw.println("----------------------------------------");
            }
            if (str.contains("CV")) {
                pw.println("Lista de jugadores federados en CV");
                pw.println();
                pw.println("Ranking        Nombre");
                pw.println("----------------------------------------");
            }

            return pw;
        } catch (Exception e) {
            return null;
        }


    }
}
