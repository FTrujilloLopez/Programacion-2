public class Proyecto
{
  private String nombre;
  private String codigo;
  private String nombreDirector;
  private Investigador[] investigadores;
  private int cantidadInvestigadores;
  
  public Proyecto(String nombre,String codigo,String nombreDirector){
      this.nombre = nombre;
      this.codigo = codigo;
      this.nombreDirector = nombreDirector;
      this.investigadores = new Investigador[50];
      this.cantidadInvestigadores = 0 ;
  }
  
  public void agregarInvestigador(Investigador unInvestigador){
     if(this.cantidadInvestigadores < 50){
       this.investigadores[cantidadInvestigadores] = unInvestigador;
       this.cantidadInvestigadores++;
    }
  }
  
  public double dineroTotalOtorgado(){
      double aux = 0;
      for(int i = 0;i < cantidadInvestigadores;i++){
        aux += investigadores[i].dineroOtorgado();    
      }
      
      return aux;
      
  }
  
  public void otorgarTodos(String nombre_completo){
      for(int i = 0;i < cantidadInvestigadores;i++){
        if(this.investigadores[i].getNombre().equals(nombre_completo))
          this.investigadores[i].otorgarTodosLosSubsidios();
      }     
  }
  
  public String toString() {
        String aux = "Proyecto: " + this.nombre + ", Código: " + this.codigo + 
                     ", Director: " + this.nombreDirector + 
                     ", Total dinero otorgado del proyecto: " + this.dineroTotalOtorgado() + "\n";
                     
        for (int i = 0; i < this.cantidadInvestigadores; i++) {
            Investigador inv = this.investigadores[i];
            aux += "  - Investigador: " + inv.getNombre() + 
                   ", Categoría: " + inv.getCategoria() + 
                   ", Especialidad: " + inv.getEspecialidad() + 
                   ", Total dinero otorgado: $" + inv.dineroOtorgado() + "\n";
        }
        return aux;
    }
}