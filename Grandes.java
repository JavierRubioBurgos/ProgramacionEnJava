import java.util.Scanner;
import java.util.ArrayList;

public class Grandes extends Productores{
    private Tierra[] tierras;
    private ListaProductos listaproductos;
    
public Grandes(String nombre,int dianacimiento,int mesnacimiento,int añonacimiento,String dni,int numerotierras){
        super(nombre,dianacimiento,mesnacimiento,añonacimiento,dni,numerotierras);
        Scanner scanner= new Scanner(System.in);
        tierras= new Tierra[numerotierras];
        listaproductos= new ListaProductos();
        
        for(int i=0; i<numerotierras; i++){
        System.out.println("Introduce los datos de la tierra " +(i+1));
        System.out.print("Hectáreas en kilómetros: ");
        float hectáreas = scanner.nextFloat();
        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.next().trim().toLowerCase();
            Producto producto;
            if (listaproductos.contieneProducto(new Producto(nombreProducto, false, 0))) {
                producto = listaproductos.getProducto(nombreProducto);
            } else {
                boolean perecedero = generarTipoPerecedero();
                float precioKg = generarPrecioKg();
                producto = new Producto(nombreProducto, perecedero, precioKg);
                listaproductos.añadirProducto(producto);
            }
        System.out.print("Rendimiento en porcentaje: ");
        float rendimiento = scanner.nextFloat();
        Tierra tierra = new Tierra(hectáreas,producto,rendimiento);
        tierras[i] = tierra;   
    }
}
private boolean generarTipoPerecedero() {
        // Generar aleatoriamente el tipo de perecedero (50% de probabilidad)
        return Math.random() < 0.5;
    }
private float generarPrecioKg() {
        // Generar aleatoriamente el precio por kg (rango de 1 a 10)
        return (float) (1 + Math.random() * 9);
    }
public void getTierras() {
    System.out.println("Tierras:");
    System.out.println("-------------------");
    System.out.println("| Número | Hectáreas | Producto | Rendimiento |");
    System.out.println("-------------------");
    
    for (int i = 0; i < tierras.length; i++) {
        Tierra tierra = tierras[i];
        System.out.printf("|   %2d   |   %.2f   |   %s   |   %.2f   |\n", (i + 1), tierra.getHectáreas(), tierra.getProducto(), tierra.getRendimiento());
    }
    
    System.out.println("-------------------");
}  
 public void crearTierra(Scanner scanner) {
    System.out.println("Introduce los datos de la nueva tierra:");
    System.out.print("Hectáreas en kilómetros:");
    float hectáreas = scanner.nextFloat();
    System.out.print("Nombre del producto: ");
    String nombreProducto = scanner.next().trim().toLowerCase();
            Producto producto;
            if (listaproductos.contieneProducto(new Producto(nombreProducto, false, 0))) {
                producto = listaproductos.getProducto(nombreProducto);
            } else {
                boolean perecedero = generarTipoPerecedero();
                float precioKg = generarPrecioKg();
                producto = new Producto(nombreProducto, perecedero, precioKg);
                listaproductos.añadirProducto(producto);
            }
    System.out.print("Rendimiento por hectárea: ");
    float rendimiento = scanner.nextFloat();
    Tierra nuevaTierra = new Tierra(hectáreas, producto, rendimiento);
    tierras[tierras.length - 1] = nuevaTierra;
    System.out.println("Tierra creada exitosamente.");
}
public void eliminarTierra(Scanner scanner) {
    System.out.println("Seleccione el número de la tierra que desea eliminar:");
    getTierras();
    int numeroTierra = scanner.nextInt();
        
    // Verificar si el número de tierra es válido
    if (numeroTierra >= 1 && numeroTierra <= tierras.length) {
        // Eliminar la tierra del arreglo
        Tierra[] nuevasTierras = new Tierra[tierras.length - 1];
        int index = 0;
        for (int i = 0; i < tierras.length; i++) {
            if (i != (numeroTierra - 1)) {
                 nuevasTierras[index] = tierras[i];
                index++;
            }
        }
        tierras = nuevasTierras;
        System.out.println("Tierra eliminada exitosamente.");
        } else {
            System.out.println("Número de tierra inválido. Inténtelo nuevamente.");
        }
    }    

}


