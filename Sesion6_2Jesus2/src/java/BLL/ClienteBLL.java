/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAO.ClienteDAO;
import DAO.Conexion_DB;
import Entidad.Cliente;
import Entidad.Exceptions.ProgException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class ClienteBLL {
    
    public Cliente insertaUsuario(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteInsertado=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteDAO.insertaUsuario(_con,_cliente);     
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteInsertado;
    }
    
    public Cliente editaUsuario(Cliente _cliente, Cliente _cliente2) throws Exception{
        Connection _con=null;
        Cliente _clienteEditado=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteDAO.editaUsuario(_con,_cliente, _cliente2);     
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteEditado;
    }
    
    public Cliente editaCliente(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteEditado=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteDAO.editaCliente(_con,_cliente);     
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteEditado;
    }
    
    public Cliente eliminaUsuario(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteEliminado=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteDAO.eliminaUsuario(_con,_cliente);     
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteEliminado;
    }
    
     public void eliminaCliente(int dni) throws Exception{
        Connection _con=null;
        Cliente _clienteEliminado=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteDAO.eliminaCliente(_con,dni);     
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
    }

    public Cliente validaCliente(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteObtenido=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteObtenido=_clienteDAO.findByNick(_con,_cliente);//Recuperamos los clientes        
         _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
         if (_clienteObtenido==null) throw new ProgException("Usuario o clave incorrectas");
        return _clienteObtenido;
    }
    
    public Cliente findByDNI(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteObtenido=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteObtenido=_clienteDAO.findByDNI(_con,_cliente);//Recuperamos los clientes
        _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
        return _clienteObtenido;
    }
    public List<Cliente> listaClientes() throws Exception
    {
        Connection _con=null;
        List<Cliente> _listado=new ArrayList();
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();        
        //float a=0;
        //if (true) a=0/0;
        _listado=_clienteDAO.findAll(_con);//Recuperamos los clientes
                 
         _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */ 
       
        return _listado;
    }
    
    public Cliente listadoFacturas(Cliente cliente) throws Exception {
        Connection _con=null;
        Cliente _listado=new Cliente();        
        Conexion_DB _conexion_DB = new Conexion_DB();        
        _con = _conexion_DB.AbrirConexion();        
        ClienteDAO _clienteDAO=new ClienteDAO();        
        _listado=_clienteDAO.getClienteFacturas(_con,cliente);                 
        _conexion_DB.CerrarConexion(_con);        
        return _listado;
    }



}

