package BLL;
import DAO.ArticuloDAO;
import DAO.Conexion_DB;
import Entidad.Articulo;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloBLL {

  // Instanciar objetos
  private final Conexion_DB CON_DB = new Conexion_DB();
  private final ArticuloDAO ART_DAO = new ArticuloDAO();
  public List<Articulo> findAll() throws Exception {
    // Abrimos la conexión
    Connection _con = CON_DB.abrirConexion();
    // Recuperamos los articulos
    List<Articulo> _listado = ART_DAO.findAll(_con);
    // Cerramos la conexión
    CON_DB.closeWithCommit();
    return _listado;
  }
  public Articulo findById(Articulo artToSearch) throws Exception {
    // Abrimos la conexión
    Connection _con = CON_DB.abrirConexion();
    // Recuperamos los articulos
    Articulo articulo = ART_DAO.findById(_con, artToSearch);
    // Cerramos la conexión
    CON_DB.closeWithCommit();
    return articulo;
  }
  public Articulo findById(int idArticulo) throws Exception {
    // Abrimos la conexión
    Connection _con = CON_DB.abrirConexion();
    // Recuperamos los articulos
    Articulo articulo = ART_DAO.findById(_con, idArticulo);
    // Cerramos la conexión
    CON_DB.closeWithCommit();
    return articulo;
  }
  public void updateElementById(
    Articulo artToUpdate,
    String element
  ) throws Exception {
    try {
      // Abrimos la conexión sin autocommit
      Connection _con = CON_DB.abrirConexion();
      // Ejecutar la actualizacion segun el elemento a cambiar
      ART_DAO.updateElementById(_con, artToUpdate, element);
      // Cerramos la conexión
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  public void deleteById(int artId) throws Exception {
    try {
      Connection con = CON_DB.abrirConexion();
      ART_DAO.deleteById(con, artId);
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  public void insertArticulo(
    String Descripcion, float Precio, int Stock
  ) throws Exception {
    try {
      Connection con = CON_DB.abrirConexion();
      ART_DAO.insertArticulo(con, Descripcion, Precio, Stock);
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public void updateArticulo(
   String Descripcion, float Precio, int Stock, int idArticulo
  ) throws Exception {
    try {
      Connection con = CON_DB.abrirConexion();

      ART_DAO.updateArticulo(con, Descripcion, Precio, Stock, idArticulo);

      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
}