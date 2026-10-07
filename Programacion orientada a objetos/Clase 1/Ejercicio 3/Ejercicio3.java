import java.util.Scanner;
public class Ejercicio3
{
 public static void main (String[] args)
 {
  System.out.print("Ingresar numero mayor a 0: ");
  Scanner in = new Scanner(System.in);
  int num =in.nextInt();
  int factorial = 1;
  int i;
  for (i = num; i>0; i--)
      factorial = factorial * i;
  System.out.print("Factorial: " + factorial);    
       
    }
}
 
