import java.util.ArrayList;
import MapaPenínsularEspaña.Mapa;
import MapaPenínsularEspaña.Provincia;
import java.util.Scanner;
public class Menu{
    private int opción;
    private ArrayList<Pequeños> productoresPequeños;
    private ArrayList<Grandes> productoresGrandes;
    private ArrayList<Federados> productoresFederados;
    private Pequeños pequeños;
    private Grandes grandes;
    private Federados federados;
    private ArrayList<Pequeña> logísticaPerecederosPequeña;
    private ArrayList<Grande> logísticaPerecederosGrande;
    private ArrayList<NPequeña> logísticaNoPerecederosPequeña;
    private ArrayList<NGrande> logísticaNoPerecederosGrande;
    private Pequeña PequeñaPerecedera;
    private Grande GrandePerecedera;
    private NPequeña PequeñaNoPerecedera;
    private NGrande GrandeNoPerecedera;
    private Mapa mapa;
    private Provincia provincia;
    private Consumidores consumidores;
    private Distribuidores distribuidores;
    private ArrayList<Consumidores> listaconsumidores;
    private ArrayList<Distribuidores> listadistribuidores;
    public ListaProductos productosSistema;
    
    public Menu(){
        Scanner scanner= new Scanner(System.in);
        productoresPequeños = new ArrayList<>();
        productoresGrandes = new ArrayList<>();
        productoresFederados = new ArrayList<>();
        productosSistema = new ListaProductos();
        logísticaPerecederosPequeña=new ArrayList<>();
        logísticaPerecederosGrande=new ArrayList<>();
        logísticaNoPerecederosPequeña=new ArrayList<>();
        logísticaNoPerecederosGrande=new ArrayList<>();
        listaconsumidores= new ArrayList<>();
        listadistribuidores= new ArrayList<>();
        mapa=new Mapa();
        do{
        System.out.println("Bienvenido al sistema de administración de la Cooperativa Agrícola");
        System.out.println("Seleccione una opción del 1 al 5");
        System.out.println("1. Menú Productores");
        System.out.println("2. Menú Logística");
        System.out.println("3. Menú Clientes");
        System.out.println("4. Salir");
        opción= scanner.nextInt();
        scanner.nextLine();
         while (opción < 1 || opción > 4) {
                opción = scanner.nextInt();
                scanner.nextLine(); 
            }
            switch (opción) {
                case 1:
                    menuProductores(scanner);
                    break;
                case 2:
                    menuLogística(scanner);
                    break;
                case 3:
                    menuClientes(scanner);
                    break;
                case 4:
                    // Salir del programa
                    break;
            }
        } while (opción != 4);
    }

    private void menuProductores(Scanner scanner) {
        do {
            System.out.println("Seleccione una opción del 1 al 7");
            System.out.println("1. Productor Pequeño");
            System.out.println("2. Crear Productor Pequeño");
            System.out.println("3. Productor Grande");
            System.out.println("4. Crear Productor Grande");
            System.out.println("5. Productor Federado");
            System.out.println("6. Crear Productor Federado");
            System.out.println("7. Salir");
            opción = scanner.nextInt(); scanner.nextLine();
             while (opción < 1 || opción > 7) {
                opción = scanner.nextInt();
                scanner.nextLine(); // 
            }
            switch (opción) {
                case 1: // Menú Productor Pequeño
                    if (productoresPequeños.size() > 0) {
                        menuPequeños(scanner);
                    } else {
                        System.out.println("No se ha creado ningún productor pequeño.");
                    }
                    break;
                case 2: // Crear Productor Pequeño
                    crearProductorPequeño(scanner);
                    break;
                case 3:
                    menuGrandes(scanner);
                    break;
                case 4: // Crear Productor Grande
                    crearProductorGrande(scanner);
                    break;
                case 5:
                    menuFederados(scanner);
                    break;
                case 6: // Crear Productor Federado
                    crearProductorFederado(scanner);
                    break;
                case 7:
                    // Salir del menú Productores
                    break;
            }
        } while (opción != 7);
    }
    private void menuPequeños(Scanner scanner) {
       System.out.println("Seleccione el número de productor pequeño:");

        for (int i = 0; i < productoresPequeños.size(); i++) {
            System.out.println((i + 1) + ". " + productoresPequeños.get(i).getNombre());
        }

        System.out.println((productoresPequeños.size() + 1) + ". Volver al menú anterior");

        int opcionProductor = scanner.nextInt(); scanner.nextLine();

        while (opcionProductor < 1 || opcionProductor > productoresPequeños.size() + 1) {
            System.out.println("Opción inválida. Seleccione el número de productor pequeño o vuelva al menú anterior:");
            opcionProductor = scanner.nextInt();
        }

        if (opcionProductor == productoresPequeños.size() + 1) {
            return;
        }

        Pequeños productor = productoresPequeños.get(opcionProductor - 1);
        interactuarProductorPequeño(productor, scanner);
    }
    private void menuGrandes(Scanner scanner) {
       System.out.println("Seleccione el número de productor grande:");

        for (int i = 0; i < productoresGrandes.size(); i++) {
            System.out.println((i + 1) + ". " + productoresGrandes.get(i).getNombre());
        }

        System.out.println((productoresGrandes.size() + 1) + ". Volver al menú anterior");

        int opcionProductor = scanner.nextInt(); scanner.nextLine();

        while (opcionProductor < 1 || opcionProductor > productoresGrandes.size() + 1) {
            System.out.println("Opción inválida. Seleccione el número de productor pequeño o vuelva al menú anterior:");
            opcionProductor = scanner.nextInt();
        }

        if (opcionProductor == productoresGrandes.size() + 1) {
            return;
        }

        Grandes productor = productoresGrandes.get(opcionProductor - 1);
        interactuarProductorGrande(productor, scanner);
    }
    
