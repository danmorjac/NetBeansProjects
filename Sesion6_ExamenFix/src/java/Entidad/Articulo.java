/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author victor
 */
public class Articulo {

  private int Id;
  private String Descripcion;
  private float Precio;
  private int Stock;
  private int CantidadComprada;

  public int getId() {
    return Id;
  }

  public void setId(int Id) {
    this.Id = Id;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String Descripcion) {
    this.Descripcion = Descripcion;
  }

  public float getPrecio() {
    return Precio;
  }

  public void setPrecio(float Precio) {
    this.Precio = Precio;
  }

  public int getStock() {
    return Stock;
  }

  public void setStock(int Stock) {
    this.Stock = Stock;
  }

  public int getCantidadComprada() {
    return CantidadComprada;
  }

  public void setCantidadComprada(int CantidadComprada) {
    this.CantidadComprada = CantidadComprada;
  }
}
