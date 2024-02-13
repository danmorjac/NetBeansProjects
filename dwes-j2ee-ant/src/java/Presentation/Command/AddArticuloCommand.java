package Presentation.Command;

import BLL.ArticuloBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddArticuloCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    new ArticuloBLL().insertArticulo(
      request.getParameter("Descripcion"), 
      Float.parseFloat(request.getParameter("Precio")), 
      Integer.parseInt(request.getParameter("Stock"))
    );
    
    return "/addArticuloRealizado.jsp";
  }
}
