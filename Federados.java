import java.util.Scanner;

public class Federados extends Productores {
    private Tierra tierra;

    public Federados(String nombre1, int dianacimiento1, int mesnacimiento1, int añonacimiento1, String dni1,
            String nombre2, int dianacimiento2, int mesnacimiento2, int añonacimiento2, String dni2) {
        super(nombre1, dianacimiento1, mesnacimiento1, añonacimiento1, dni1, 1);
        Scanner scanner = new Scanner(System.in);
        float hectáreas;
        do {
            System.out.println("Introduce los datos de la tierra ");
            System.out.print("Hectáreas en kilómetros: ");
            hectáreas = scanner.nextFloat();
        } while (hectáreas <= 5);
        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.next().trim().toLowerCase();
        Producto producto;
        boolean perecedero = generarTipoPerecedero();
        float precioKg = generarPrecioKg();
        producto = new Producto(nombreProducto, perecedero, precioKg);
        System.out.print("Rendimiento por hectárea: ");
        float rendimiento = scanner.nextFloat();
        tierra = new Tierra(hectáreas, producto, rendimiento);
        System.out.println("Tierra creada exitosamente.");
    } 
    private boolean generarTipoPerecedero() {
        // Generar aleatoriamente el tipo de perecedero (50% de probabilidad)
        return Math.random() < 0.5;
    }

    private float generarPrecioKg() {
        // Generar aleatoriamente el precio por kg (rango de 1 a 10)
        return (float) (1 + Math.random() * 9);
    }
    public void crearTierra() {
    if (tierra == null) {
        Scanner scanner = new Scanner(System.in);
        float hectáreas;
        do {
            System.out.println("Introduce los datos de la tierra ");
            System.out.print("Hectáreas en kilómetros: ");
            hectáreas = scanner.nextFloat();
        } while (hectáreas <= 5);
        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.next().trim().toLowerCase();
        Producto producto;
        boolean perecedero = generarTipoPerecedero();
        float precioKg = generarPrecioKg();
        producto = new Producto(nombreProducto, perecedero, precioKg);
        System.out.print("Rendimiento por hectárea: ");
        float rendimiento = scanner.nextFloat();
        tierra = new Tierra(hectáreas, producto, rendimiento);
        System.out.println("Tierra creada exitosamente.");
    } else {
        System.out.println("Ya tienes una tierra asignada.");
    }
    }

    public void eliminarTierra() {
    if (tierra == null) {
        System.out.println("No tienes una tierra asignada.");
    } else {
        tierra = null;
        System.out.println("Tierra eliminada exitosamente.");
    }
    }

    public void getTierra() {
        if (tierra == null) {
            System.out.println("No hay tierra asignada.");
        } else {
            System.out.println("Tierra asignada:");
            System.out.println("-------------------");
            System.out.println("| Hectáreas | Producto | Rendimiento |");
            System.out.println("-------------------");
            System.out.printf("|   %.2f   |   %s   |   %.2f   |\n", tierra.getHectáreas(), tierra.getProducto().getNombre(),
                    tierra.getRendimiento());
            System.out.println("-------------------");
        }
    }
}

