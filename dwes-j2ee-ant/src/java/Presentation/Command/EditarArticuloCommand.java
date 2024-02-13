/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ArticuloBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pabcrudel
 */
public class EditarArticuloCommand extends ICommand {

  @Override
  public String execute(
   HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    new ArticuloBLL().updateArticulo(
      request.getParameter("Descripcion"), 
      Float.parseFloat(request.getParameter("Precio")), 
      Integer.parseInt(request.getParameter("Stock")),
      Integer.parseInt(request.getParameter("idArticulo"))
    );

    return "/addArticuloRealizado.jsp";
  }

}