package Presentation;

import Entidad.Exceptions.ProgException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {

  // Llamar a la funcion con un string
  public void procesa(
    HttpServletRequest request,
    HttpServletResponse response,
    String nextPage
  ) throws ServletException, IOException {
    String _beforePage = "";
    try {
      response.setContentType("text/html;charset=UTF-8");

      // Alamcena en la var "paginaprincipal" el JSP que viene en "nextPage"
      request.setAttribute("paginaprincipal", nextPage);

      // Copia de seguridad de la ubicacion anterior que esta almacenado
      // en sesion
      _beforePage
        = (String) request.getSession().getAttribute("paginaprincipal");

      // Guarda en la sesion la nueva pagina
      request.getSession().setAttribute("paginaprincipal", nextPage);

      // Renderiza "nextPage" (el componente) en el index (parte blanca)
      request.getRequestDispatcher("/index.jsp")
        .forward(request, response);
    } catch (IOException ex) {
      // Recupera el backup de la ubicacion (JSP) en donde estaba
      request.getSession().setAttribute("paginaprincipal", _beforePage);
      throw ex;
    } catch (ServletException ex) {
      request.getSession().setAttribute("paginaprincipal", _beforePage);
      throw ex;
    }
  }

  // Llamar a la funcion con un error
  public void procesa(
    HttpServletRequest request,
    HttpServletResponse response,
    ProgException ex
  ) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // Copia de seguridad de la ubicacion anterior que esta almacenado
    // en sesion
    String _beforePage
      = (String) request.getSession().getAttribute("paginaprincipal");

    // Alamcena en la var "paginaprincipal" el JSP anterior al error
    // almacenado en la sesion
    request.setAttribute("paginaprincipal", _beforePage);

    // Alamcena en la var "advertencia" el mensaje de error
    request.setAttribute("advertencia", ex.getMessageError());

    // Renderiza el error en el index (parte blanca)
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }
}
