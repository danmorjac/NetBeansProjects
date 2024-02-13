/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ArticuloBLL;
import Entidad.Articulo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pabcrudel
 */
public class MostrarEditarArticuloCommand extends ICommand {

  @Override
  public void initPage(
   HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    String idArticulo = (String) request.getParameter("articuloElegido");

    Articulo art = new ArticuloBLL().findById(Integer.parseInt(idArticulo));

    request.getSession().setAttribute("articuloEditar", art);
  }

  @Override
  public String execute(
   HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    return "/formularioEditarArticulo.jsp";
  }

}