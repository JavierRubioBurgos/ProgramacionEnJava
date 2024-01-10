
public class Cliente extends Persona
{   
    private float saldo;
     public Cliente(String nombre,int dianacimiento,int mesnacimiento,int añonacimiento,String dni,float saldo){
    super(nombre,dianacimiento,mesnacimiento,añonacimiento,dni);
    this.saldo=saldo;
}
public float getSaldo() {
        return saldo;
    }
public void setSaldo(float saldo){
    this.saldo=saldo;
}
}
