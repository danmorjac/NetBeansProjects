package DAO;

import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Utilidad.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {


private void obtenClienteFila(ResultSet rs,Cliente cliente) throws SQLException
{
               cliente.setDNI(rs.getInt("DNI"));
               cliente.setNombre(rs.getString("Nombre"));
               cliente.setApellido1(rs.getString("Ape1"));
               cliente.setApellido2(rs.getString("Ape2"));
               cliente.setNick(rs.getString("Nick"));
               cliente.setPassword(rs.getString("Passwd"));     
               cliente.setSaldo(rs.getFloat("Saldo")); 
               if (rs.getInt("Moroso")==0)
                   cliente.setMoroso(false);
               else
                   cliente.setMoroso(true);
}
public Cliente findByNick(Connection con,Cliente cliente) throws Exception
{
    Cliente _cliente=null;
    ResultSet rs=null;
    PreparedStatement stmt=null; 
    try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE Nick=?");
            stmt.setString(1,cliente.getNick());
            rs =stmt.executeQuery();
            while (rs.next()) {
               _cliente=new Cliente();
               obtenClienteFila(rs,_cliente);               
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el cliente por Nick "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); //Cerramos el resulset
            if (stmt != null) stmt.close();//Cerramos el Statement 
        }
    return _cliente;
}
public Cliente findByDNI(Connection con,Cliente cliente) throws Exception
{
    Cliente _cliente=null;
    ResultSet rs=null;
    PreparedStatement stmt=null; 
    try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE DNI=?");
            stmt.setInt(1,cliente.getDNI());
            rs =stmt.executeQuery();
            while (rs.next()) {
                _cliente=new Cliente();
               obtenClienteFila(rs,_cliente);            
            }
         } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar el cliente por DNI "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); //Cerramos el resulset
            if (stmt != null) stmt.close();//Cerramos el Statement 
        }
    return _cliente;
}
public List<Cliente> findAll(Connection con) throws Exception
{
    List<Cliente> _listaClientes=new ArrayList();
    ResultSet rs=null;
    PreparedStatement stmt=null; 
    try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs =stmt.executeQuery();            
            Cliente _cliente=null;
            while (rs.next()) {
               _cliente=new Cliente();
               obtenClienteFila(rs,_cliente);       
               _listaClientes.add(_cliente);
            }
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar los clientes "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); //Cerramos el resulset
            if (stmt != null) stmt.close();//Cerramos el Statement 
        }
    return _listaClientes;
}
public Cliente getClienteFacturas(Connection con,Cliente cliente) throws Exception
{
    ResultSet rs=null;
    PreparedStatement stmt=null; 
    try {
            stmt = con.prepareStatement("SELECT f.idFactura, f.Fecha " +
                    "FROM  factura f " +
                    "WHERE f.Cliente_DNI=?");
            stmt.setInt(1,cliente.getDNI());
            rs =stmt.executeQuery();
            
            while (rs.next()) {
                Factura _factura=new Factura();
                _factura.setId(rs.getInt("idFactura"));
                _factura.setFecha(rs.getInt("Fecha"));
                 cliente.getFacturas().add(_factura); 
            }
        } catch (SQLException ex) {
           Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar el cliente por DNI "+ex.getMessage());
        } finally
        {
            if (rs != null) rs.close(); //Cerramos el resulset
            if (stmt != null) stmt.close();//Cerramos el Statement 
        }
    return cliente;
}
public void updateSaldo(Connection con, Cliente cliente) throws Exception{
        PreparedStatement stmt=null; 
        try {
             stmt = con.prepareStatement("UPDATE Cliente SET Saldo=? WHERE DNI=?");
            
            stmt.setFloat(1,cliente.getSaldo());
            stmt.setInt(2,cliente.getDNI());
           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el Saldo del cliente "+ex.getMessage());
        }  finally
        {
            if (stmt != null) stmt.close();//Cerramos el Statement 
        }        
    }

        
}
