================================================================================
GUÍA COMPLETA Y PLANTILLAS DE CÓDIGO - PARCIAL POO (JAVA / BLUEJ)
================================================================================

--------------------------------------------------------------------------------
1. CHEATSHEET DE SINTAXIS BÁSICA, COMPARACIONES Y ERRORES COMUNES
--------------------------------------------------------------------------------

// Comparar Strings (SIEMPRE usar .equals o .equalsIgnoreCase, NUNCA ==)
if (texto.equals("Buscado")) { ... }
if (texto.equalsIgnoreCase("buscado")) { ... } // Ignora mayúsculas/minúsculas

// Comparar tipos primitivos (int, double, boolean, char)
if (numero == 10) { ... }
if (esActivo) { ... } // Booleano directo, no hace falta poner == true

// Porcentajes y cálculos con decimales (evitar división entera que da 0):
// INCORRECTO: valor += (valor * 10 / 100); -> trunca a 0 si opera con int
// CORRECTO:
valor += valor * 0.10;   // Aumento del 10%
valor += valor * 0.125;  // Aumento del 12.5%
valor += valor * 0.155;  // Aumento del 15.5%
valor -= valor * 0.06;   // Descuento del 6%

// Rangos numéricos inclusivos ("entre A y B inclusive")
if (cantidad >= 10 && cantidad <= 20) { ... }

// Regla de herencia en constructores:
// super(...); DEBE ser obligatoriamente la PRIMERA línea en el constructor hijo.


--------------------------------------------------------------------------------
2. CASTEOS, CONVERSIONES Y FORMATEO
--------------------------------------------------------------------------------

// Evitar división entera si trabajas con variables 'int':
int a = 5;
int b = 2;
double resultado = (double) a / b; // Da 2.5 (sin el cast daría 2.0)

// Convertir String a número
int num = Integer.parseInt("123");
double dec = Double.parseDouble("45.67");

// Convertir número a String
String str = String.valueOf(num);

// Imprimir con 2 decimales formateados
System.out.printf("Total: $%.2f\n", totalCalculado);


--------------------------------------------------------------------------------
3. CLASE DE APOYO / ELEMENTO SIMPLE (COMPOSICIÓN BÁSICA)
--------------------------------------------------------------------------------
public class ElementoSimple {
    private String nombre;
    private String detalle;
    private int cantidad;
    private boolean estado;

    public ElementoSimple(String nombre, String detalle, int cantidad, boolean estado) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getNombre() { return this.nombre; }
    public String getDetalle() { return this.detalle; }
    public int getCantidad() { return this.cantidad; }
    public boolean isEstado() { return this.estado; }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " | Detalle: " + this.detalle +
               " | Cant: " + this.cantidad + " | Estado: " + this.estado;
    }
}


--------------------------------------------------------------------------------
4. CLASE PADRE ABSTRACTA (HERENCIA, GETTERS Y POLIMORFISMO)
--------------------------------------------------------------------------------
public abstract class Padre {
    // 1. Atributos compartidos (encapsulados como private)
    private String id;
    private String fecha;
    private double valorBase;
    private ElementoSimple apoyo; // Composición

    // 2. Constructor
    public Padre(String id, String fecha, double valorBase, ElementoSimple apoyo) {
        this.id = id;
        this.fecha = fecha;
        this.valorBase = valorBase;
        this.apoyo = apoyo;
    }

    // 3. Getters necesarios para que las subclases puedan consultar datos
    public String getId() { return this.id; }
    public String getFecha() { return this.fecha; }
    public double getValorBase() { return this.valorBase; }
    public ElementoSimple getApoyo() { return this.apoyo; }

    // 4. Método abstracto: cada subclase DEBE implementarlo a su manera
    public abstract double calcularEspecifico();

    // 5. Método concreto compartido (aprovecha el abstracto sin duplicar lógica)
    public double calcularTotalFinal() {
        double subtotal = this.calcularEspecifico(); // Llamada polimórfica

        // Modificadores comunes a todas las variantes (fechas, condiciones de apoyo)
        if (this.fecha.equals("24/03/2026") || this.fecha.equals("25/05/2026") || this.fecha.equals("09/07/2026")) {
            subtotal += subtotal * 0.10;
        }

        if (this.apoyo.getCantidad() > 5) {
            subtotal += subtotal * 0.125;
        }

        if (!this.apoyo.isEstado()) {
            subtotal -= subtotal * 0.10;
        }

        return subtotal;
    }

