public class Tierra
{
private float hectáreas;
private Producto producto;
private float rendimiento;

public Tierra(float hectáreas,Producto producto, float rendimiento){
    this.hectáreas=hectáreas;
    this.producto=producto;
    this.rendimiento=rendimiento;   
}
public float getHectáreas() {
        return hectáreas;
    }
public Producto getProducto() {
        return producto;
    }
public float getRendimiento() {
        return rendimiento;
    }
}