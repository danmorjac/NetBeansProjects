package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delFacturaCommand extends ICommand{
     
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        int _idFactura = Integer.parseInt(request.getParameter("idFactura"));
        int _idArticulo =Integer.parseInt(request.getParameter("borraArticulo"));    
        int _cantidad =Integer.parseInt(request.getParameter("cantidadArticulo"));
        FacturaBLL _facturaBLL=new FacturaBLL();
        Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");            
        Factura _factura=new Factura();
        _factura.setId(_idFactura);
        Articulo _articulo=new Articulo();
        _articulo.setId(_idArticulo);        
        _facturaBLL.delArticulo(_cliente, _factura, _articulo,_cantidad);
        //Se ha actualizado la factura
        _factura=_facturaBLL.getArticulosFactura(_factura);
        //Se ha actualizado el saldo del cliente desde logica de negocio
        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente=_clienteBLL.findByDNI(_cliente);
        ArticuloBLL _articuloBLL = new ArticuloBLL();
        request.setAttribute("listadoArticulos", _articuloBLL.listaArticulos());
        request.getSession().setAttribute("ClienteSesion",_cliente);
        request.setAttribute("FacturaCliente",_factura);
        return "/editarFactura.jsp";          
    }
}
