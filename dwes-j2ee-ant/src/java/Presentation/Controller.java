package Presentation;

import Entidad.Exceptions.ProgException;
import Entidad.Utilidad.Fechas;
import Entidad.Utilidad.Log;
import Presentation.Command.ICommand;
import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {

  protected void processRequest(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    ICommand _beforeCommand = null;
    response.setContentType("text/html;charset=UTF-8");
    try {
      System.out.println(request);
      String operacion = request.getParameter("opID");

      if ( // Si es una operacion que NECESITA identificacion
        (!operacion.equals("Login")
          && !operacion.equals("MostrarLogin")
          && !operacion.equals("MostrarRegistro")
          && !operacion.equals("Registro")
        )
        && // Si el usuario NO HA INICIADO sesion
        (request.getSession().getAttribute("ClienteSesion") == null)) {
        // Error para que el usuario se identifique
        throw new ProgException("Identifiquese para acceder al aplicativo");
      }

      // -> Carga de forma dinámica la clase que implementa ICommand
      // Carga el comando concatenando la carpeta donde estan los comandos
      // con la operacion que viene por parametros y la palaba "command"
      ICommand command
        = (ICommand) Class.forName(
          "Presentation.Command."
          + operacion
          + "Command"
        ).newInstance();

      // Copia de seguridad del comando anterior, si lo hay.
      // Lo saca del "request" para meter el nuevo comando.
      // En caso de fallar, recuperara el comando anterior.
      if (request.getSession().getAttribute("lastCommand") != null) {
        _beforeCommand
          = (ICommand) request.getSession().getAttribute("lastCommand");
      }
      request.getSession().setAttribute("lastCommand", command);

      // -> Ejecuta la clase y recibe la siguiente página a visualizar
      // Ejecuta la funcion inicial del comando (ej: solicitud a la BBDD)
      command.initPage(request, response);
      // Si peta, salta el catch
      // Seguido, obtiene el JSP a mostrar tras ejecutar la logica
      String nextPage = command.execute(request, response);
      // Si peta, salta el catch
      Log.getInstance().debug(nextPage);

      // Ejecuta el cambio de pagina.
      new Dispatcher().procesa(request, response, nextPage);
    } catch (ProgException ex) {
      // Copia de seguridad de todos los parametros de "request"
      String _parameterName = "";
      for (Enumeration e = request.getParameterNames();
        e.hasMoreElements();) {
        _parameterName = (String) e.nextElement();
        request.setAttribute(
          _parameterName,
          request.getParameter(_parameterName)
        );
      }

      // Recupera el comando anterior
      request.getSession().setAttribute("lastCommand", _beforeCommand);
      try {
        _beforeCommand.initPage(request, response);
      } catch (Exception e) {
        System.out.println(
          "Error del 1er catch de Controller: "
          + e.getMessage()
        );
      }

      // Si este paso peta, el metodo "procesa" lanza una excepcion que
      // controlara el "catch" de abajo.
      new Dispatcher().procesa(request, response, ex);
    } catch (Exception ex) {
      // Recupera el comando anterior
      request.getSession().setAttribute("lastCommand", _beforeCommand);

      // Crea un identificador del ticker de error
      String _ticketId = Fechas.getInstance().getTicketFecha();
      Log.getInstance().error(_ticketId, ex);
      request.setAttribute("tickectId", _ticketId);

      throw new ServletException(
        "Excepción no controlada " + ex.getMessage()
      );
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   */
  public String getServletInfo() {
    return "Short description";
  }
  // </editor-fold>
}
