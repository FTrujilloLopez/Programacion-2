public class Jugador {
    private String nombre;
    private int DNI;
    private int edad; 
    private int partidos; 
    private int goles;
    
    public Jugador(String unNombre, int unDNI, int unaEdad,int _partidos,int _goles){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
        partidos = _partidos;
        goles = _goles;
    }
    
    public Jugador(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getNumeroDePartidos(){
        return partidos;
    }
    
    public int getNumeroDeGoles(){
        return goles;
    }
    
    public void setNumeroDePartidos(int _partidos){
        partidos = _partidos;
    }
    
    public void setNumeroDeGoles(int _goles){
        goles = _goles;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }
    
}
