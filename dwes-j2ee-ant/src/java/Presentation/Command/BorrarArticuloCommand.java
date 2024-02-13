
package Presentation.Command;

import BLL.ArticuloBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BorrarArticuloCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    int idArticulo = Integer.parseInt((String) request.getSession()
      .getAttribute("borrarArticuloId"));
    
    new ArticuloBLL().deleteById(idArticulo);
    
    return "/eliminaArticuloRealizado.jsp";
  }
  
}
