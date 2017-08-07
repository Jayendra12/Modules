package org.seed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seed.bean.Module;
import org.seed.model.InsertAndFetchModel;

/**
 * Servlet implementation class ModuleRegisterAndFetchServlet
 */
public class ModuleRegisterAndFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Module module = new Module();
	InsertAndFetchModel model = new InsertAndFetchModel();
	int i;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModuleRegisterAndFetchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String moduleCode = request.getParameter("mcode");
		String moduleName = request.getParameter("mname");
		String moduleHours = request.getParameter("mhours");
		String status = request.getParameter("mstatus");
		Boolean code = model.isModuleCodeExists(moduleCode);
		Boolean checkName = model.isModuleNameAndHoursUnique(moduleName, Integer.parseInt(moduleHours));
		request.setAttribute("moduleCheck", checkName);
		request.setAttribute("code", code);
		if (code.equals(true)) {
			RequestDispatcher rd = request.getRequestDispatcher("/CreateModule.jsp");
			rd.forward(request, response);
		}
		else if (checkName.equals(true)) {
			RequestDispatcher rd = request.getRequestDispatcher("/CreateModule.jsp");
			rd.forward(request, response);
		} else {
			module.setModuleCode(moduleCode);
			module.setModuleName(moduleName);
			module.setNoOfHours(Integer.parseInt(moduleHours));
			module.setStatus(status);
			String msg = model.insertModule(module);
			response.sendRedirect("CreateModule.jsp?Message=" + msg);
		}

	}

}
