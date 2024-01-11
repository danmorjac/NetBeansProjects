/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ClienteBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jjavier
 */
public class EditarClientesCommand extends ICommand{
    @Override
    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ClienteBLL _clienteBLL = new ClienteBLL();
        request.setAttribute("listadoClientes", _clienteBLL.listaClientes());    
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
          return "/editarClientes.jsp";          
    }
    
}
