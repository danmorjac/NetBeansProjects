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

    public Cliente validaCliente(Cliente _cliente) throws Exception{
        Connection _con=null;
        Cliente _clienteObtenido=null;
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        ClienteDAO _clienteDAO=new ClienteDAO();
        _clienteObtenido=_clienteDAO.findByNick(_con,_cliente);//Recuperamos los clientes        
         _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */         
         if ((_clienteObtenido==null) 
            ||(!_clienteObtenido.getPassword().equals(_cliente.getPassword())))
                throw new ProgException("Usuario o clave incorrectas");
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

}
