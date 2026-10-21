public class Banda extends Espectaculo
{
    
    private String nombre;
    private Integrante[] integrantes;
    private int cantIntegrantes;
    
    public Banda(String codigo,String fecha,boolean campo,int cantLocalidades,
                     double precioInicial,Productora productora,String nombre){
        super(codigo,fecha,campo,cantLocalidades,precioInicial,productora);
        this.nombre = nombre;
        this.integrantes = new Integrante[8];
        this.cantIntegrantes = 0;
    }
    
    @Override
    public double calcularGanancia(){
        double tot = 0;
        if(this.getCampo()){
            this.setCantLocalidades(8000);
            tot = this.getPrecioInicial() * this.getCantLocalidades();
        }
        if(this.cantIntegrantes > 5){
            tot += ((tot*20)/100);            
        }
        
        return (tot*50)/100;
    }
    
    
}