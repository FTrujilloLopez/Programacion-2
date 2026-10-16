import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
        Carga palabras = new Carga();
        palabras.setAlmacenarPalabras();
        System.out.println("Mensaje oculto: " + palabras.toString());
    }
}