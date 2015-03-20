package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.TemaBean;
import controllers.TemaController;

@WebServlet("/listarTemas")
public class ListarTemasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	List<TemaBean> listaTemas = TemaController.getTemas();
    	request.setAttribute("temas", listaTemas);
        this.getServletContext().getRequestDispatcher("/JSP/TemasView.jsp").forward(request, response);
    }

}
