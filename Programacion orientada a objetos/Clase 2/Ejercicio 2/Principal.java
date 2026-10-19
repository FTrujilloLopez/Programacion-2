import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
      Grupo grupoPersonas = new Grupo();
      grupoPersonas.almacenarPersonas();
      
      System.out.print("Cantidad de personas menores a 65 años: " + grupoPersonas.getCantidadPersonas65());
      if(grupoPersonas.getObtenerPersonaDni() != null){
      System.out.print("Persona con menor DNI " + grupoPersonas.getObtenerPersonaDni().toString());
      
      }
    
    }
}