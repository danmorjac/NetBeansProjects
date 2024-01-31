/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class MostrarModificarCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
         return "/modificar.jsp";         
    }       
}
