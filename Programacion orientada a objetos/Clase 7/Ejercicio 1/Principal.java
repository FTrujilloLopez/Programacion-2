import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
      Proyecto proyecto = new Proyecto("Bacterias","ML19","Felipe Trujillo");
      Investigador inv1 = new Investigador("Gonzalo",2,"Quimico");
      Investigador inv2 = new Investigador("Omar",1,"Quimico");
      Investigador inv3 = new Investigador("Pedro",3,"Cientifico");
      
      inv1.agregarSubsidio(new Subsidio(150000, "Compra de servidores GPU"));
      inv1.agregarSubsidio(new Subsidio(50000, "Viaticos para congreso internacional"));

      inv2.agregarSubsidio(new Subsidio(80000, "Licencias de software"));
      inv2.agregarSubsidio(new Subsidio(40000, "Material bibliografico"));

      inv3.agregarSubsidio(new Subsidio(120000, "Equipamiento de laboratorio"));
      inv3.agregarSubsidio(new Subsidio(60000, "Publicacion en revista indexada"));
      
      proyecto.agregarInvestigador(inv1);
      proyecto.agregarInvestigador(inv2);
      proyecto.agregarInvestigador(inv3);
      
      proyecto.otorgarTodos("Gonzalo");
      
      System.out.println(proyecto.toString());
      
        
        
        
        
        
        
    }
}