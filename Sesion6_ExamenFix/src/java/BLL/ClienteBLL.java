package BLL;

import DAO.ClienteDAO;
import DAO.Conexion_DB;
import Entidad.Cliente;
import Entidad.Exceptions.ProgException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ClienteBLL {

    public Cliente validaCliente(Cliente _cliente) throws Exception {
        Connection _con = null;
        Cliente _clienteObtenido = null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO = new ClienteDAO();
        _clienteObtenido = _clienteDAO.findByNick(_con, _cliente);//Recuperamos los clientes        
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        if ((_clienteObtenido == null)
                || (!_clienteObtenido.getPassword().equals(_cliente.getPassword()))) {
            throw new ProgException("Usuario o clave incorrectas");
        }
        return _clienteObtenido;
    }

    public Cliente findByDNI(Cliente _cliente) throws Exception {
        Connection _con = null;
        Cliente _clienteObtenido = null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO = new ClienteDAO();
        _clienteObtenido = _clienteDAO.findByDNI(_con, _cliente);//Recuperamos los clientes
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteObtenido;
    }

    public Cliente findByNick(Cliente _cliente) throws Exception {
        Connection _con = null;
        Cliente _clienteObtenido = null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO = new ClienteDAO();
        _clienteObtenido = _clienteDAO.findByNick(_con, _cliente);//Recuperamos los clientes
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteObtenido;
    }

    public List<Cliente> listaClientes() throws Exception {

        Connection _con = null;
        List<Cliente> _listado = new ArrayList();
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();

        ClienteDAO _clienteDAO = new ClienteDAO();
        _listado = _clienteDAO.findAll(_con);

        _conexion_DB.CerrarConexion(_con);

        return _listado;
    }

    public Cliente listadoFacturas(Cliente cliente) throws Exception {

        Connection _con = null;
        Cliente _listado = new Cliente();
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();

        ClienteDAO _clienteDAO = new ClienteDAO();
        _listado = _clienteDAO.getClienteFacturas(_con, cliente);

        _conexion_DB.CerrarConexion(_con);

        return _listado;
    }

    public void crearUsuario(Cliente cliente) throws Exception {

        Connection con = null;
        Conexion_DB _conexionDB = new Conexion_DB();
        con = _conexionDB.AbrirConexion();

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.crearUsuario(con, cliente);

        _conexionDB.CerrarConexion(con);
    }

    public void borrarUsuario(Cliente cliente) throws Exception {

        Connection con = null;
        Conexion_DB _conexionDB = new Conexion_DB();
        con = _conexionDB.AbrirConexion();

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.borrarUsuario(con, cliente);

        _conexionDB.CerrarConexion(con);
    }

    public void modificarCliente(Cliente cliente) throws Exception {

        Connection con = null;
        Conexion_DB _conexionDB = new Conexion_DB();
        con = _conexionDB.AbrirConexion();

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.modificarCliente(con, cliente);

        _conexionDB.CerrarConexion(con);
    }

}
