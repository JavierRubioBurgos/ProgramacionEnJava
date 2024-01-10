
public class Logística {
    private String nomEmpresa;
    private float saldo;

    public Logística(String nomEmpresa, float saldo) {
        this.nomEmpresa = nomEmpresa;
        this.saldo = saldo;
    }
    public String getNombre() {
        return nomEmpresa;
    }
    public float getSaldo() {
        return saldo;
    }

    public void setNombre(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public void recibirDinero(float cantidad) {
        saldo += cantidad;
    }
}