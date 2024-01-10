/*********************************************************************************************
La clase Productores es una clase,tienes que asociarte al tipo de productor, pequeño, grande y federado. 
Hay un atributo nuevo que es el de numerodetierras. Este atributo es el que dependiendo de su valor va a definir 
las características de cada tipo de productor.
*************************************************************************************************/
public class Productores extends Persona
{
 //campos de la clase Productores
 private int numerotierras;
 //constructor de la clase Productores
 public Productores(String nombre,int dianacimiento,int mesnacimiento,int añonacimiento,String dni,int numerotierras){
    super(nombre,dianacimiento,mesnacimiento,añonacimiento,dni);
    this.numerotierras=numerotierras;
}
public int getNumeroTierras() {
    return numerotierras;
}

}

