package Entidad;

import java.util.ArrayList;

public class Factura {

  private int Id;
  private int Fecha;
  private ArrayList<Articulo> articulos = new ArrayList();

  public Factura() {}

  public Factura(int Id, int Fecha) {
    this.Id = Id;
    this.Fecha = Fecha;
  }
  
  public Factura(int Id, int Fecha, ArrayList<Articulo> articulos) {
    this.Id = Id;
    this.Fecha = Fecha;
    this.articulos = articulos;
  }

  public int getId() {
    return Id;
  }

  public void setId(int Id) {
    this.Id = Id;
  }

  public int getFecha() {
    return Fecha;
  }

  public void setFecha(int Fecha) {
    this.Fecha = Fecha;
  }

  public ArrayList<Articulo> getArticulos() {
    return articulos;
  }

  public void setArticulos(ArrayList<Articulo> articulos) {
    this.articulos = articulos;
  }

  @Override
  public String toString() {
    return "Factura{" + "Id=" + Id + ", "
      + "Fecha=" + Fecha + ", "
      + "articulos=" + articulos + '}';
  }
}
