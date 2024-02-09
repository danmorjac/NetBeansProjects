
package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class MostrarEditarUsuarioCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{       
         return "/editarPerfil.jsp";         
    }   
    
}
