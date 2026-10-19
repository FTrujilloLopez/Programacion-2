import java.util.Scanner;
public class Grupo
{
  //Atributos   
  private Persona[] vector;
  private int dimL;
  //1) Constructor//
  public Grupo() {
        vector= new Persona[15]; // Crea el vector vacío
        dimL = 0;
    }
 
  //2)Lee la personas y las guarda en el vector 
  public void almacenarPersonas(){
      Scanner in = new Scanner(System.in);
      for(int i = 0; i<15; i++){
          //Constructor//
          vector[i] = new Persona();
          
          System.out.print("Nombre " + i + ":");
          vector[i].setNombre(in.nextLine());
          System.out.print("DNI " + i + ":");
          vector[i].setDNI(in.nextInt());
          System.out.print("Edad " + i + ":");
          vector[i].setEdad(in.nextInt());
          //Limpiar bufer del ultimo enter//
          in.nextLine();
          dimL++;
      }
      in.close();
  }
  
  //3)Metodo para devolver la cantidad de personas mayores de 65 años B)
  public int getCantidadPersonas65(){
      int cantidad = 0;
      for(int i = 0;i < dimL;i++){
        if(vector[i].getEdad() > 65){
            cantidad++;
        }
      }
      return cantidad;
  }
  
  //4)Metodo que devuelve la representacion de la persona con menor DNI
  public Persona getObtenerPersonaDni(){
      Persona p = vector[0];
      for(int i=1;i < dimL;i++){
          if(vector[i].getDNI() < p.getDNI()){
              p = vector[i];
          }
      }
      return p;
  }
}  