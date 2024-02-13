package BLL;

import DAO.ArticuloDAO;
import DAO.ClienteDAO;
import DAO.Conexion_DB;
import DAO.FacturaDAO;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Utilidad.Fechas;
import java.sql.Connection;
import java.util.ArrayList;

public class FacturaBLL {

  // Instanciar objetos
  private final Conexion_DB CON_DB = new Conexion_DB();
  private final FacturaDAO FCT_DAO = new FacturaDAO();
  private final ArticuloDAO ART_DAO = new ArticuloDAO();
  private final ClienteDAO CLI_DAO = new ClienteDAO();

  public ArrayList<Factura> findLess() throws Exception {
    Connection connection = CON_DB.abrirConexion();

    ArrayList<Factura> listaFacturas = FCT_DAO.findLess(connection);

    CON_DB.closeWithCommit();

    return listaFacturas;
  }

  public Factura findLessById(int idFactura) throws Exception {
    Connection connection = CON_DB.abrirConexion();

    Factura fct = FCT_DAO.findLessById(connection, idFactura);

    CON_DB.closeWithCommit();

    return fct;
  }

  public Factura insertFactura(int DNI) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      Factura fct = FCT_DAO.insertFactura(
        connection,
        Fechas.getInstance().getFechatoInt(),
        DNI
      );

      CON_DB.closeWithCommit();

      return fct;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public void deleteById(int idFactura) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      FCT_DAO.deleteById(connection, idFactura);

      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public ArrayList<Factura> findAll() throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      ArrayList<Factura> listaFacturas
        = FCT_DAO.findAll(connection);

      CON_DB.closeWithCommit();

      return listaFacturas;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public void getArticulosFactura(Factura factura) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      FCT_DAO.getArticulosFactura(connection, factura);

      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public ArrayList<Factura> findLessByClienteDNI(int DNI) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      ArrayList<Factura> listaFacturas = FCT_DAO.findLessByClienteDNI(
        connection,
        DNI
      );

      CON_DB.closeWithCommit();

      return listaFacturas;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public ArrayList<Factura> findAllByClienteDNI(int DNI) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      ArrayList<Factura> listaFacturas = FCT_DAO.findAllByClienteDNI(
        connection,
        DNI
      );

      CON_DB.closeWithCommit();

      return listaFacturas;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  
  public int getPropietarioFactura(int idFactura) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      int DNI = FCT_DAO.getPropietarioFactura(connection, idFactura);

      CON_DB.closeWithCommit();

      return DNI;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  
  // Usado en:
  // - Funcionalidad comprar
  public Cliente addArticuloFactura(
    int dni, 
    int idFactura,
    int idArticulo, 
    int cantidadPedida,
    boolean isNewFactura
  ) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();
      
      Cliente cli = new ClienteBLL().findByDNI(dni);
      
      if (cli.isMoroso()) throw new Exception("Usted es moroso");

      Articulo art = ART_DAO.findById(connection, idArticulo);
      int stock = art.getStock();
      if (stock < cantidadPedida) {
        throw new Exception("No queda suficiente stock");
      }
      
      float precioTotal = art.getPrecio() * cantidadPedida;
      float saldo = cli.getSaldo();
      if (saldo < precioTotal) {
        throw new Exception(
          "No tiene suficiente saldo para realizar la operación"
        );
      }
      
      // Guardar en BBDD la factura o la actualiza
      if (isNewFactura) {
        FCT_DAO.insertArticuloFactura(
          connection, idFactura, idArticulo, cantidadPedida
        );
      } else {
        int prevCantidadPedida = 
          FCT_DAO.getCantidadPedidaByFCT(connection, idFactura);
        
        FCT_DAO.updateCantidadPedida(
          connection, idFactura, idArticulo, cantidadPedida + prevCantidadPedida
        );
      }
      
      // Calcular el nuevo stock para actualizarlo en la BBDD
      int newStock = stock - cantidadPedida;
      ART_DAO.updateStock(connection, idArticulo, newStock);

      // Actualizar el saldo y la morosidad del cliente en BBDD
      float newSaldo = saldo - precioTotal;
      boolean isMoroso = newSaldo < 0;
      CLI_DAO.updateSaldo(connection, dni, newSaldo, isMoroso);
      
      // Actualizar los objetos para hacer mirror de la BBDD
      cli.setSaldo(newSaldo);
      cli.setMoroso(isMoroso);
      
      CON_DB.closeWithCommit();
      
      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new Exception(
        "No se ha podido añadir articulo a la factura "
        + e.getMessage()
      );
    }
  }
  
  // Usado en:
  // - Funcionalidad eliminar fila factura
  public Cliente removeArticuloFactura(
    int dni, 
    int idFactura,
    int idArticulo, 
    int cantidadPedida
  ) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();
      
      Cliente cli = new ClienteBLL().findByDNI(dni);

      Articulo art = ART_DAO.findById(connection, idArticulo);
      int stock = art.getStock();
      
      float precioTotal = art.getPrecio() * cantidadPedida;
      float saldo = cli.getSaldo();
      
      // Elimina en BBDD la factura
      FCT_DAO.deleteArticuloById(connection, idFactura, idArticulo);
      
      // Calcular el nuevo stock para actualizarlo en la BBDD
      int newStock = stock + cantidadPedida;
      ART_DAO.updateStock(connection, idArticulo, newStock);

      // Actualizar el saldo y la morosidad del cliente en BBDD
      float newSaldo = saldo + precioTotal;
      boolean isMoroso = newSaldo < 0;
      CLI_DAO.updateSaldo(connection, dni, newSaldo, isMoroso);
      
      // Actualizar los objetos para hacer mirror de la BBDD
      cli.setSaldo(newSaldo);
      cli.setMoroso(isMoroso);
      
      CON_DB.closeWithCommit();
      
      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new Exception(
        "No se ha podido añadir articulo a la factura "
        + e.getMessage()
      );
    }
  }

  public void deleteArticuloById(
    int idFactura,
    int idArticulo
  ) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();

      FCT_DAO.deleteArticuloById(connection, idFactura, idArticulo);

      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public Cliente deleteByIdWithRollback(int idFactura) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();
      
      int DNI = FCT_DAO.getPropietarioFactura(connection, idFactura);
      Cliente cli = CLI_DAO.findByDNI(connection, DNI);
      
      float totalPrice = FCT_DAO.getTotal(connection, idFactura);
      float newSaldo = totalPrice + cli.getSaldo();
      boolean isMoroso = newSaldo < 0;
      CLI_DAO.updateSaldo(connection, DNI, newSaldo, isMoroso);

      FCT_DAO.deleteById(connection, idFactura);
      
      cli.setMoroso(isMoroso);
      cli.setSaldo(newSaldo);

      CON_DB.closeWithCommit();
      
      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  
  public float getTotal(int idFactura) throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();
      
      float gastoTotal = FCT_DAO.getTotal(connection, idFactura);
      
      CON_DB.closeWithCommit();
      
      return gastoTotal;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  
  public Cliente getMayorGasto() throws Exception {
    try {
      Connection connection = CON_DB.abrirConexion();
      
      Cliente cli = FCT_DAO.getMayorGasto(connection);
      
      CON_DB.closeWithCommit();
      
      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
}
