package MapaPenínsularEspaña;
import java.util.ArrayList;
public class Mapa {
    
    private ArrayList<ComunidadAutonoma> comunidadesAutonomas;
    
    public Mapa() {
        
        comunidadesAutonomas = new ArrayList<>();
     
        ArrayList<Provincia> andalucia = new ArrayList<>();
        andalucia.add(new Provincia("Almería", 60, 210));
        andalucia.add(new Provincia("Cádiz",30,100));
        andalucia.add(new Provincia("Córdoba",60,120));
        andalucia.add(new Provincia("Granada",60,180));
        andalucia.add(new Provincia("Huelva",60,40));
        andalucia.add(new Provincia("Jaén",70,160));
        andalucia.add(new Provincia("Málaga",30,140));
        andalucia.add(new Provincia("Sevilla",60,80));

        ArrayList<Provincia> aragon = new ArrayList<>();
        aragon.add(new Provincia("Huesca",270,300));
        aragon.add(new Provincia("Teruel",220,270));
        aragon.add(new Provincia("Zaragoza",270,270));

        ArrayList<Provincia> asturias = new ArrayList<>();
        asturias.add(new Provincia("Asturias",280,120));

        ArrayList<Provincia> cantabria = new ArrayList<>();
        cantabria.add(new Provincia("Cantabria",280,200));

        ArrayList<Provincia> castillaLaMancha = new ArrayList<>();
        castillaLaMancha.add(new Provincia("Albacete",110,220));
        castillaLaMancha.add(new Provincia("Ciudad Real",110,160));
        castillaLaMancha.add(new Provincia("Cuenca",160,220));
        castillaLaMancha.add(new Provincia("Guadalajara",190,220));
        castillaLaMancha.add(new Provincia("Toledo",150,160));

        ArrayList<Provincia> castillaLeon = new ArrayList<>();
        castillaLeon.add(new Provincia("Ávila",180,120));
        castillaLeon.add(new Provincia("Burgos",240,170));
        castillaLeon.add(new Provincia("León",240,100));
        castillaLeon.add(new Provincia("Palencia",240,140));
        castillaLeon.add(new Provincia("Salamanca",180,80));
        castillaLeon.add(new Provincia("Segovia",200,150));
        castillaLeon.add(new Provincia("Soria",230,200));
        castillaLeon.add(new Provincia("Valladolid",220,130));
        castillaLeon.add(new Provincia("Zamora",210,80));

        ArrayList<Provincia> cataluña = new ArrayList<>();
        cataluña.add(new Provincia("Barcelona",250,330));
        cataluña.add(new Provincia("Girona",270,350));
        cataluña.add(new Provincia("Lleida",250,320));
        cataluña.add(new Provincia("Tarragona",210,290));

        ArrayList<Provincia> madrid = new ArrayList<>();
        madrid.add(new Provincia("Madrid",180,160));

        ArrayList<Provincia> valencia = new ArrayList<>();
        valencia.add(new Provincia("Alicante",120,250));
        valencia.add(new Provincia("Castellón",200,280));
        valencia.add(new Provincia("Valencia",170,250));

        ArrayList<Provincia> extremadura = new ArrayList<>();
        extremadura.add(new Provincia("Badajoz",100,80));
        extremadura.add(new Provincia("Cáceres",140,80));

        ArrayList<Provincia> galicia = new ArrayList<>();
        galicia.add(new Provincia("La Coruña",270,30));
        galicia.add(new Provincia("Lugo",270,60));
        galicia.add(new Provincia("Pontevedra",240,30));
        galicia.add(new Provincia("Orense",240,60));
        
        ArrayList<Provincia> paisvasco = new ArrayList<>();
        paisvasco.add(new Provincia("Vizcaya",280,220));
        paisvasco.add(new Provincia("Guipúzcua",280,240));
        paisvasco.add(new Provincia("Álava",260,230));

        
        ArrayList<Provincia> larioja = new ArrayList<>();
        galicia.add(new Provincia("La Rioja",220,220));
        
        ArrayList<Provincia> navarra = new ArrayList<>();
        galicia.add(new Provincia("Navarra",270,260));
        
        ArrayList<Provincia> murcia = new ArrayList<>();
        galicia.add(new Provincia("Murcia",70,230));
        
        ArrayList<ComunidadAutonoma> comunidadesAutonomas = new ArrayList<>();
        comunidadesAutonomas.add(new ComunidadAutonoma("Andalucía", andalucia));
        comunidadesAutonomas.add(new ComunidadAutonoma("Galicia", galicia));
        comunidadesAutonomas.add(new ComunidadAutonoma("Cantabria", cantabria));
        comunidadesAutonomas.add(new ComunidadAutonoma("Asturias", asturias));
        comunidadesAutonomas.add(new ComunidadAutonoma("Aragón", aragon));
        comunidadesAutonomas.add(new ComunidadAutonoma("La Rioja", larioja));
        comunidadesAutonomas.add(new ComunidadAutonoma("Navarra", navarra));
        comunidadesAutonomas.add(new ComunidadAutonoma("Murcia", murcia));
        comunidadesAutonomas.add(new ComunidadAutonoma("País Vasco", paisvasco));
        comunidadesAutonomas.add(new ComunidadAutonoma("Extremadura", extremadura));
        comunidadesAutonomas.add(new ComunidadAutonoma("Comunidad Valenciana", valencia));
        comunidadesAutonomas.add(new ComunidadAutonoma("Comunidad de Madrid", madrid));
        comunidadesAutonomas.add(new ComunidadAutonoma("Cataluña", cataluña));
        comunidadesAutonomas.add(new ComunidadAutonoma("Castilla la Mancha", castillaLaMancha));
        comunidadesAutonomas.add(new ComunidadAutonoma("Castilla y León", castillaLeon));
        this.comunidadesAutonomas = comunidadesAutonomas;
    }
    public void mostrarProvincias() {
    for (ComunidadAutonoma comunidad : this.comunidadesAutonomas) {
        System.out.println(comunidad.getNombre() + ":");
        for (Provincia provincia : comunidad.getProvincias()) {
            System.out.println("- " + provincia.getNombre());
        }
    }
    }   
    public Provincia getProvinciaPorNombre(String nombre) {
    for (ComunidadAutonoma comunidad : this.comunidadesAutonomas) {
        for (Provincia provincia : comunidad.getProvincias()) {
            if (provincia.getNombre().equalsIgnoreCase(nombre)) {
                return provincia;
            }
        }
    }
    return null; // Si no se encuentra la provincia
    }   

    public ArrayList<Provincia> getProvincias() {
        ArrayList<Provincia> provincias = new ArrayList<>();
        for (ComunidadAutonoma comunidad : comunidadesAutonomas) {
            provincias.addAll(comunidad.getProvincias());
        }
        return provincias;
    }
    
    public double CalcularDistancia(Provincia provincia1, Provincia provincia2){
    
        double distancia= Math.sqrt(Math.pow(provincia2.getX() - provincia1.getX(), 2) +
                                 Math.pow(provincia2.getY() - provincia1.getY(), 2));
        
        return distancia;
        
    }
}