public class Carga {
    private Partido[] vector;
    private int dimensionLogica; // Para llevar la cuenta de cuántos partidos cargaste

    public Carga(int dimension) {
        vector = new Partido[dimension];
        dimensionLogica = 0;
    }

    // Método para agregar un partido (los datos ya vienen leídos desde el main)
    public void agregarPartido(Partido unPartido) {
        if (dimensionLogica < vector.length) {
            vector[dimensionLogica] = unPartido;
            dimensionLogica++;
        }
    }

    // Tus otros métodos (getGanoRiver, getGolesBoca, getPorcentajeEmpate) 
    // recorren hasta dimensionLogica en lugar de 325 fijo, o usan vector.length
    public int getGanoRiver() {
        int partidosGanadosRiver = 0;
        for(int i = 0; i < dimensionLogica; i++){
            if(vector[i].getLocal().equals("River") && vector[i].getGolesLocal() > vector[i].getGolesVisitante()){
                partidosGanadosRiver++;
            }
        }
        return partidosGanadosRiver;
    }

    public int getGolesBoca(){
        int golesBoca = 0;
        for(int i = 0; i < dimensionLogica; i++){
            if(vector[i].getLocal().equals("Boca")){
                golesBoca += vector[i].getGolesLocal();
            }
        }
        return golesBoca;
    }
    
    public double getPorcentajeEmpate(){
        int cantEmpate = 0;
        if (dimensionLogica == 0) return 0;
        for(int i = 0; i < dimensionLogica; i++){
            if(vector[i].getGolesLocal() == vector[i].getGolesVisitante()){
                cantEmpate++;
            }
        }
        return ((double) cantEmpate / dimensionLogica) * 100;
    }
}