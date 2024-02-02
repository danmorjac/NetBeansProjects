package Presentation.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author victor perez
 * @version 1
 */
public abstract class ICommand {
/** Método para cargar los valores iniciales (combos, listas,etc.) de la pa´gina
* @param request Permite obtener los parametros del cliente
* @param response Permite especificar parametros de la respuesta
* @throws Dispara cualquier excepción que encuentre
*/
public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception
{
    //No obligamos a inicializar la página
}
/** Método para recoger los parametros del cliente, llamar a lógica de negocio
 * e indica que página debe cargar el aplicativo a continuación
* @param request Permite obtener los parametros del cliente
* @param response Permite especificar parametro de la respuesta
* @return Devuelve la página que debe cargar el aplicativo a continuación.
* @throws Dispara cualquier excepción que encuentre
*/
public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