    private void menuFederados(Scanner scanner) {
       System.out.println("Seleccione el número de productor federado:");

        for (int i = 0; i < productoresFederados.size(); i++) {
            System.out.println((i + 1) + ". " + productoresFederados.get(i).getNombre());
        }

        System.out.println((productoresFederados.size() + 1) + ". Volver al menú anterior");

        int opcionProductor = scanner.nextInt(); scanner.nextLine();

        while (opcionProductor < 1 || opcionProductor > productoresFederados.size() + 1) {
            System.out.println("Opción inválida. Seleccione el número de productor pequeño o vuelva al menú anterior:");
            opcionProductor = scanner.nextInt(); scanner.nextLine();
        }

        if (opcionProductor == productoresFederados.size() + 1) {
            return;
        }

        Federados productor = productoresFederados.get(opcionProductor - 1);
        interactuarProductorFederados(productor, scanner);
    }
    private void interactuarProductorPequeño(Pequeños productor, Scanner scanner) {
        System.out.println("Nombre: " + productor.getNombre());
        System.out.println("DNI: " + productor.getDni());
        System.out.println("Fecha de nacimiento: " + productor.getDianacimiento() + "/" + productor.getMesnacimiento() + "/" + productor.getAñonacimiento());
        productor.getTierras();
        boolean salir = false;

    while (!salir) {
        System.out.println("--------- Menú de Tierras ---------");
        System.out.println("1. Añadir tierra");
        System.out.println("2. Eliminar tierra");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                productor.crearTierra(scanner);
                break;
            case 2:
                productor.eliminarTierra(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void interactuarProductorGrande(Grandes productor, Scanner scanner) {
        System.out.println("Nombre: " + productor.getNombre());
        System.out.println("DNI: " + productor.getDni());
        System.out.println("Fecha de nacimiento: " + productor.getDianacimiento() + "/" + productor.getMesnacimiento() + "/" + productor.getAñonacimiento());
        productor.getTierras();
        boolean salir = false;

    while (!salir) {
        System.out.println("--------- Menú de Tierras ---------");
        System.out.println("1. Añadir tierra");
        System.out.println("2. Eliminar tierra");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                productor.crearTierra(scanner);
                break;
            case 2:
                productor.eliminarTierra(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void interactuarProductorFederados(Federados productor, Scanner scanner) {
    System.out.println("Nombre: " + productor.getNombre());
    System.out.println("DNI: " + productor.getDni());
    System.out.println("Fecha de nacimiento: " + productor.getDianacimiento() + "/" + productor.getMesnacimiento() + "/" + productor.getAñonacimiento());
    productor.getTierra();
    boolean salir = false;

    while (!salir) {
        System.out.println("--------- Menú de Tierras ---------");
        System.out.println("1. Añadir tierra");
        System.out.println("2. Eliminar tierra");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                productor.crearTierra();
                break;
            case 2:
                productor.eliminarTierra();
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void crearProductorPequeño(Scanner scanner){
    System.out.println("Ingrese el nombre del productor pequeño: ");
    String nombre = scanner.nextLine();
    System.out.println("Ingrese el día de nacimiento del productor pequeño: ");
    int dianacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingrese el mes de nacimiento del productor pequeño: ");
    int mesnacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingrese el año de nacimiento del productor pequeño: ");
    int añonacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingrese el DNI del productor pequeño: ");
    String dni = scanner.nextLine();
    System.out.println("Ingrese el número de tierras del productor pequeño: ");
    int numerotierras = scanner.nextInt();
    scanner.nextLine();
    
    Pequeños nuevoProductor = new Pequeños(nombre, dianacimiento, mesnacimiento, añonacimiento, dni, numerotierras);
    productoresPequeños.add(nuevoProductor);
}
private void crearProductorGrande(Scanner scanner){
    System.out.print("Ingrese el nombre del productor grande: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el día de nacimiento del productor grande: ");
    int dianacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el mes de nacimiento del productor grande: ");
    int mesnacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el año de nacimiento del productor grande: ");
    int añonacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el DNI del productor grande ");
    String dni = scanner.nextLine();
    System.out.print("Ingrese el número de tierras del productor grande: ");
    int numerotierras = scanner.nextInt();
    scanner.nextLine();
    Grandes nuevoProductor = new Grandes(nombre,dianacimiento,mesnacimiento,añonacimiento,dni,numerotierras);
    productoresGrandes.add(nuevoProductor);
}
private void crearProductorFederado(Scanner scanner){
    System.out.print("Ingrese el nombre del productor federado 1: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el día de nacimiento del productor federado 1: ");
    int dianacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el mes de nacimiento del productor federado 1: ");
    int mesnacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el año de nacimiento del productor federado 1: ");
    int añonacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el DNI del productor federado 1 ");
    String dni = scanner.nextLine();
    System.out.print("Ingrese el nombre del productor federado 2: ");
    String nombre2 = scanner.nextLine();
    System.out.print("Ingrese el día de nacimiento del productor federado 2: ");
    int dianacimiento2 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el mes de nacimiento del productor federado 2: ");
    int mesnacimiento2 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el año de nacimiento del productor federado 2: ");
    int añonacimiento2 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el DNI del productor federado 2");
    String dni2 = scanner.nextLine();

    Federados nuevoProductor = new Federados(nombre,dianacimiento,mesnacimiento,añonacimiento,dni,nombre2,dianacimiento2,mesnacimiento2,añonacimiento2,dni2);
    productoresFederados.add(nuevoProductor);
}
private void menuLogística(Scanner scanner){
        boolean salir=false;
        while (!salir) {
        System.out.println("Seleccione una opción del 1 al 5");
        System.out.println("1. Logística Pequeña de Perecederos");
        System.out.println("2. Logística Grande de Perecederos");
        System.out.println("3. Logística Pequeña de No perecederos");
        System.out.println("4. Logística Grande de No perecederos");
        System.out.println("5. Salir");
        opción = scanner.nextInt();
         scanner.nextLine();
            switch (opción) {
                case 1: // Menú Logística Pequeña de Perecederos
                logisticaPequeñaPerecederos(scanner);
                break;
                case 2: // Menú Logística Grande de Perecederos
                logisticaGrandePerecederos(scanner);
                break;
                case 3: //Menú Logística Pequeña de No Perecederos
                logisticaPequeñaNoPerecederos(scanner);
                break;
                case 4: //Menú Logística Grande de No Perecederos
                logisticaGrandeNoPerecederos(scanner);
                break;
                case 5:
                salir=true;
                break;
                default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
            }
        } 
}
private void logisticaPequeñaPerecederos(Scanner scanner){
    boolean salir=false;    
    while (!salir) {
        System.out.println("1. Crear empresa Logística Pequeña de Perecederos");
        System.out.println("2. Eliminar empresa Logística Pequeña de Perecederos");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearPequeñaPerecederos(scanner);
                break;
            case 2:
                eliminarPequeñaPerecederos(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void logisticaGrandePerecederos(Scanner scanner){
    boolean salir=false;
    while (!salir) {
        System.out.println("1. Crear empresa Logística Grande de Perecederos");
        System.out.println("2. Eliminar empresa Logística Grande de Perecederos");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearGrandePerecederos(scanner);
                break;
            case 2:
                eliminarGrandePerecederos(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void logisticaPequeñaNoPerecederos(Scanner scanner){
    boolean salir=false;
    while (!salir) {
        System.out.println("1. Crear empresa Logística Pequeña de No Perecederos");
        System.out.println("2. Eliminar empresa Logística Pequeña de No Perecederos");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearPequeñaNoPerecederos(scanner);
                break;
            case 2:
                eliminarPequeñaNoPerecederos(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void logisticaGrandeNoPerecederos(Scanner scanner){
    boolean salir=false;
    while (!salir) {
        System.out.println("1. Crear empresa Logística Grande de No Perecederos");
        System.out.println("2. Eliminar empresa Logística Grande de No Perecederos");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearGrandeNoPerecederos(scanner);
                break;
            case 2:
                eliminarGrandeNoPerecederos(scanner);
                break;
            case 3:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }
}
private void crearPequeñaPerecederos(Scanner scanner) {
    System.out.print("Ingrese el nombre de la empresa: ");
    String nomEmpresa = scanner.nextLine();
    System.out.print("Introduce el saldo de la empresa: ");
    float saldo = scanner.nextFloat();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    Pequeña pequeñaPerecedera = new Pequeña(nomEmpresa, saldo, mapa);
    pequeñaPerecedera.seleccionarUbicacion();
    Provincia ubicación = pequeñaPerecedera.getUbicacion();

    logísticaPerecederosPequeña.add(pequeñaPerecedera);
}

public void eliminarPequeñaPerecederos(Scanner scanner) {
    System.out.println("Empresas registradas:");
    for (Pequeña empresa : logísticaPerecederosPequeña) {
        System.out.println("- " + empresa.getNombreEmpresa());
    }
    System.out.println("Ingrese el nombre de la empresa a eliminar: ");
    String nombreEmpresa = scanner.nextLine();
    boolean empresaEncontrada = false;
    for (Pequeña empresa : logísticaPerecederosPequeña) {
        if (empresa != null && empresa.getNombreEmpresa().equals(nombreEmpresa)) {
            logísticaPerecederosPequeña.remove(empresa);
            System.out.println("La empresa " + nombreEmpresa + " ha sido eliminada.");
            empresaEncontrada = true;
            break;
        }
    }
    if (!empresaEncontrada) {
        System.out.println("No se encontró ninguna empresa con el nombre " + nombreEmpresa + ".");
    }
}
private void crearGrandePerecederos(Scanner scanner){
    System.out.print("Ingrese el nombre de la empresa: ");
    String nomEmpresa = scanner.nextLine();
    System.out.print("Introduce el saldo de la empresa: ");
    float saldo = scanner.nextFloat();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    Grande GrandePerecedera = new Grande(nomEmpresa, saldo, mapa);
    GrandePerecedera.seleccionarUbicacion();
    Provincia ubicación = GrandePerecedera.getUbicacion();

    logísticaPerecederosGrande.add(GrandePerecedera);
}
private void eliminarGrandePerecederos(Scanner scanner){
    System.out.println("Empresas registradas:");
    for (Grande empresa : logísticaPerecederosGrande) {
        System.out.println("- " + empresa.getNombreEmpresa());
    }
    System.out.println("Ingrese el nombre de la empresa a eliminar: ");
    String nombreEmpresa = scanner.nextLine();
    boolean empresaEncontrada = false;
    for (Grande empresa : logísticaPerecederosGrande) {
        if (empresa != null && empresa.getNombreEmpresa().equals(nombreEmpresa)) {
            logísticaPerecederosGrande.remove(empresa);
            System.out.println("La empresa " + nombreEmpresa + " ha sido eliminada.");
            empresaEncontrada = true;
            break;
        }
    }
    if (!empresaEncontrada) {
        System.out.println("No se encontró ninguna empresa con el nombre " + nombreEmpresa + ".");
    }
}
private void crearPequeñaNoPerecederos(Scanner scanner){
    System.out.print("Ingrese el nombre de la empresa: ");
    String nomEmpresa = scanner.nextLine();
    System.out.print("Introduce el saldo de la empresa: ");
    float saldo = scanner.nextFloat();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    NPequeña PequeñaNoPerecedera = new NPequeña(nomEmpresa, saldo, mapa);
    PequeñaNoPerecedera.seleccionarUbicacion();
    Provincia ubicación = PequeñaNoPerecedera.getUbicacion();

    logísticaNoPerecederosPequeña.add(PequeñaNoPerecedera);
}
private void eliminarPequeñaNoPerecederos(Scanner scanner){
    System.out.println("Empresas registradas:");
    for (NPequeña empresa : logísticaNoPerecederosPequeña) {
        System.out.println("- " + empresa.getNombreEmpresa());
    }
    System.out.println("Ingrese el nombre de la empresa a eliminar: ");
    String nombreEmpresa = scanner.nextLine();
    boolean empresaEncontrada = false;
    for (NPequeña empresa : logísticaNoPerecederosPequeña) {
        if (empresa != null && empresa.getNombreEmpresa().equals(nombreEmpresa)) {
            logísticaNoPerecederosPequeña.remove(empresa);
            System.out.println("La empresa " + nombreEmpresa + " ha sido eliminada.");
            empresaEncontrada = true;
            break;
        }
    }
    if (!empresaEncontrada) {
        System.out.println("No se encontró ninguna empresa con el nombre " + nombreEmpresa + ".");
    }
}
private void crearGrandeNoPerecederos(Scanner scanner){
    System.out.print("Ingrese el nombre de la empresa: ");
    String nomEmpresa = scanner.nextLine();
    System.out.print("Introduce el saldo de la empresa: ");
    float saldo = scanner.nextFloat();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    NGrande GrandeNoPerecedera = new NGrande(nomEmpresa, saldo, mapa);
    GrandeNoPerecedera.seleccionarUbicacion();
    Provincia ubicación = GrandeNoPerecedera.getUbicacion();

    logísticaNoPerecederosGrande.add(GrandeNoPerecedera);
}
private void eliminarGrandeNoPerecederos(Scanner scanner){
    System.out.println("Empresas registradas:");
    for (NGrande empresa : logísticaNoPerecederosGrande) {
        System.out.println("- " + empresa.getNombreEmpresa());
    }
    System.out.println("Ingrese el nombre de la empresa a eliminar: ");
    String nombreEmpresa = scanner.nextLine().toLowerCase();
    boolean empresaEncontrada = false;
    for (NGrande empresa : logísticaNoPerecederosGrande) {
        if (empresa != null && empresa.getNombreEmpresa().equals(nombreEmpresa)) {
            logísticaNoPerecederosGrande.remove(empresa);
            System.out.println("La empresa " + nombreEmpresa + " ha sido eliminada.");
            empresaEncontrada = true;
            break;
        }
    }
    if (!empresaEncontrada) {
        System.out.println("No se encontró ninguna empresa con el nombre " + nombreEmpresa + ".");
    }
}
private void menuClientes(Scanner scanner){
     boolean salir=false;
    while (!salir) {
        System.out.println("1.Menú Consumidores");
        System.out.println("2.Menú Distribuidores");
        System.out.println("3.Actualizar Precios");
        System.out.println("4. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                menuConsumidores(scanner);
                break;
            case 2:
                menuDistribuidores(scanner);
                break;
            case 3:
                
                break;
            case 4:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }   
}
private void menuConsumidores(Scanner scanner){
    boolean salir=false;
    while (!salir) {
        System.out.println("1.Crear Consumidor");
        System.out.println("2.Eliminar Consumidor");
        System.out.println("3.Hacer Pedido");
        System.out.println("4. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearConsumidor(scanner);
                break;
            case 2:
                eliminarConsumidor(scanner);
                break;
            case 3:
                hacerPedido(scanner);
                break;
            case 4:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }   
}     
private void crearConsumidor(Scanner scanner){
    System.out.print("Ingrese el nombre del consumidor: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el día de nacimiento del consumidor: ");
    int dianacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el mes de nacimiento del consumidor:");
    int mesnacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el año de nacimiento del consumidor: ");
    int añonacimiento = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el DNI del cliente: ");
    String dni = scanner.nextLine();
    scanner.nextLine();
    System.out.print("Ingrese el saldo del consumidor: ");
    Float saldo = scanner.nextFloat();
    scanner.nextLine();
    
    Consumidores nuevoconsumidor= new Consumidores(nombre,dianacimiento,mesnacimiento,añonacimiento,dni,saldo,mapa);
    nuevoconsumidor.seleccionarUbicacion();
    Provincia ubicación = nuevoconsumidor.getUbicacion();
    listaconsumidores.add(nuevoconsumidor);
}
private void eliminarConsumidor(Scanner scanner){
    System.out.println("Consumidores registrados:");
    for (Consumidores consumidores : listaconsumidores) {
        System.out.println("- " + consumidores.getNombre());
    }
    System.out.println("Ingrese el nombre del consumidor a eliminar: ");
    String nombre = scanner.nextLine().toLowerCase();
    boolean nombreEncontrado = false;
    for (Consumidores consumidores : listaconsumidores) {
        if (consumidores != null && consumidores.getNombre().equals(nombre)) {
            listaconsumidores.remove(consumidores);
            System.out.println("El consumidor " + nombre + " ha sido eliminado.");
            nombreEncontrado = true;
            break;
        }
    }
    if (!nombreEncontrado) {
        System.out.println("No se encontró ningún consumidor con el nombre " + nombre + ".");
    }
}
private void hacerPedido(Scanner scanner) {
    System.out.println("Seleccione al consumidor con el que quiere hacer el pedido:");
    for (Consumidores consumidor : listaconsumidores) {
        System.out.println("- " + consumidor.getNombre());
    }
    String nombre = scanner.nextLine().toLowerCase();

    // Buscar el consumidor seleccionado
    Consumidores consumidorEncontrado = null;
    for (Consumidores consumidor : listaconsumidores) {
        if (consumidor.getNombre().equalsIgnoreCase(nombre)) {
            consumidorEncontrado = consumidor;
            break;
        }
    }

    if (consumidorEncontrado != null) {
        System.out.println("Lista de productos:");
        for (Producto producto : productosSistema.getProductos()) {
            System.out.println("- " + producto.getNombre());
        }

        String nombreProducto = scanner.nextLine();

        // Buscar el producto seleccionado
        Producto productoSeleccionado = productosSistema.getProducto(nombreProducto);

        if (productoSeleccionado != null) {
            System.out.println("¿Cuánta cantidad en kg quiere del producto?");
            float cantidad = scanner.nextFloat();
            scanner.nextLine(); // Consumir el salto de línea

            // Realizar el pedido
            float costoTotal = productoSeleccionado.getPrecioKg() * cantidad;
            if (consumidorEncontrado.getSaldo() < costoTotal) {
                System.out.println("El consumidor no tiene suficiente dinero para realizar el pedido");
            } else {
                consumidorEncontrado.setSaldo(consumidorEncontrado.getSaldo() - costoTotal);
                System.out.println("Pedido realizado exitosamente.");
            }
        } else {
            System.out.println("No se encontró ningún producto con el nombre " + nombreProducto + ".");
        }
    } else {
        System.out.println("No se encontró ningún consumidor con el nombre " + nombre + ".");
    }
}
private void menuDistribuidores(Scanner scanner){
     boolean salir=false;
        while (!salir) {
        System.out.println("1.Crear Distribuidor");
        System.out.println("2.Eliminar Distribuidor");
        System.out.println("3.Hacer Pedido");
        System.out.println("4. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearDistribuidor(scanner);
                break;
            case 2:
                eliminarDistribuidor(scanner);
                break;
            case 3:
                hacerPedidoD(scanner);
                break;
            case 4:
                salir = true;
                break;
            default:
                System.out.println("Opción inválida. Seleccione una opción válida:");
                break;
        }
    }      
}
private void crearDistribuidor(Scanner scanner){
    System.out.print("Ingrese el nombre de la empresa: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el saldo del consumidor: ");
    Float saldo = scanner.nextFloat();
    scanner.nextLine();
    
    Distribuidores nuevodistribuidor= new Distribuidores(nombre,saldo,mapa);
    nuevodistribuidor.seleccionarUbicacion();
    Provincia ubicación = nuevodistribuidor.getUbicacion();
    listadistribuidores.add(nuevodistribuidor);
}
private void  eliminarDistribuidor(Scanner scanner){
    System.out.println("Distribuidores registrados:");
    for (Distribuidores distribuidores : listadistribuidores) {
        System.out.println("- " + distribuidores.getNombre());
    }
    System.out.println("Ingrese el nombre del consumidor a eliminar: ");
    String nombre = scanner.nextLine();
    boolean nombreEncontrado = false;
    for (Distribuidores distribuidores : listadistribuidores) {
        if (distribuidores != null && distribuidores.getNombre().equals(nombre)) {
            listadistribuidores.remove(distribuidores);
            System.out.println("El distribuidor " + nombre + " ha sido eliminado.");
            nombreEncontrado = true;
            break;
        }
    }
    if (!nombreEncontrado) {
        System.out.println("No se encontró ninguna empresa con el nombre " + nombre + ".");
    }
}
private void hacerPedidoD(Scanner scanner){
    
    
    
    
    
}

}