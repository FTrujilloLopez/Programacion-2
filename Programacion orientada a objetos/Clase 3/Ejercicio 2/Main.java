import java.util.Scanner;
public class Main
{
   public static void main(String[] args){
       Scanner in = new Scanner(System.in);

       BalanzaComercial balanza = new BalanzaComercial();

       System.out.println("Ingresar peso(kg): ");
       double peso = in.nextDouble();
       
       while(peso != 0){
           System.out.println("Ingresar precio por kg: ");
           double precio = in.nextDouble();
           
           balanza.registrarProducto(peso,precio);
           
           System.out.println("Subtotal: " + balanza.montoAPagar());
           
           System.out.println("Ingresar peso(kg): ");
           peso = in.nextDouble();
           
       }
       
       System.out.print(balanza.resumenDeCompra());
   }
}