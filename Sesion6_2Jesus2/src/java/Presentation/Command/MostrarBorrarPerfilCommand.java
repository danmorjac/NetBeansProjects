package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jjavier
 */
public class MostrarBorrarPerfilCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
         return "/borrarPerfil.jsp";         
    }       
    
}
