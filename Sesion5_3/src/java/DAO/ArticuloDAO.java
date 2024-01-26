/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ArticuloDAO {
public Articulo updateStock(Connection con,Articulo articulo) throws Exception
{   PreparedStatement stmt=null;
    try {                         
            stmt = con.prepareStatement("UPDATE Articulo set stock=? where idArticulo=?");
            stmt.setInt(1,articulo.getStock());
            stmt.setInt(2,articulo.getIdArticulo());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el stock "+ex.getMessage());
        } finally
        {
            if (stmt != null) stmt.close();//Cerramos el Statement
        }    
        return articulo;
}       

public Articulo findById(Connection con,Articulo articulo) throws Exception
{
    Articulo _articulo=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
    try {
                        
            stmt = con.prepareStatement("SELECT * FROM articulo WHERE idArticulo=?");
            stmt.setInt(1,articulo.getIdArticulo());
            rs =stmt.executeQuery();
            while (rs.next()) {
                _articulo=new Articulo();
               obtenArticuloFila(rs,_articulo);            
            }                     
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el articulo por id "+ex.getMessage());
        }finally
        {
            if (rs != null) rs.close(); //Cerramos el resulset
            if (stmt != null) stmt.close();//Cerramos el Statement   
        }
    return _articulo;
}

private void obtenArticuloFila(ResultSet rs,Articulo articulo) throws SQLException
{
               articulo.setIdArticulo(rs.getInt("idArticulo"));
               articulo.setDescripcion(rs.getString("Descripcion"));
               articulo.setPrecio(rs.getFloat("Precio")); 
               articulo.setStock(rs.getInt("Stock")); 
 
}
}
