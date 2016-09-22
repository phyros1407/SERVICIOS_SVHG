package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.DepartamentoBean;
import beans.DistritoBean;
import beans.ProvinciaBean;
import dao.factory.DAOFactory;
import dao.interfaces.servicesDAO;
import util.ResponseObject;

/**
 * Servlet implementation class servicios
 */
@WebServlet("/servicios")
public class servicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		servicesDAO serv = dao.getServiceDAO();
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("deps")){
			
			ArrayList<DepartamentoBean> departamentos = serv.listarDepartamentos();
			
			ResponseObject responseobj=null;
			if(departamentos!=null){
				responseobj=new ResponseObject();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				responseobj.setSuccess(true);
				responseobj.setObject(departamentos);
			}
			response.getWriter().write(new Gson().toJson(responseobj));
			System.out.println("json" + new Gson().toJson(responseobj));
			
			
		}
		
		if(action.equalsIgnoreCase("pros")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<ProvinciaBean> provincias = serv.listarProvincias(id);
			
			ResponseObject responseobj=null;
			if(provincias!=null){
				responseobj=new ResponseObject();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				responseobj.setSuccess(true);
				responseobj.setObject(provincias);
			}
			response.getWriter().write(new Gson().toJson(responseobj));
			System.out.println("json" + new Gson().toJson(responseobj));
			
			
		}
		
		if(action.equalsIgnoreCase("dist")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<DistritoBean> distritos = serv.listarDistritos(id);
			
			ResponseObject responseobj=null;
			if(distritos!=null){
				responseobj=new ResponseObject();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				responseobj.setSuccess(true);
				responseobj.setObject(distritos);
			}
			response.getWriter().write(new Gson().toJson(responseobj));
			System.out.println("json" + new Gson().toJson(responseobj));
			
			
		}
	
		
	}
		
}
