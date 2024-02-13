package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDAO {

  protected PreparedStatement stmt = null;
  protected ResultSet rs = null;

  protected void clean() throws SQLException {
    if (stmt != null) {
      stmt.close();
      stmt = null;
    }
    if (rs != null) {
      rs.close();
      rs = null;
    }
  }
}
