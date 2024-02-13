/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ArticuloBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListarArticulosCommand extends ICommand {

  @Override
  public void initPage(
          HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    // Solicitar a la BBDD todos los articulos
    request.setAttribute("listadoArticulos", new ArticuloBLL().findAll());

    Cliente cli = (Cliente) request.getSession().getAttribute("ClienteSesion");

    String adminName = "aaron";
    String adminPwd = "swartz";
    boolean isAdmin = cli.getNombre().equals(adminName) && cli.getPassword().equals(adminPwd);

    request.setAttribute("isAdmin", isAdmin);
  }

  @Override
  public String execute(
          HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    return "/listarArticulos.jsp";
  }

}
