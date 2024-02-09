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

    public void crearUsuario(Connection con, Cliente cliente) throws Exception {
        PreparedStatement sentencia = null;
        try {
            sentencia = con.prepareStatement("INSERT INTO cliente (DNI,Nombre,Ape1,Ape2,Nick,Passwd,Saldo,Moroso) VALUES(?,?,?,?,?,?,?,false)");
            sentencia.setInt(1, cliente.getDNI());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido1());
            sentencia.setString(4, cliente.getApellido2());
            sentencia.setString(5, cliente.getNick());
            sentencia.setString(6, cliente.getPassword());
            sentencia.setFloat(7, cliente.getSaldo());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al registrar al cliente " + ex.getMessage());
        } finally {
            if (sentencia != null) {
                sentencia.close();
            }
        }
    }

    private void obtenClienteFila(ResultSet rs, Cliente cliente) throws SQLException {
        cliente.setDNI(rs.getInt("DNI"));
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setApellido1(rs.getString("Ape1"));
        cliente.setApellido2(rs.getString("Ape2"));
        cliente.setNick(rs.getString("Nick"));
        cliente.setPassword(rs.getString("Passwd"));
        cliente.setSaldo(rs.getFloat("Saldo"));
        if (rs.getInt("Moroso") == 0) {
            cliente.setMoroso(false);
        } else {
            cliente.setMoroso(true);
        }
    }

    public Cliente findByNick(Connection con, Cliente cliente) throws Exception {
        Cliente _cliente = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE Nick=?");
            stmt.setString(1, cliente.getNick());
            rs = stmt.executeQuery();
            while (rs.next()) {
                _cliente = new Cliente();
                obtenClienteFila(rs, _cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el cliente por Nick " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); //Cerramos el resulset
            }
            if (stmt != null) {
                stmt.close();//Cerramos el Statement 
            }
        }
        return _cliente;
    }

    public Cliente findByDNI(Connection con, Cliente cliente) throws Exception {
        Cliente _cliente = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE DNI=?");
            stmt.setInt(1, cliente.getDNI());
            rs = stmt.executeQuery();
            while (rs.next()) {
                _cliente = new Cliente();
                obtenClienteFila(rs, _cliente);
            }
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar el cliente por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); //Cerramos el resulset
            }
            if (stmt != null) {
                stmt.close();//Cerramos el Statement 
            }
        }
        return _cliente;
    }

    public List<Cliente> findAll(Connection con) throws Exception {
        List<Cliente> _listaClientes = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            Cliente _cliente = null;
            while (rs.next()) {
                _cliente = new Cliente();
                obtenClienteFila(rs, _cliente);
                _listaClientes.add(_cliente);
            }
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar los clientes " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); //Cerramos el resulset
            }
            if (stmt != null) {
                stmt.close();//Cerramos el Statement 
            }
        }
        return _listaClientes;
    }

    public Cliente getClienteFacturas(Connection con, Cliente cliente) throws Exception {
        ResultSet rs = null;
        PreparedStatement sentencia = null;
        List facturasCorregido = new ArrayList();
        try {
            sentencia = con.prepareStatement("SELECT f.idFactura, f.Fecha FROM  factura f WHERE f.Cliente_DNI=?");
            sentencia.setInt(1, cliente.getDNI());
            rs = sentencia.executeQuery();

            while (rs.next()) {
                Factura _factura = new Factura();
                _factura.setId(rs.getInt("idFactura"));
                _factura.setFecha(rs.getInt("Fecha"));
                facturasCorregido.add(_factura);
            }
            cliente.setFacturas(facturasCorregido);
        } catch (SQLException ex) {
            Log.getInstance().error(ex);
            throw new Exception("Ha habido un problema al buscar el cliente por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); //Cerramos el resulset
            }
            if (sentencia != null) {
                sentencia.close();//Cerramos el Statement
            }
        }
        return cliente;
    }

    public void updateSaldo(Connection con, Cliente cliente) throws Exception {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Cliente SET Saldo=? WHERE DNI=?");

            stmt.setFloat(1, cliente.getSaldo());
            stmt.setInt(2, cliente.getDNI());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al actualizar el Saldo del cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();//Cerramos el Statement 
            }
        }
    }

    public void borrarUsuario(Connection con, Cliente cliente) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE Nick=?");

            stmt.setString(1, cliente.getNick());
            System.out.println(cliente.getNick());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al borrar el usuario " + ex.getMessage());

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void modificarCliente(Connection con, Cliente cliente) throws Exception {
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE cliente SET Nombre=?,Ape1=?,Ape2=?,Nick=?,Passwd=?,Saldo=? WHERE cliente.DNI = ?");

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getNick());
            stmt.setString(5, cliente.getPassword());
            stmt.setFloat(6, cliente.getSaldo());
            stmt.setInt(7, cliente.getDNI());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al modificar el usuario " + ex.getMessage());

        } finally {

            if (stmt != null) {
                stmt.close();
            }
        }
    }

}
