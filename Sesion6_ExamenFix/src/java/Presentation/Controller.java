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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ICommand _beforeCommand = null;
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.setContentType("text/html;charset=UTF-8");
            System.out.println(request);
            String operacion = request.getParameter("opID");
            if (!operacion.equals("Login") && !operacion.equals("MostrarLogin") && !operacion.equals("MostrarCrearClientes") && !operacion.equals("nuevoCliente")) {
                //if (request.getSession().getAttribute("ClienteSesion")==null)
                // throw new ProgException("Identifiquese para acceder al aplicativo");
            }

            //Carga de forma dinámica la clase que implementa ICommand
            ICommand command = (ICommand) Class.forName("Presentation.Command." + operacion + "Command").newInstance();
            if (request.getSession().getAttribute("lastCommand") != null) {
                _beforeCommand = (ICommand) request.getSession().getAttribute("lastCommand");
            }
            request.getSession().setAttribute("lastCommand", command);
            //ejecuta la clase y recibe la siguiente página a visualizar
            command.initPage(request, response);
            String nextPage = command.execute(request, response);
            Log.getInstance().debug(nextPage);
            new Dispatcher().procesa(request, response, nextPage);
        } catch (ProgException ex) {
            String _parameterName = "";

            for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
                _parameterName = (String) e.nextElement();
                request.setAttribute(_parameterName, request.getParameter(_parameterName));
            }
            request.getSession().setAttribute("lastCommand", _beforeCommand);
            try {
                _beforeCommand.initPage(request, response);
            } catch (Exception e) {
            };
            new Dispatcher().procesa(request, response, ex);
        } catch (Exception ex) {
            request.getSession().setAttribute("lastCommand", _beforeCommand);
            String _ticketId = Fechas.getInstance().getTicketFecha();
            Log.getInstance().error(_ticketId, ex);
            request.setAttribute("tickectId", _ticketId);
            throw new ServletException("Excepción no controlada " + ex.getMessage());
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
