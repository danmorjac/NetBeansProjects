
package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class MostrarCrearClienteCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
         return "/crearCliente.jsp";         
    }   
}