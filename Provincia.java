package MapaPenínsularEspaña;
public class Provincia
{
    private String nombre;
    private float x;
    private float y;
    
    public Provincia(String nombre, float y, float x) {
        this.nombre = nombre;
        this.y = y;
        this.x = x;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
}