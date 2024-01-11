/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jjavier
 */
public class BorrarClienteCommand extends ICommand{
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        
        //Definimos el mime-type de la respuesta
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("opID");
        try {
          if(operacion.equals("BorrarCliente") && request.getParameter("dni") != "") {
            int id_dni = Integer.parseInt(request.getParameter("dni"));
            ClienteBLL _clienteBLL = new ClienteBLL();
            _clienteBLL.eliminaCliente(id_dni);
          }
        } catch (Exception e) {
        }
 
        finally {
        }
    
        return "/menu.jsp";          
    }
}
