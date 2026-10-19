public class Entrenador {
    private String nombre;
    private double sueldo;
    private int campeonatos; 
    
    public Entrenador(String nombre, double sueldo, int campeonatos){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.campeonatos = campeonatos; 
    }
    
    public Entrenador(){
     
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    
    public int getCampeonatos(){
        return campeonatos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    
    public void setCampeonatos(int campeonatos){
        this.campeonatos = campeonatos;
    }
    
    public double calcularSueldoACobrar(){
        double aux = sueldo;
        if(campeonatos >= 1  && campeonatos <= 4){
          aux += 5000;
        }else if(campeonatos >= 5  && campeonatos <= 10){
            aux += 30000;
        }else if(campeonatos > 10){
            aux += 50000;
        }
        
        return aux;
    }
    
    public String toString(){
        String aux = nombre + " gano " + campeonatos + " campeonatos";
        
        return aux;
    }
    


    
    
    
}