    // 6. toString base
    @Override
    public String toString() {
        return "ID: " + this.id + " | Fecha: " + this.fecha + " | Base: $" + this.valorBase +
               " | " + this.apoyo.toString();
    }
}


--------------------------------------------------------------------------------
5. SUBCLASE CONCRETA (HERENCIA, SUPER Y COLECCIÓN PROPIA)
--------------------------------------------------------------------------------
public class HijaConVector extends Padre {
    private String nombrePropio;
    private ElementoSimple[] subElementos;
    private int cantSubElementos;

    public HijaConVector(String id, String fecha, double valorBase, ElementoSimple apoyo, String nombrePropio) {
        super(id, fecha, valorBase, apoyo); // super DEBE ser la primera línea
        this.nombrePropio = nombrePropio;
        this.subElementos = new ElementoSimple[8]; // Vector con dimensión física fija
        this.cantSubElementos = 0;                 // Dimensión lógica inicial
    }

    public void agregarSubElemento(ElementoSimple elem) {
        if (this.cantSubElementos < 8) {
            this.subElementos[this.cantSubElementos] = elem;
            this.cantSubElementos++;
        }
    }

    @Override
    public double calcularEspecifico() {
        double base = this.getValorBase();

        // Lógica particular de esta subclase
        if (this.cantSubElementos > 5) {
            base += base * 0.20;
        }

        return base * 0.50; // Porcentaje base correspondiente
    }

    @Override
    public String toString() {
        // Reutiliza los datos del padre con super.toString() y añade lo propio
        return super.toString() + " | Nombre Propio: " + this.nombrePropio +
               " | Elementos Cargados: " + this.cantSubElementos;
    }
}


--------------------------------------------------------------------------------
6. CLASE CONTENEDORA (ARREGLO ESTÁTICO, CARGA, MÁXIMO, BÚSQUEDA Y PROMEDIO)
--------------------------------------------------------------------------------
public class Administrador {
    private Padre[] elementos;
    private int dimL; // Dimensión lógica (elementos reales cargados)
    private int dimF; // Dimensión física (capacidad total reservada)

    public Administrador(int capacidadMaxima) {
        this.dimF = capacidadMaxima;
        this.elementos = new Padre[capacidadMaxima];
        this.dimL = 0; // Inicia vacío
    }

    // 1. Agregar elemento verificando cupo
    public boolean agregar(Padre nuevo) {
        if (this.dimL < this.dimF) {
            this.elementos[this.dimL] = nuevo;
            this.dimL++;
            return true;
        }
        return false; // Arreglo lleno
    }

    // 2. Calcular promedio recorriendo solo lo cargado
    public double calcularPromedio() {
        if (this.dimL == 0) return 0.0;
        double suma = 0.0;
        for (int i = 0; i < this.dimL; i++) {
            suma += this.elementos[i].calcularTotalFinal(); // Polimorfismo limpio
        }
        return suma / this.dimL;
    }

    // 3. Obtener el elemento con mayor valor (Búsqueda de Máximo)
    public Padre obtenerMaximo() {
        if (this.dimL == 0) return null;
        Padre max = this.elementos[0];
        for (int i = 1; i < this.dimL; i++) {
            if (this.elementos[i].calcularTotalFinal() > max.calcularTotalFinal()) {
                max = this.elementos[i];
            }
        }
        return max;
    }

    // 4. Búsqueda secuencial por String con corte anticipado
    public Padre buscarPorId(String idBuscado) {
        int i = 0;
        while (i < this.dimL && !this.elementos[i].getId().equals(idBuscado)) {
            i++;
        }
        if (i < this.dimL) {
            return this.elementos[i]; // Encontrado
        }
        return null; // No encontrado
    }

    // 5. Imprimir toda la colección
    @Override
    public String toString() {
        String res = "=== LISTADO DE ELEMENTOS (" + this.dimL + " REGISTRADOS) ===\n";
        for (int i = 0; i < this.dimL; i++) {
            res += this.elementos[i].toString() + "\n";
        }
        return res;
    }
}


