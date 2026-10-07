import java.util.Scanner;
public class Ejercicio4
{
 public static void main (String[] args)
 {
  int factorial = 1;
  int i,j;
  for (i = 9; i>0; i--){
      for (j = i; j>0; j--)
         factorial = factorial * j;
    System.out.println("Factorial: " + factorial);
    factorial = 1;
        }
    }
}
 
