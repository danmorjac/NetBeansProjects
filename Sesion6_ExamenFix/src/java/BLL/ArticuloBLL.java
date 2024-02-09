package BLL;

import DAO.ArticuloDAO;
import DAO.Conexion_DB;
import Entidad.Articulo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ArticuloBLL {

  public List<Articulo> listaArticulos() throws Exception {
    Connection _con = null;
    List<Articulo> _listado = new ArrayList();
    Conexion_DB _conexion_DB = new Conexion_DB();
    _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
    ArticuloDAO _articuloDAO = new ArticuloDAO();
    _listado = _articuloDAO.findAll(_con);//Recuperamos los articulos                 
    _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */        
    return _listado;
  }
}
