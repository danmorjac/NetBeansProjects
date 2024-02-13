/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarPerfilCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    Cliente cli = (Cliente) request.getSession().getAttribute("ClienteSesion");
    
    String newNick = request.getParameter("Nick");
    if (newNick.length() > 0) cli.setNick(newNick);
    
    String newPassword = request.getParameter("Password");
    if (newPassword.length() > 0) cli.setPassword(newPassword);
    
    String newNombre = request.getParameter("Nombre");
    if (newNombre.length() > 0) cli.setNombre(newNombre);
    
    String newApe1 = request.getParameter("Apellido1");
    if (newApe1.length() > 0) cli.setApellido1(newApe1);
    
    String newApe2 = request.getParameter("Apellido2");
    if (newApe2.length() > 0) cli.setApellido2(newApe2);
    
    new ClienteBLL().updateCliente(cli);
    request.getSession().setAttribute("ClienteSesion", cli);
    
    return "/edicionRealizada.jsp";
  }
  
}
