import java.util.Scanner;
public class Ejercicio6
{
    public static void main(String[] args){
       int[][] tabla = new int[10][10];
       int numeroPar = 0;
       int suma = 0;
       int[] vector = new int[10];
       int i,j;
       for (i = 0; i<10; i++){
           for (j = 0; j<10; j++){
               tabla[i][j] = numeroPar;
               numeroPar += 2;
            }
       }
       Scanner in = new Scanner(System.in);
       System.out.println("Ingresar numero a buscar: ");
       int num = in.nextInt();
       in.close();
       boolean elemento = false;
       int fila = 0;
       int columna = 0;
       for (i = 0; i<10; i++){
           for (j = 0; j<10; j++){
             System.out.println("Fila: " + i + " Columna: " + j + " : " + tabla[i][j]);
             if((i>=2 && i<=9) && (j>=0 && j<=3)){
                  suma += tabla[i][j];
             }
             
             if(num == tabla[i][j]){
                 elemento = true;
                 fila = i;
                 columna = j;
             }
             vector[j] += tabla[i][j];   
           }
       }
       
       if(elemento){
            System.out.println("Se encontro, Fila: " + fila + " Columna: " + columna);
       }else{
            System.out.println("No se encontro el elemento");
       }
       System.out.println("Suma total de filas 2 a 9 y columnas 0 a 3: " + suma);
       }
       
}

    