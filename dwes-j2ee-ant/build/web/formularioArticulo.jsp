<h1>Añade un Articulo</h1>
<form action="Controller?opID=AddArticulo" method="POST">
  Descripcion:
  <input type="text" name="Descripcion" size="80"
    placeholder="Introduce la descripcion"
  >
  <br>
  Precio:
  <input type="number" name="Precio" size="80"
    placeholder="Introduce el precio"
  >
  <br>
  Stock:
  <input type="number" name="Stock" size="80"
    placeholder="Introduce el stock"
  >
  <br>
  <input type="submit" value="Entrar">
</form>
