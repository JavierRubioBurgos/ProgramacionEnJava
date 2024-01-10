import java.util.Scanner;
import java.util.ArrayList;

public class Pequeños extends Productores {
    private ArrayList<Tierra> tierras;
    private ListaProductos listaproductos;
    private float hectáreasTotales=0;
    private final int hectáreasPermitidas = 5;
    int productosDistintos = 0;
    

    public Pequeños(String nombre, int dianacimiento, int mesnacimiento, int añonacimiento, String dni, int numerotierras) {
        super(nombre, dianacimiento, mesnacimiento, añonacimiento, dni, numerotierras);
        tierras = new ArrayList<>();
        listaproductos = new ListaProductos();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numerotierras; i++) {
            System.out.println("Introduce los datos de la tierra " + (i + 1));
            float hectáreas;
            float hectáreasDisponibles = hectáreasPermitidas - hectáreasTotales;
            do {
                System.out.print("Hectáreas en kilómetros (disponibles " + hectáreasDisponibles + "): ");
                hectáreas = scanner.nextFloat();
            } while (hectáreas > hectáreasDisponibles);
            hectáreasTotales += hectáreas;

            System.out.print("Nombre del producto: ");
            String nombreProducto = scanner.next().trim().toLowerCase();
            Producto producto;

            if (listaproductos.contieneProducto(new Producto(nombreProducto, false, 0))) {
                producto = listaproductos.getProducto(nombreProducto);
            } else {
                if (listaproductos.tamañoLista() > 5) {
                    do {
                        System.out.println("Se ha alcanzado el número máximo de productos diferentes, selecciona uno de los disponibles:");
                        listaproductos.verProductos();
                        String selectedProduct = scanner.next();
                        producto = listaproductos.getProducto(selectedProduct);
                    } while (!listaproductos.contieneProducto(producto));
                } else {
                    boolean perecedero = generarTipoPerecedero();
                    float precioKg = generarPrecioKg();
                    producto = new Producto(nombreProducto, perecedero, precioKg);
                    listaproductos.añadirProducto(producto);
                }
            }

            System.out.print("Rendimiento por hectárea: ");
            float rendimiento = scanner.nextFloat();
            Tierra tierra = new Tierra(hectáreas, producto, rendimiento);
            tierras.add(tierra);
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

        for (int i = 0; i < tierras.size(); i++) {
            Tierra tierra = tierras.get(i);
            System.out.printf("|   %2d   |   %.2f   |   %s   |   %.2f   |\n", (i + 1), tierra.getHectáreas(), tierra.getProducto().getNombre(), tierra.getRendimiento());
        }

        System.out.println("-------------------");
    }

    public void crearTierra(Scanner scanner) {
        System.out.println("Introduce los datos de la nueva tierra:");
        float hectáreas;
        float hectáreasDisponibles = hectáreasPermitidas - hectáreasTotales;
        if (hectáreasDisponibles <= 0) {
        System.out.println("Se ha alcanzado el límite máximo de hectáreas.");
        return;
        }

        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.next().trim().toLowerCase();
        Producto producto;

        if (listaproductos.contieneProducto(new Producto(nombreProducto, false, 0))) {
            producto = listaproductos.getProducto(nombreProducto);
        } else {
            if (listaproductos.tamañoLista() > 5) {
                do {
                    System.out.println("Se ha alcanzado el número máximo de productos diferentes, selecciona uno de los disponibles:");
                    listaproductos.verProductos();
                    String selectedProduct = scanner.next();
                    producto = listaproductos.getProducto(selectedProduct);
                } while (!listaproductos.contieneProducto(producto));
            } else {
                boolean perecedero = generarTipoPerecedero();
                float precioKg = generarPrecioKg();
                producto = new Producto(nombreProducto, perecedero, precioKg);
                listaproductos.añadirProducto(producto);
            }
        }

        do {
             hectáreasDisponibles = hectáreasPermitidas - hectáreasTotales;
            System.out.print("Hectáreas en kilómetros (disponibles " + hectáreasDisponibles + "): ");
            hectáreas = scanner.nextFloat();
        } while (hectáreas > (hectáreasPermitidas - hectáreasTotales));

        hectáreasTotales += hectáreas;

        float rendimiento;
        System.out.print("Rendimiento por hectárea: ");
        rendimiento = scanner.nextFloat();

        Tierra nuevaTierra = new Tierra(hectáreas, producto, rendimiento);
        tierras.add(nuevaTierra);
        System.out.println("Tierra creada exitosamente.");
    }

    public void eliminarTierra(Scanner scanner) {
        System.out.println("Seleccione el número de la tierra que desea eliminar:");
        getTierras();
        int numeroTierra = scanner.nextInt();

        // Verificar si el número de tierra es válido
        if (numeroTierra >= 1 && numeroTierra <= tierras.size()) {
            // Eliminar la tierra de la lista
            tierras.remove(numeroTierra - 1);
            System.out.println("Tierra eliminada exitosamente.");
        } else {
            System.out.println("Número de tierra inválido. Inténtelo nuevamente.");
        }
    }
}
