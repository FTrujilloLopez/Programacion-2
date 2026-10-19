import java.util.Scanner;
public class Principal
{
    public static void main(String[] args)
    {
      Persona p1 = new Persona();
      Scanner in = new Scanner(System.in);
      
      System.out.print("Ingresar Nombre: ");
      p1.setNombre(in.nextLine());
      
      System.out.print("Ingresar DNI: ");
      p1.setDNI(in.nextInt());
      
      System.out.print("Ingresar Edad: ");
      p1.setEdad(in.nextInt());
      
      in.close();
      
      System.out.print(p1.toString());
      
      
      
      
      
    }
      

      
    
    
    
}