--------------------------------------------------------------------------------
7. MATRIZ BIDIMENSIONAL (POR SI PIDEN FORMATO TABLA O GRILLA)
--------------------------------------------------------------------------------
public class MatrizContenedor {
    private Padre[][] tabla;
    private int filas;
    private int columnas;

    public MatrizContenedor(int f, int c) {
        this.filas = f;
        this.columnas = c;
        this.tabla = new Padre[f][c];
    }

    public void agregarEnPosicion(Padre p, int f, int c) {
        if (f >= 0 && f < this.filas && c >= 0 && c < this.columnas) {
            this.tabla[f][c] = p;
        }
    }

    public double calcularSumaTotal() {
        double total = 0.0;
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (this.tabla[i][j] != null) { // Verificar posiciones no vacías
                    total += this.tabla[i][j].calcularTotalFinal();
                }
            }
        }
        return total;
    }
}


--------------------------------------------------------------------------------
8. COLECCIONES DINÁMICAS (ARRAYLIST)
--------------------------------------------------------------------------------
import java.util.ArrayList;

public class EjemploListaDinamica {
    private ArrayList<Padre> lista;

    public EjemploListaDinamica() {
        this.lista = new ArrayList<Padre>();
    }

    public void agregarElemento(Padre p) {
        this.lista.add(p); // Agrega al final sin preocuparse por dimF
    }

    public double calcularPromedio() {
        if (this.lista.isEmpty()) return 0.0; // o this.lista.size() == 0
        double suma = 0.0;
        for (int i = 0; i < this.lista.size(); i++) {
            suma += this.lista.get(i).calcularTotalFinal(); // get(i) equivale a [i]
        }
        return suma / this.lista.size();
    }

    public Padre buscarElemento(String id) {
        for (Padre p : this.lista) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}


--------------------------------------------------------------------------------
9. LECTURA POR TECLADO (SCANNER) Y CORTE POR VALOR CENTINELA
--------------------------------------------------------------------------------
import java.util.Scanner;

public class EntradaDatos {
    public static void cargarConTeclado(Administrador admin) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese ID (escriba 'FIN' para salir): ");
        String id = sc.nextLine();

        while (!id.equalsIgnoreCase("FIN")) {
            System.out.print("Ingrese fecha: ");
            String fecha = sc.nextLine();

            System.out.print("Ingrese valor base: ");
            double base = sc.nextDouble();

            System.out.print("Ingrese cantidad extra: ");
            int extra = sc.nextInt();
            sc.nextLine(); // LIMPIAR EL SALTO DE LÍNEA TRAS UN NÚMERO

            // Instanciar y guardar
            ElementoSimple apoyo = new ElementoSimple("Aux", "Detalle", extra, true);
            HijaConVector nueva = new HijaConVector(id, fecha, base, apoyo, "Detalle Extra");
            admin.agregar(nueva);

            // Volver a pedir condición de corte
            System.out.print("Ingrese ID (escriba 'FIN' para salir): ");
            id = sc.nextLine();
        }
    }
}


--------------------------------------------------------------------------------
10. PROGRAMA PRINCIPAL (MAIN DE PRUEBA RÁPIDA SIN TECLADO)
--------------------------------------------------------------------------------
public class Main {
    public static void main(String[] args) {
        // 1. Instanciar clase administradora
        Administrador admin = new Administrador(30);

        // 2. Instanciar apoyos
        ElementoSimple e1 = new ElementoSimple("Empresa A", "Nacional", 6, false);
        ElementoSimple e2 = new ElementoSimple("Empresa B", "Internacional", 2, true);

        // 3. Instanciar variantes polimórficas
        HijaConVector obj1 = new HijaConVector("ID_01", "25/05/2026", 10000.0, e1, "Show 1");
        HijaConVector obj2 = new HijaConVector("ID_02", "12/11/2026", 15000.0, e2, "Show 2");

        // 4. Agregar a la colección
        admin.agregar(obj1);
        admin.agregar(obj2);

        // 5. Imprimir reportes
        System.out.println(admin.toString());
        System.out.println("Promedio: " + admin.calcularPromedio());

        Padre mayor = admin.obtenerMaximo();
        if (mayor != null) {
            System.out.println("Mayor Valor: " + mayor.getId());
        }
    }
}