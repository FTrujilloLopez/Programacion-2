public class Subsidio
{
    private double montoPedido;
    private String motivo;
    private boolean otorgado;
    
    public Subsidio(double montoPedido,String motivo){
    this.montoPedido = montoPedido;
    this.motivo = motivo;
    this.otorgado = false;
    }
    
    public double getMontoPedido(){
        return this.montoPedido;
    }
    
    public String getMotivo(){
        return this.motivo;
    }
    
    public boolean getOtorgado(){
        return this.otorgado;
    }
    
    public void setOtorgar(boolean otorgar){
        this.otorgado = otorgar;
    }
}