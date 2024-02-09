/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Utilidad.Log;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class FacturaDAO {
public Factura creaFactura(Connection con, Factura factura,Cliente cliente) throws Exception
{
       PreparedStatement stmt=null;
       try {
            stmt = con.prepareStatement("INSERT INTO FACTURA(Fecha,Cliente_DNI) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,factura.getFecha());
            stmt.setInt(2,cliente.getDNI());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys ();
            rs.next();
            int key = rs.getInt(1);
            factura.setId(key);
            
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
        }finally
        {
             if (stmt != null) stmt.close();//Cerramos el Statement 
        }
       return factura;
}
public void addArticulo(Connection con,Factura factura,Articulo articulo,int numero) throws Exception
{
       PreparedStatement stmt=null;
       try {
            stmt = con.prepareStatement("INSERT INTO articulo_factura VALUES(?,?,?)");
            stmt.setInt(1,articulo.getId());
            stmt.setInt(2,factura.getId());
            stmt.setInt(3,numero);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al insertar el articulo en la factura "+ex.getMessage());
        }   finally
        {
             if (stmt != null) stmt.close();
        }    
}
public Factura getArticulosFactura(Connection con,Factura factura) throws Exception
{
    ResultSet rs=null;
    PreparedStatement stmt=null;   
    try {
            stmt = con.prepareStatement("SELECT Articulo_idArticulo, Numero, Descripcion " +
                    "FROM  articulo_factura af,articulo a " +
                    "WHERE af.Articulo_idArticulo=a.idArticulo AND af.Factura_idFactura=?");
            stmt.setInt(1,factura.getId());
            rs =stmt.executeQuery();
            
            Articulo _articulo=null;
            while (rs.next()) {
               _articulo=new Articulo();
               _articulo.setId(rs.getInt("Articulo_idArticulo"));
               _articulo.setDescripcion(rs.getString("Descripcion"));                    
               _articulo.setCantidadComprada(rs.getInt("Numero"));
               factura.getArticulos().add(_articulo);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al los articulos de la factura "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close(); 
        }
    return factura;
}
public void borrarArt (Connection con,int idFactura, int idArticulo) throws Exception
{     PreparedStatement stmt=null;                         
    try {
        //Creamos la orden MySQL para el borrado del registro
        stmt= con.prepareStatement("DELETE FROM `clientesdb`.`articulo_factura` WHERE `articulo_factura`.`Articulo_idArticulo` = ? AND `articulo_factura`.`Factura_idFactura` = ?");
        stmt.setInt(1, idArticulo);
        stmt.setInt(2, idFactura);
        stmt.executeUpdate();
           
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new Exception("Ha habido un problema al BORRAR articulo "+ex.getMessage());
    } finally
    {
        if (stmt != null) stmt.close();
    } 
}
public void borrarFactura2 (Connection con, int idFactura) throws Exception
{     PreparedStatement stmt=null;                         
    try {
        //Creamos la orden MySQL para el borrado del registro
        stmt= con.prepareStatement("DELETE FROM factura WHERE idFactura=?");
        stmt.setInt(1, idFactura);
        stmt.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al BORRAR articulo "+ex.getMessage());
        } finally
        {
            if (stmt != null) stmt.close();
        }
    
}
public void borrarLineaArticulo (Connection con,Factura factura, Articulo articulo) throws Exception
{     PreparedStatement stmt=null;                         
    try {
        //Creamos la orden MySQL para el borrado del registro
        stmt= con.prepareStatement("DELETE FROM `clientesdb`.`articulo_factura` WHERE `articulo_factura`.`Articulo_idArticulo` = ? AND `articulo_factura`.`Factura_idFactura` = ?");
        stmt.setInt(1,articulo.getId());
        stmt.setInt(2,factura.getId());
        stmt.executeUpdate();
           
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al BORRAR articulo "+ex.getMessage());
        } finally
        {
            if (stmt != null) stmt.close();
        }
     
    
}
public ArrayList<Factura> getFacturas(Connection con, Cliente cliente) throws Exception
{
    ResultSet rs=null;
    PreparedStatement stmt=null;   
    ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    try {
            stmt = con.prepareStatement("SELECT * FROM factura WHERE cliente_dni=? order by idFactura desc");
            stmt.setInt(1, cliente.getDNI());
            rs =stmt.executeQuery();
            
            
            Factura facturaProvisional;
            while (rs.next()) {
                facturaProvisional = new Factura();
                facturaProvisional.setId(rs.getInt(1));
                facturaProvisional.setFecha(rs.getInt(2));
                
                facturas.add(facturaProvisional);
            }
            
            return facturas;
         } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al los articulos de la factura "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close(); 
        }
  
}

}
