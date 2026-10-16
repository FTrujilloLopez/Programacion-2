import java.util.Scanner;
public class Carga
{
  private String[] vector;
  
  public Carga(){
      vector = new String[10];
  }
  
  public void setAlmacenarPalabras(){
      Scanner in = new Scanner(System.in);
      for(int i=0; i<5; i++){
          vector[i] = new String();
          System.out.println("Ingresar palabra: ");
          vector[i]= in.nextLine();
      }
      in.close();
  }
  
  public String toString(){
      String mensaje = "";
      for(int i = 0;i < 5;i++){
          mensaje += vector[i].charAt(0);
      }
      return mensaje;
  }
}