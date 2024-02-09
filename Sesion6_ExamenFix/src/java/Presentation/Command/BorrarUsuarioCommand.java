
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class BorrarUsuarioCommand extends ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     try{
       
        Cliente _cliente=new Cliente();
        
        _cliente.setNick(request.getParameter("nickCliente"));
         
        ClienteBLL clienteBLL = new ClienteBLL();
        
        clienteBLL.borrarUsuario(_cliente);
        
     }catch (Exception e){     
    }
        return "/usuarioBorrado.jsp";       
    }
    
}

