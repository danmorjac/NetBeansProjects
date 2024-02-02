package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLineaFacturaCommand extends ICommand{
     @Override
    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String _idFactura=request.getParameter("idFactura");
        if ((_idFactura==null)||(_idFactura.equals("0")))
        {//Si se da un error controlado, o se quiere añadir un producto 
         //a la factura no se genera una nueva factura si ya existe
            FacturaBLL _facturaBLL=new FacturaBLL();
            Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");
            Factura _factura=_facturaBLL.crearFactura(_cliente);
            request.setAttribute("FacturaCliente",_factura);
        }else
        {//La pantalla requiere de una factura y de los articulos que la componen
            Factura _factura=new Factura();
            _factura.setId(Integer.parseInt(_idFactura));
            FacturaBLL _facturaBLL=new FacturaBLL();
            _factura=_facturaBLL.getArticulosFactura(_factura);
            request.setAttribute("FacturaCliente",_factura);
        }
        //La pantalla requiere de un listado de articulos para añadir
        ArticuloBLL _articuloBLL = new ArticuloBLL();
        request.setAttribute("listadoArticulos", _articuloBLL.listaArticulos());    
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("opID");
        if (request.getParameter("idFactura") != "") {
        int _idFactura = Integer.parseInt(request.getParameter("idFactura"));
        int _idArticulo =Integer.parseInt(request.getParameter("borraArticulo"));
        int _cantidad =Integer.parseInt(request.getParameter("cantidad"));
        FacturaBLL _facturaBLL = new FacturaBLL();
        Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion"); 
        Factura _factura=new Factura();
        _factura.setId(_idFactura);
        Articulo _articulo=new Articulo();
        _articulo.setId(_idArticulo);        
        _facturaBLL.borrarLineaArticulo(_cliente, _factura, _articulo, _cantidad);
        _factura=_facturaBLL.getArticulosFactura(_factura);
        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente=_clienteBLL.findByDNI(_cliente);
        request.getSession().setAttribute("ClienteSesion",_cliente);
        request.setAttribute("FacturaCliente",_factura);
        }  
        return "/editarFactura.jsp";                    
    }
}
