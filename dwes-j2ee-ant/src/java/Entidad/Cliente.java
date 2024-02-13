package Entidad;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

  private int DNI;
  private String Nombre;
  private String Apellido1;
  private String Apellido2;
  private String Nick;
  private String Password;
  private List<Factura> Facturas = new ArrayList();
  private float saldo;
  private boolean moroso;

  public Cliente() {}
  
  public Cliente(
    int DNI,
    String Nombre,
    String Apellido1,
    String Apellido2,
    String Nick,
    String Password
  ) {
    this.DNI = DNI;
    this.Nombre = Nombre;
    this.Apellido1 = Apellido1;
    this.Apellido2 = Apellido2;
    this.Nick = Nick;
    this.Password = Password;
  }

  public Cliente(
    int DNI,
    String Nombre,
    String Apellido1,
    String Apellido2,
    String Nick,
    String Password,
    float saldo,
    boolean moroso
  ) {
    this.DNI = DNI;
    this.Nombre = Nombre;
    this.Apellido1 = Apellido1;
    this.Apellido2 = Apellido2;
    this.Nick = Nick;
    this.Password = Password;
    this.saldo = saldo;
    this.moroso = moroso;
  }

  // Dni
  public int getDNI() {
    return DNI;
  }
  public void setDNI(int DNI) {
    this.DNI = DNI;
  }

  // Nombre
  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String Nombre) {
    this.Nombre = Nombre;
  }

  // Ape 1
  public String getApellido1() {
    return Apellido1;
  }

  public void setApellido1(String Apellido1) {
    this.Apellido1 = Apellido1;
  }

  // Ape 2
  public String getApellido2() {
    return Apellido2;
  }

  public void setApellido2(String Apellido2) {
    this.Apellido2 = Apellido2;
  }

  // Nick
  public String getNick() {
    return Nick;
  }

  public void setNick(String Nick) {
    this.Nick = Nick;
  }

  // Password
  public String getPassword() {
    return Password;
  }

  public void setPassword(String Password) {
    this.Password = Password;
  }

  // Facturas
  public List<Factura> getFacturas() {
    return Facturas;
  }

  public void setFacturas(List<Factura> Facturas) {
    this.Facturas = Facturas;
  }

  // Moroso
  public boolean isMoroso() {
    return moroso;
  }

  public int getMoroso() {
    return moroso ? 1 : 0;
  }

  public void setMoroso(boolean moroso) {
    this.moroso = moroso;
  }

  // Saldo
  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public String getNombreCompuesto() {
    String _nombrecompuesto = "";
    if (Nombre != null) {
      _nombrecompuesto = _nombrecompuesto + Nombre;
    }
    if (Apellido1 != null) {
      _nombrecompuesto = _nombrecompuesto + " " + Apellido1;
    }
    if (Apellido2 != null) {
      _nombrecompuesto = _nombrecompuesto + " " + Apellido2;
    }
    return _nombrecompuesto;
  }

  @Override
  public String toString() {
    return "Cliente{" + "DNI=" + DNI + ", "
      + "Nombre=" + Nombre + ", "
      + "Apellido1=" + Apellido1 + ", "
      + "Apellido2=" + Apellido2 + ", "
      + "Nick=" + Nick + ", "
      + "Password=" + Password + ", "
      + "Facturas=" + Facturas + ", "
      + "moroso=" + moroso + ", "
      + "saldo=" + saldo + '}';
  }
}
