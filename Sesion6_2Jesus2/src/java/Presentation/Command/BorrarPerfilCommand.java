/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ClienteBLL;
import DAO.Conexion_DB;
import Entidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarPerfilCommand extends ICommand { 
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        Cliente _cliente=new Cliente();//Crea un objeto Cliente los datos ingresados
        _cliente = (Cliente) request.getSession().getAttribute("ClienteSesion");
        
        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente = _clienteBLL.eliminaUsuario(_cliente);
        request.getSession().removeAttribute("ClienteSesion");
        return "/eliminaUsuarioRealizado.jsp";            
    } 
}
