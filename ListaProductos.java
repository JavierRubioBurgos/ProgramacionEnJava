import java.util.ArrayList;

public class ListaProductos {
    private ArrayList<Producto> listaProductos;

    public ListaProductos() {
        listaProductos = new ArrayList<Producto>();
    }

    public void añadirProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void verProductos() {
        for (Producto producto : listaProductos) {
            System.out.print(producto.getNombre());
            System.out.print(", ");
        }
    }
    public ArrayList<Producto> getProductos() {
        return listaProductos;
    }

    public int tamañoLista() {
        return listaProductos.size();
    }

    public boolean contieneProducto(Producto producto) {
        return listaProductos.contains(producto);
    }
    public Producto getProducto(String nombreProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null;
    }
}