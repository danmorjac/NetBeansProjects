package DAO;

import Entidad.Utilidad.Log;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_DB {

  private final int ROLLBACK = 0;
  private final int COMMIT = 1;
  private Connection connection = null;

  public Connection abrirConexion() throws Exception {
    try {
      // Cargar el driver
      Class.forName("com.mysql.jdbc.Driver");

      // Establecer la conexion sin auto commit
      String urlOdbc = "jdbc:mysql://localhost:3306/clientesdb";
      this.connection
        = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
      this.connection.setAutoCommit(false);

      // Devolver la conexion
      return this.connection;
    } catch (SQLException e) {
      Log.getInstance().error(e);
      this.closeWithRollback();
      throw new Exception(
        "Ha sido imposible establecer la conexion"
        + e.getMessage()
      );
    } catch (ClassNotFoundException e) {
      Log.getInstance().error(e);
      this.closeWithRollback();
      throw new Exception(
        "No se puede cargar el Driver de la Base de Datos"
        + e.getMessage()
      );
    }
  }

  public void closeWithRollback() {
    try {
      this.close(ROLLBACK);
    } catch (Exception ex) {
      Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void closeWithCommit() {
    try {
      this.close(COMMIT);
    } catch (Exception ex) {
      Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void close(int type) throws Exception {
    if (this.connection != null) {
      switch (type) {
        case ROLLBACK:
          this.connection.rollback();
          break;
        case COMMIT:
          this.connection.commit();
          break;
        default:
          throw new Exception("Operacion no permitida");
      }
      this.connection.close();
    }
  }
}
