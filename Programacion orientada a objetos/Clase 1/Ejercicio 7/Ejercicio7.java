import java.util.Scanner;
public class Ejercicio7
{
 public static void main(String[] args){
  Scanner in = new Scanner(System.in);
  System.out.println("Ingresar operacion:");
  System.out.println("Para finalizar ingresar la operacion 999");
  int operacion = in.nextInt();
  int cant[] = new int[5];
  while(operacion != 999){
    cant[operacion]++;  
    operacion = in.nextInt();
  }
  in.close();
  
  int max = -1;
  int maxOperacion = 0;
  int i;
  for (i = 0; i<=4; i++){
     System.out.println("La cantidad de personas atentidas en la operacion " + i + " :" + cant[i]);
     if(cant[i] > max){
        max = cant[i]; 
        maxOperacion = i;
     }
  }
  
  System.out.println("La operacion mas solicitada es: " + maxOperacion);
 }
}