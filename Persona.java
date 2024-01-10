/*********************************************************************************************
La clase Persona es una clase abstracta que contiene todos los datos
de cualquier persona que forma esta cooperativa agrícola. Es una clase de la que
no se pueden crear objetos directmente para encasillar a las Personas en el rol
al que pertenezcan (Productores,Logística,Distribuidores y Consumidores).
Por lo tanto, esta clase es superclase de Productores, Logística, Distribuidores y Consumidores.
*************************************************************************************************/
public class Persona 
{   //campos de la clase persona
    private String nombre,dni;
    private int dianacimiento,mesnacimiento,añonacimiento;
    
public Persona(String nombre,int dianacimiento,int mesnacimiento,int añonacimiento,String dni){//constructor clase Persona
    this.nombre=nombre;
    this.dianacimiento=dianacimiento;
    this.mesnacimiento=mesnacimiento;
    this.añonacimiento=añonacimiento;
    this.dni=dni; 
}
//métodos de la clase persona
public String getNombre()
{
    return nombre;  //metodo get para obtener el nombre
}
public int getDianacimiento()
{
    return dianacimiento;   //metodo get para obtener el día de nacimiento
}
public int getMesnacimiento()
{
    return mesnacimiento;   //metodo get para obtener el mes de nacimiento
}
public int getAñonacimiento()
{
    return añonacimiento;   //metodo get para obtener el año de nacimiento
}
public String getDni()
{
    return dni; //metodo get para obtener el DNI
}
}
