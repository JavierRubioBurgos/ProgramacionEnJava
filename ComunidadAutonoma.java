package MapaPenínsularEspaña;
import java.util.ArrayList;

public class ComunidadAutonoma {
    private String nombre;
    private ArrayList<Provincia> provincias;
    
    public ComunidadAutonoma(String nombre, ArrayList<Provincia> provincias) {
        this.nombre = nombre;
        this.provincias = provincias;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Provincia> getProvincias() {
        return provincias;
    }
}