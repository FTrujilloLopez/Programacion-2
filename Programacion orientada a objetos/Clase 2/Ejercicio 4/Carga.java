import java.util.Scanner;
public class Carga
{
    private Partido[] vector;

    public Carga()
    {
       vector = new Partido[325];
    }

    public void setAlmacenarPartidos(){
        Scanner in = new Scanner(System.in);
       for(int i = 0; i < 325; i++){
         vector[i] = new Partido();
         
         System.out.print("Local: ");
         vector[i].setLocal(in.nextLine());
         System.out.print("Visitante: ");
         vector[i].setVisitante(in.nextLine());
         
         System.out.print("Goles Local: ");
         vector[i].setGolesLocal(in.nextInt());
         System.out.print("Goles Visitante: ");
         vector[i].setGolesVisitante(in.nextInt());
         
         in.nextLine();
       }
    }
    
    public int getGanoRiver(){ 
        int partidosGanadosRiver = 0;
        for(int i = 0; i < 325; i++){
            if((vector[i].getLocal() == "River") && (vector[i].getGolesLocal() > vector[i].getGolesVisitante())){
              partidosGanadosRiver++;
            }
        }
        return partidosGanadosRiver;
    }
    
    public int getGolesBoca(){
        int golesBoca = 0;
        for(int i = 0;i < 325;i++){
            if(vector[i].getLocal() == "Boca"){
                golesBoca += vector[i].getGolesLocal();
            }
        }
        return golesBoca;
    }
    
    public double getPorcentajeEmpate(){
        int cantEmpate = 0;
        double porcentajeEmpate = 0;
        for(int i = 0;i < 325; i++){
            if(vector[i].getGolesLocal() == vector[i].getGolesVisitante()){
                cantEmpate++;
            }
        }
        porcentajeEmpate = (cantEmpate/325)*100;
        return porcentajeEmpate;
    }
}
 