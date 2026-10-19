import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        String nombre = in.nextLine();
        
        System.out.print("Sueldo: ");   
        double sueldo = in.nextDouble();
        
        System.out.print("Campeonatos: ");
        int campeonatos = in.nextInt();
        in.nextLine(); // Limpiar el buffer de entrada
        
        Entrenador e1 = new Entrenador(nombre, sueldo, campeonatos);
        System.out.println("\n--- Probando Entrenador 1 ---");
        System.out.println(e1.toString());
        System.out.println("Sueldo a cobrar: " + e1.calcularSueldoACobrar());
        
        // 2. Probando los métodos Getters
        System.out.println("\n--- Probando Getters ---");
        System.out.println("getNombre(): " + e1.getNombre());
        System.out.println("getSueldo(): " + e1.getSueldo());
        System.out.println("getCampeonatos(): " + e1.getCampeonatos());
        
        // 3. Probando el constructor vacío y los métodos Setters
        Entrenador e2 = new Entrenador();
        e2.setNombre("Carlos");
        e2.setSueldo(450000);
        e2.setCampeonatos(7);
        
        System.out.println(e2.toString());
        System.out.println("Sueldo a cobrar (con setters): " + e2.calcularSueldoACobrar());
        
        in.close();
    }
}