public class Solista extends Espectaculo
{
  private int cantCanciones;
  private String[] setList;
  
  public Solista(String codigo,String fecha,boolean campo,int cantLocalidades,
                     double precioInicial,Productora productora,int cantCanciones){
      super(codigo,fecha,campo,cantLocalidades,precioInicial,productora);
      this.cantCanciones = cantCanciones;
      this.setList = new String[cantCanciones];
  }
  
  @Override
  public double calcularGanancia(){
      double tot = 0;
      if(this.getCampo()){
          this.setCantLocalidades(8000);
          tot = this.getPrecioInicial() * this.getCantLocalidades();
      }
      
      if(this.setList.length > 28){
          tot += ((tot*21)/100);
      }else if(this.setList.length > 25 && this.setList.length < 28){
          tot += ((tot*15.5)/100);
      }
      
      return (tot*42)/100;   
  }
}