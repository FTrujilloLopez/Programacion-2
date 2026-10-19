public class Micro
{
    private String patente;
    private String destino;
    private String horaSalida;
    private boolean[] asientos = new boolean[20];
    private int asientosO;
    
    public Micro () {
        
    }
    
    public Micro (String patente, String destino, String horaSalida){
        this.patente = patente;
        this.destino = destino;
        this.horaSalida = horaSalida;
        asientosO = 0;
    }
    
    public String getPatente (){
        return patente;
    }
    
    public String getDestino (){
        return destino;
    }
    
    public String getHoraSalida (){
        return horaSalida;
    }
    
    public int getAsientosO(){
        return asientosO;
    }
    
    public boolean microLleno (){
        boolean aux;
        if (asientosO == 20){
            aux = true;
        }
        else
            aux = false;
        return aux;
    }
    
    public boolean validarAsiento (int asiento){
        boolean aux;
        if (asiento >= 0 && asiento < asientos.length)
            aux = true;
        else
            aux = false;    
        return aux;
    }
    
    public String estadoAsiento (int asiento){
        String aux;
        if (this.validarAsiento(asiento)){
            if (asientos[asiento])
                aux = "Ocupado";
            else
                aux = "Desocupado";
        }
        else
            aux = "El numero de asiento no es valido";
        return aux;
    }
    
    
    public void setPatente (String patente){
        this.patente = patente;
    }
    
    public void setHoraSalida (String horaSalida){
        this.horaSalida = horaSalida;
    }
    
    public void setDestino (String destino){
        this.destino = destino;
    }
    
    
}