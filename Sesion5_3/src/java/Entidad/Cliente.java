package Entidad;
import java.util.*;


public class Cliente {
private int DNI;private String Nombre;private String Apellido1;
private String Apellido2;private String Nick;private String Password;
private boolean moroso=false;
private float saldo=0;
private List<Factura> Facturas=new ArrayList();

    public int getDNI() { return DNI;  }
    public void setDNI(int DNI) { this.DNI = DNI; }
    
    public String getNombre() { return Nombre; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    
    public String getApellido1() { return Apellido1;}
    public void setApellido1(String Apellido1) {this.Apellido1 = Apellido1; }
    
    public String getApellido2() {return Apellido2; }
    public void setApellido2(String Apellido2) { this.Apellido2 = Apellido2; }
    
    public String getNick() { return Nick;}
    public void setNick(String Nick) {this.Nick = Nick;}
    
    public String getPassword() { return Password;}
    public void setPassword(String Password) {this.Password = Password;}
    
    public boolean isMoroso() {return moroso;}
    public void setMoroso(boolean moroso) {this.moroso = moroso;}

    public float getSaldo() {return saldo;}
    public void setSaldo(float saldo) {this.saldo = saldo;}

    public List<Factura> getFacturas() {
        return Facturas;
    }

    public void setFacturas(List<Factura> Facturas) {
        this.Facturas = Facturas;
    }
    
}
