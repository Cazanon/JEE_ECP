package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.models.entities.Tema;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static String PATH_ROOT_VIEW = "/views/jsp/";
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
        	view = action;
        	break;
        case "verVotos":
        	view = action;
        	break;
        case "addTema":
        	view = action;
        	break;
        case "eliminarTema":
        	view = action;
        	break;        	
        default:
            view = "home";
        }
		
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);		
	}
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        String action = request.getPathInfo().substring(1);
        
        String view;
        switch (action) {
        case "votar":
        	view = action;
        	break;
        case "verVotos":
        	view = action;
        	break;
        case "addTema":
        	Tema tema = new Tema(request.getParameter("nombre"),request.getParameter("pregunta"));
        	AddTemaBean addTemaBean = new AddTemaBean();
        	addTemaBean.setTema(tema);
        	addTemaBean.process();
        	request.setAttribute(action+"Bean",addTemaBean);
        	view = action;
        	break;
        case "eliminarTema":
        	view = action;
        	break;        	
        default:
            view = "home";
        }
		
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);	        
	}

}
