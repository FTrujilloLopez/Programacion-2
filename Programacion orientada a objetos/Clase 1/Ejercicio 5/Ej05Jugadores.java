import java.util.Scanner;
public class Ej05Jugadores
{
    public static void main(String[] args)
    {
        //Paso 1: Declarar la variable vector de alturas
        //Paso 4: Crear el vector para 15 valores
        double[] alturas = new double[15];
        //Paso 2: Declarar indice y promedio (iniciarlo)
        int i;
        //Paso 3: Declarar y crear el scanner
        Scanner in = new Scanner(System.in);
        
        //Paso 5: Ingresar 15 numeros, cargarlos en el vector, ir calculando la suma
        double tot = 0;
        
        for (i = 0; i<15; i++){
          System.out.print("Ingresar altura " + i);
          double h = in.nextDouble(); 
          alturas[i] = h;
          tot = tot + h;
        }
        in.close();
        //Paso 6: Calcular el promedio
        double promedio = tot/15;
        //Paso 7: Recorrer el vector, contar los números que son mayores que el promedio
        int cant = 0;
        for (i = 0; i<15; i++){
            if(alturas[i] > promedio){
                cant = cant + 1;
            }
        }
        
        System.out.print("Promedio: " + promedio + "Cantidad de jugadores hMax " + cant);
    }
}
