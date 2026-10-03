import java.util.Scanner;
public class Ejercicio1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //Declaracion lee teclado
        System.out.print("Ingresar 1er real");
        double a = in.nextDouble();
        System.out.print("Ingresar 2do real");
        double b = in.nextDouble();
        System.out.print("Ingresar 3er real");
        double c = in.nextDouble();
        in.close();
        
        if((a < b + c) && (b < a + c) && (c < a + b)){
          double p = (a + b + c);
          System.out.print("Perimetro :" + p);  
        }
    }
}