import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Carga gestorPartidos = new Carga(325); // O la cantidad que necesites

        // Simulamos la carga (o un ciclo para cargar los partidos)
        System.out.println("--- Carga de Partidos ---");
        for (int i = 0; i < 325; i++) {
            System.out.print("Local: ");
            String local = in.nextLine();
            
            System.out.print("Visitante: ");
            String visitante = in.nextLine();
            
            System.out.print("Goles Local: ");
            int golesL = in.nextInt();
            
            System.out.print("Goles Visitante: ");
            int golesV = in.nextInt();
            in.nextLine(); // Limpiar buffer

            // Creamos el objeto Partido en el Main
            Partido p = new Partido(local, visitante, golesL, golesV);
            
            // Se lo mandamos a la clase Carga
            gestorPartidos.agregarPartido(p);
        }

        // Mostrar resultados (también se hace desde el Main)
        System.out.println("Partidos ganados River: " + gestorPartidos.getGanoRiver());
        System.out.println("Goles anotados Boca: " + gestorPartidos.getGolesBoca());
        System.out.println("Porcentaje de empates: " + gestorPartidos.getPorcentajeEmpate() + "%");
    }
}