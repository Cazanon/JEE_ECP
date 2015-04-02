package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static String PATH_ROOT_VIEW = "/views/jsp/";
	
	Tema tema;
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
        	VotarBean votarBean = new VotarBean();
        	votarBean.update();
        	request.setAttribute(action+"Bean",votarBean);
        	view = action;
        	break;
        case "verVotos":
        	VerVotosBean verVotosBean = new VerVotosBean();
        	verVotosBean.update();
        	request.setAttribute(action+"Bean",verVotosBean);
        	view = action;
        	break;
        case "addTema":
        	view = action;
        	break;
        case "eliminarTema":
        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
        	eliminarTemaBean.update();
        	request.setAttribute(action+"Bean",eliminarTemaBean);
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
        	VotarBean votarBean = new VotarBean();        	
        	if(request.getParameter("tema")!=null){
        		votarBean.obtenerTema(request.getParameter("tema"));
        	}else{
        		votarBean.obtenerTema(request.getParameter("temaSeleccionado"));
        	}
        	votarBean.setRespuesta(request.getParameter("valoracion"));
        	votarBean.setNivelEstudios(request.getParameter("nivelEstudios"));
        	votarBean.setIp(request.getLocalAddr());
        	Voto voto = new Voto(votarBean.getValoracion(), votarBean.getNivel(votarBean.getNivelEstudios()), votarBean.getIp(), votarBean.getTema());
        	votarBean.setVoto(voto);
        	votarBean.process();
        	votarBean.update();
        	request.setAttribute(action+"Bean",votarBean);
        	view = action;
        	break;
        case "verVotos":
        	VerVotosBean verVotosBean = new VerVotosBean();
        	if(request.getParameter("tema")!=null){
        		verVotosBean.obtenerTema(request.getParameter("tema"));
        	}else{
        		verVotosBean.obtenerTema(request.getParameter("temaSeleccionado"));
        	}
        	verVotosBean.setNivelEstudios(request.getParameter("nivelEstudios"));
        	verVotosBean.process();
        	verVotosBean.update();
        	request.setAttribute(action+"Bean",verVotosBean);
        	view = action;
        	break;
        case "addTema":
        	tema = new Tema(request.getParameter("nombre"),request.getParameter("pregunta"));
        	AddTemaBean addTemaBean = new AddTemaBean();
        	addTemaBean.setTema(tema);
        	addTemaBean.process();
        	request.setAttribute(action+"Bean",addTemaBean);
        	view = action;
        	break;
        case "eliminarTema":
        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean(request.getParameter("clave"));
        	eliminarTemaBean.obtenerTema(request.getParameter("temaSeleccionado"));
        	eliminarTemaBean.process();
        	eliminarTemaBean.update();
	    	request.setAttribute(action+"Bean",eliminarTemaBean);
	    	view = action;
        	break;        	
        default:
            view = "home";
        }
		
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);	        
	}

}
