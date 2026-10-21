public abstract class Espectaculo
{ 
  private String codigo;
  private String fecha;
  private boolean campo;
  private int cantLocalidades;
  private double precioInicial;
  private Productora productora;
  
  public Espectaculo(String codigo,String fecha,boolean campo,int cantLocalidades,
                     double precioInicial,Productora productora){
    this.codigo = codigo;
    this.fecha = fecha;
    this.campo = campo;
    this.cantLocalidades = cantLocalidades;
    this.precioInicial = precioInicial;
    this.productora = productora;
  }
  
  public boolean getCampo(){
      return this.campo;
  }
  
  public int getCantLocalidades(){
      return this.cantLocalidades;
  }
  
  public void setCantLocalidades(int cantLocalidades){
      this.cantLocalidades =+ cantLocalidades;
  }
  
  public double getPrecioInicial(){
      return this.precioInicial;
  }
  
  public abstract double calcularGanancia();
  
  public boolean esFechaEspecial() {
    return this.fecha.equals("24/03/2026") || 
           this.fecha.equals("25/05/2026") || 
           this.fecha.equals("09/07/2026");
  }
  
  
  
}
