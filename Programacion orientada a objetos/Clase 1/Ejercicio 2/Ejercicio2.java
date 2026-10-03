import java.util.Scanner;
public class Ejercicio2
{
 public static void main(String[] args)
 {
  Scanner in = new Scanner(System.in); 
  
  System.out.print("Ingresar patentes: ");
  
  int patente = in.nextInt();
  int totalAutos = 0;
  int autosPermitidos = 0;
  while (patente != 0)
  {
   if(patente % 2 == 0){
    System.out.print("Permitido");
    autosPermitidos++;
   }else {
       System.out.print("No permitido");
   }
  totalAutos++; 
  patente = in.nextInt(); 
  }
  
  double porcentaje = (autosPermitidos/totalAutos)*100;
  System.out.print("Porcentaje de autos que entraron: " + porcentaje);
  in.close();
 }
}