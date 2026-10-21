public class MovistarArena
{
  private Espectaculo[] espectaculos;
  private int cantEspectaculos;
  public MovistarArena(){
       this.espectaculos = new Espectaculo[30];
       cantEspectaculos = 0;
  }
  
  public void agregarEspectaculo(Espectaculo espectaculo){
      this.espectaculos[cantEspectaculos] = espectaculo;
      cantEspectaculos++;
      
  }
  
  public double calcularPromedioGancia(){
      double tot = 0;
      for(int i = 0;i < cantEspectaculos;i++){
          tot += espectaculos[i].calcularGanancia();  
          if(espectaculos[i].esFechaEspecial()){
              tot += (tot*10)/100;
          }
          if(espectaculos[i].
      }
      
      return tot;
    }
}