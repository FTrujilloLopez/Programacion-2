import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
        //Constructor//
        Carga partidos = new Carga();
        partidos.setAlmacenarPartidos();
        System.out.print("Partidos ganados river: " + partidos.getGanoRiver());
        System.out.print("Goles anotados boca: " + partidos.getGolesBoca());
        System.out.print("Porcentaje de partidos empatados de los 325: " + partidos.getPorcentajeEmpate()+ "%");
    }
}