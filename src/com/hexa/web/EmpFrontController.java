package com.hexa.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexa.dao.EmpDaoImpl;
import com.hexa.dao.IEmpDao;

/**
 * Servlet implementation class EmpFrontController
 */
//@WebServlet(value = "*.htm", loadOnStartup = 1)
public class EmpFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpAppController action = new EmpAppController();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	ServletContext ctx = getServletContext();
    	ctx.setAttribute("dlist", action.getDepartment());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		EmpAppController action = new EmpAppController();
		String url = request.getServletPath();
		String view = null;
		switch(url) {
		case "/viewall.htm" :
			view = action.processViewAll(request);
			break;		
		case "/viewdept.htm":
			view = action.processViewByDept(request);
			break;
		case "/viewbyid.htm":
			view = action.processViewById(request);
			break;
		case "/edit.htm":
			view = action.processViewById(request);
			break;	
		case "/update.htm":
			view = action.updateEmployee(request);
			break;
		case "/add.htm":
			view = action.addEmployeeToTheTable(request);
			break;
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeURL(view));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
