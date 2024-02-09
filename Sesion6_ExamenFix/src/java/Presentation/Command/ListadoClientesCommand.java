
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ivane
 */
public class ListadoClientesCommand extends ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
        try {
            Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");
            
            ClienteBLL _clienteBLL = new ClienteBLL(); 
            
            List<Cliente> _listado=new ArrayList();

            _listado=_clienteBLL.listaClientes();
            
            request.setAttribute("ListadoClientes", _listado);
            
        } catch (Exception e) {}
        return "/listadoClientes.jsp";   
    }
}
