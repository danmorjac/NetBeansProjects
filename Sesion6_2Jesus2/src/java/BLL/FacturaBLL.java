package BLL;
import DAO.ArticuloDAO;
import DAO.ClienteDAO;
import DAO.Conexion_DB;
import DAO.FacturaDAO;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Exceptions.ProgException;
import Entidad.Factura;
import Entidad.Utilidad.Fechas;
import java.sql.Connection;
import java.util.GregorianCalendar;

public class FacturaBLL {
    public void addArticulo(Cliente cliente,Factura factura,Articulo articulo,int numero) throws Exception
    {
        Connection _con=null;
        try {            
        Conexion_DB _conexion_DB = new Conexion_DB();
        _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
        _con.setAutoCommit(false);
        ArticuloDAO _articuloDAO=new ArticuloDAO();
        articulo=_articuloDAO.findById(_con, articulo);//Recuperamos los datos del articulo
        ClienteDAO _clienteDAO=new ClienteDAO();
        cliente=_clienteDAO.findByDNI(_con, cliente);//Recuperamos los datos del cliente
        
        if (cliente.isMoroso()==false)
        {//Evaluamos si el cliente es Moroso
            if (articulo.getStock()>=numero)
            {//Evaluamos si hay suficiente Stock
                float _precioCompra=numero*articulo.getPrecio();
                if (_precioCompra<=cliente.getSaldo())
                {//Evaluamos si el cliente tiene suficiente dinero
                    FacturaDAO facturaDAO=new FacturaDAO();
                    facturaDAO.addArticulo(_con, factura, articulo, numero);//Inserta la linea de factura
                    articulo.setStock(articulo.getStock()-2);                    
                    _articuloDAO.updateStock(_con, articulo);//Actualiza el articulo
                    cliente.setSaldo(cliente.getSaldo()-_precioCompra);
                    _clienteDAO.updateSaldo(_con, cliente);//Actualiza el saldo del cliente                    
                }else
                {
                throw new ProgException("No tiene suficiente saldo para realizar la operación");
                }            
            }else
            {
            throw new ProgException("No queda suficiente stock");
            }
        }else
        {
        throw new ProgException("Usted es moroso");
        }
         _con.commit();  //Ejecutamos la operación             
         _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */ 
        } catch (ProgException ex) {
            System.out.println("Excepcion->"+ex.getMessage());
            if (_con!=null) _con.rollback();
            throw ex;
        }           
    }
    public Factura crearFactura(Cliente _cliente) throws Exception
    {
            Connection _con=null;
            Conexion_DB _conexion_DB = new Conexion_DB();
            _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
            FacturaDAO facturaDAO=new FacturaDAO();
            Factura factura=new Factura();            
            int _fecha=Fechas.getInstance().getFechatoInt();                    
            factura.setFecha(_fecha);            
            factura=facturaDAO.creaFactura(_con, factura,_cliente);//Crea una nueva factura
            _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */ 
            return factura;
    }
    public Factura getArticulosFactura(Factura factura) throws Exception
    {
            Connection _con=null;
            Conexion_DB _conexion_DB = new Conexion_DB();
            _con = _conexion_DB.AbrirConexion();// Abrimos la conexión
            FacturaDAO facturaDAO=new FacturaDAO();
             int _fecha=Fechas.getInstance().getFechatoInt();                    
            factura.setFecha(_fecha);            
            factura=facturaDAO.getArticulosFactura(_con, factura);//Crea una nueva factura
            _conexion_DB.CerrarConexion(_con); //Cerramos la conexión */ 
            return factura;
    }
    
    public void borrarArticulo(int idFactura, int idArticulo) throws Exception{
        
            Connection _con=null;
            Conexion_DB _conexion_DB = new Conexion_DB();
            _con = _conexion_DB.AbrirConexion();
            FacturaDAO factura_DAO = new FacturaDAO();
            factura_DAO.borrarArt(_con, idFactura, idArticulo);
            _conexion_DB.CerrarConexion(_con);
            
    }
}
