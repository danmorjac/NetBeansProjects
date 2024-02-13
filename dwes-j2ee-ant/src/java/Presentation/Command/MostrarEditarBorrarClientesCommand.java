/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MostrarEditarBorrarClientesCommand extends ICommand {
  
  @Override
  public void initPage(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    // Solicitar a la BBDD todos los clientes registrados
    request.setAttribute("listadoClientes", new ClienteBLL().findAll());
    
    Cliente cli = (Cliente) request.getSession().getAttribute("ClienteSesion");
    
    int adminDNI = 33;
    boolean isAdmin = cli.getDNI() == adminDNI;
    
    request.setAttribute("isAdmin", isAdmin);
  }

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    return "/editarBorrarClientes.jsp";
  }
}
