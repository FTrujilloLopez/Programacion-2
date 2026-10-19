public class Triangulo
{
    private double l1;
    private double l2;
    private double l3;
    private String cRelleno;
    private String cLinea;
    //Constructor//
    public Triangulo(double l1,double l2,double l3,String cRelleno,String cLinea)
    {
      this.l1 = l1;
      this.l2 = l2;
      this.l3 = l3;
      this.cRelleno = cRelleno;
      this.cLinea = cLinea;
    }

    public double getLado1(){
        return l1;
    }
    
    public double getLado2(){
        return l2;
    }
    
    public double getLado3(){
        return l3;
    }
    
    public String getColorRelleno()
    {
     return cRelleno;   
    }
    
    public String getColorLinea()
    {
     return cLinea;   
    }
    
    public void setLado1(double lado){
        l1 = lado;
    }
    
    public void setLado2(double lado){
        l2 = lado;
    }
    
    public void setLado3(double lado){
        l3 = lado;
    }
    
    public void setColorRelleno(String color){
        cRelleno = color;
    }
    
    public void setColorLinea(String color){
        cLinea = color;
    }
    
    public double calcularArea(){
        double s = (l1+l2+l3)/2.0;
        double aux = Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
        
        return aux;
    }
    
    public double calcularPerimetro(){
        double aux = l1 + l2 + l3;
        
        return aux;
    }
}
