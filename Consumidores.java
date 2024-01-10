import MapaPenínsularEspaña.Mapa;
import MapaPenínsularEspaña.Provincia;
import java.util.Scanner;

public class Consumidores extends Cliente
{
    private Provincia ubicación;
    private Mapa mapa;
 public Consumidores(String nombre,int dianacimiento,int mesnacimiento,int añonacimiento,String dni,float saldo,Mapa mapa){
    super(nombre,dianacimiento,mesnacimiento,añonacimiento,dni,saldo);   
    setMapa(mapa);
 }
 public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
        
  public void seleccionarUbicacion() {
        // Mostrar las provincias disponibles para que el usuario seleccione
        System.out.println("Provincias disponibles:");
        mapa.mostrarProvincias();

        // Solicitar al usuario que ingrese el nombre de la provincia de ubicación
        String nombreProvincia = obtenerNombreProvincia();

        // Obtener la instancia de la provincia del mapa
        ubicación = mapa.getProvinciaPorNombre(nombreProvincia);

        if (ubicación == null) {
            System.out.println("Provincia no encontrada. Se establecerá una ubicación predeterminada.");
            ubicación = mapa.getProvincias().get(0); // Establecer una ubicación predeterminada
        }
            }
    private String obtenerNombreProvincia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la provincia: ");
        String nombreProvincia = scanner.nextLine();
        return nombreProvincia;
    }

    public Provincia getUbicacion() {
        return ubicación;
    }
}
