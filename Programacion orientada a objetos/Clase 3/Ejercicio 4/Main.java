import java.util.Scanner;
public class Main
{
    public static void main(String[]args){
      Jugador[] jugadores = new Jugador[50];  
    
      for(int i = 0;i < jugadores.length;i++){
          Scanner in = new Scanner(System.in);
          
          System.out.print("Ingresar datos del jugador " + i);
          
          System.out.print("Nombre: ");
          String nombre = in.nextLine();
          
          System.out.print("Dni: ");
          int dni = in.nextInt();
          
          System.out.print("Edad: ");
          int edad = in.nextInt();
          
          System.out.print("Partidos: ");
          int partidos = in.nextInt();
          
          System.out.print("Goles: ");
          int goles = in.nextInt();
          
          in.nextLine();
          
          jugadores[i] = new Jugador(nombre,dni,edad,partidos,goles);
      }
      
      int cantidad = cantidadJugadores(jugadores);
      System.out.print("Jugadores con mas de 100 partidos jugados: " + cantidad);
      
      
    } 
    
    public static int cantidadJugadores(Jugador[] vector){
      int cantidad = 0;
      for(int i = 0;i < vector.length;i++){
        if(vector[i].getNumeroDePartidos() > 100){
             cantidad++;
        } 
      }
      return cantidad;
    }
}
