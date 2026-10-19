public class BalanzaComercial
{
    private double total;
    private int cantidad;

    public BalanzaComercial(){
    }
    
    public void registrarProducto(double pesoKg,double precioKg){
        double aux = pesoKg * precioKg;
        total += aux;
        cantidad ++;
    }
    
    public double montoAPagar(){
        return total;
    }
    
    public String resumenDeCompra(){
        String aux = "Total a pagar " + total + " Por la compra de " + cantidad + " Productos";
        
        return aux;
    }
}