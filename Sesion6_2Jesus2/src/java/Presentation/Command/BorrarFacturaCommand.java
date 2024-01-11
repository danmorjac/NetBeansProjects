package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarFacturaCommand extends ICommand{
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        
        //Definimos el mime-type de la respuesta
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("opID");
        try {
          if(operacion.equals("BorrarFactura") && request.getParameter("idFactura") != "") {
            int id_factura = Integer.parseInt(request.getParameter("idFactura"));
            int id_articulo =Integer.parseInt(request.getParameter("borraArticulo"));
            FacturaBLL _facturaBLL = new FacturaBLL();
            _facturaBLL.borrarArticulo(id_factura, id_articulo);
            Factura _factura=new Factura();
            _factura.setId(id_factura);
            Articulo _articulo=new Articulo();
            _articulo.setId(id_articulo);  
            _factura=_facturaBLL.getArticulosFactura(_factura);
            //Se ha actualizado el saldo del cliente desde logica de negocio
             ClienteBLL _clienteBLL = new ClienteBLL();
             Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion"); 
            _cliente=_clienteBLL.findByDNI(_cliente);
            request.getSession().setAttribute("ClienteSesion",_cliente);
            request.setAttribute("FacturaCliente",_factura);
          }
        } catch (Exception e) {
        }
 
        finally {
        }
    
        return "/editarFactura.jsp";          
    }
}
