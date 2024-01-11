package Presentation.Command;

import BLL.ClienteBLL;
import DAO.Conexion_DB;
import Entidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jjavier
 */
public class EditarPerfilCommand extends ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        Cliente _cliente2=new Cliente();//Crea un objeto Cliente los datos ingresados
        _cliente2 = (Cliente) request.getSession().getAttribute("ClienteSesion");
        Cliente _cliente=new Cliente();//Crea un objeto Cliente los datos ingresados
        _cliente.setNick(request.getParameter("Nick"));
        _cliente.setPassword(request.getParameter("Password"));
        _cliente.setApellido1(request.getParameter("Apellido1"));
        _cliente.setApellido2(request.getParameter("Apellido2"));
        _cliente.setNombre(request.getParameter("Nombre"));
    
        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente = _clienteBLL.editaUsuario(_cliente, _cliente2);
        return "/edicionRealizada.jsp";            
    }    
}
