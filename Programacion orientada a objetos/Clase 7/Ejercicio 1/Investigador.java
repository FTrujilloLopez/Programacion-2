public class Investigador
{
  private String nombre;
  private int categoria;
  private String especialidad;
  private Subsidio[] subsidios;
  private int cantidadSubsidio;
  
  public Investigador(String nombre,int categoria,String especialidad){
     this.nombre = nombre;
     this.categoria = categoria;
     this.especialidad = especialidad;
     this.subsidios = new Subsidio[5];
     this.cantidadSubsidio = 0;
  }
  
  public String getNombre(){
      return this.nombre;
  }
  
  public int getCategoria(){
      return this.categoria;
  }
  
  public String getEspecialidad(){
      return this.especialidad;
  }
  
  public void agregarSubsidio(Subsidio unSubsidio){
     if(this.cantidadSubsidio < 5){
       this.subsidios[this.cantidadSubsidio] = unSubsidio;
       this.cantidadSubsidio++;
    }
  }
  
  public double dineroOtorgado(){
      double aux = 0;
      for(int i = 0;i < cantidadSubsidio;i++){
        if(subsidios[i].getOtorgado())
          aux += subsidios[i].getMontoPedido();
      }
      
      return aux;
  }
  
  public void otorgarTodosLosSubsidios(){
      for(int i = 0;i < cantidadSubsidio;i++){
         subsidios[i].setOtorgar(true);
      }
  }
}