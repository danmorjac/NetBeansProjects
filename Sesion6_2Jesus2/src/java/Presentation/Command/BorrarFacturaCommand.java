/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import Presentation.Command.ICommand;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
            Factura _factura = new Factura();
            _factura.setId(id_factura);
            FacturaBLL _facturaBLL = new FacturaBLL();
            Factura definitiva = _facturaBLL.getArticulosFactura(_factura);
              PrintWriter out = response.getWriter();
              for (Articulo art : definitiva.getArticulos()) {
                  _facturaBLL.borrarArticulo(id_factura, art.getId());
              }
              
               ClienteBLL _clienteBLL = new ClienteBLL();
             Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion"); 
            _cliente=_clienteBLL.findByDNI(_cliente);
            request.getSession().setAttribute("ClienteSesion",_cliente);
            request.setAttribute("FacturaCliente",_factura);
            _facturaBLL.borrarFactura2(id_factura);
            
            }
        } catch (Exception e) {
        }
 
        finally {
        }
        
      return  "/eliminaFacturaRealizado.jsp";
        //return "/Controller?opID=ListaFactura";          
    }
}
