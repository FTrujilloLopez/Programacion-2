import java.util.Scanner;
public class Main
{
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      System.out.println("Lado 1:");
      double l1 = in.nextDouble();
      
      System.out.println("Lado 2:");
      double l2 = in.nextDouble();
      
      System.out.println("Lado 3:");
      double l3 = in.nextDouble();
      
      in.nextLine();
      
      System.out.println("Color de relleno:");
      String cRelleno = in.nextLine();
      
      System.out.println("Color de linea:");
      String cLinea = in.nextLine();
      
      in.close();
      
      Triangulo t1 = new Triangulo(l1,l2,l3,cRelleno,cLinea);
      
      System.out.println("Area: " + t1.calcularArea());
      System.out.println("Perimetro: " + t1.calcularPerimetro());
    }
}