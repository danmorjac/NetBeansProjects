
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class PedirClienteCommand extends ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        request.setAttribute("DNI", request.getParameter("dniCliente"));
        return "/editarPerfil.jsp";       
    }
    
}
