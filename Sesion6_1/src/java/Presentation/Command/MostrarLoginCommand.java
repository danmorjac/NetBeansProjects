package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarLoginCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
         return "/login.jsp";         
    }       
}
