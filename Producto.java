import java.util.Random;
public class Producto
{
private String nombre;
private boolean Perecedero;
private float precioKg;
private Random random;
public Producto(String nombre,boolean Perecedero,float precioKg){   
random = new Random();
this.nombre=nombre;
this.Perecedero=Perecedero;
this.precioKg=generarPrecio();  
}
private float generarPrecio() {
        return random.nextFloat(3);
    }
public String getNombre() {
        return nombre;
    }
public float getPrecioKg() {
        return precioKg;
    }
public boolean getPerecedero() {
        return Perecedero;
    }
}
