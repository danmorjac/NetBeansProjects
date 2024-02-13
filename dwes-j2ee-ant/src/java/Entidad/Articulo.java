package Entidad;

public class Articulo {

  private int Id;
  private String Descripcion;
  private float Precio;
  private int Stock;
  private int CantidadComprada = 0;

  public Articulo() {
  }
  
  public Articulo (
    int Id, String Descripcion, int CantidadComprada, float Precio
  ) {
    this.Id = Id;
    this.Descripcion = Descripcion;
    this.CantidadComprada = CantidadComprada;
    this.Precio = Precio;
  }

  public Articulo(int Id, String Descripcion, float Precio, int Stock) {
    this.Id = Id;
    this.Descripcion = Descripcion;
    this.Precio = Precio;
    this.Stock = Stock;
  }

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

  @Override
  public String toString() {
    return "Articulo{" + "Id=" + Id + ", "
      + "Descripcion=" + Descripcion + ", "
      + "Precio=" + Precio + ", "
      + "Stock=" + Stock + ", "
      + "CantidadComprada=" + CantidadComprada + '}';
  }
}
