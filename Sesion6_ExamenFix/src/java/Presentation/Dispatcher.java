package Presentation;

import Entidad.Exceptions.ProgException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
    public void procesa(HttpServletRequest request, HttpServletResponse response,String nextPage)
    throws ServletException, IOException {
        String _beforePage="";
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("paginaprincipal", nextPage);
            _beforePage=(String) request.getSession().getAttribute("paginaprincipal");
            request.getSession().setAttribute("paginaprincipal", nextPage);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }catch(IOException ex)
        {
        request.getSession().setAttribute("paginaprincipal", _beforePage);
        throw ex;
        }catch(ServletException ex)
        {
        request.getSession().setAttribute("paginaprincipal", _beforePage);
        throw ex;
        }
    } 
    
    public void procesa(HttpServletRequest request, HttpServletResponse response, ProgException ex) 
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String _beforePage=(String) request.getSession().getAttribute("paginaprincipal");
        request.setAttribute("paginaprincipal", _beforePage);
        request.setAttribute("advertencia", ex.getMessageError());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

