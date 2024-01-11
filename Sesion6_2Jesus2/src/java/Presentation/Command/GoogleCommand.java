/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Command;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Ruben
 */public class GoogleCommand extends ICommand{
        public String execute(HttpServletRequest request, 
                HttpServletResponse response) throws Exception{
          return "/mapa.jsp";          
    }
}

