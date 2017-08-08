package org.seed.controller;

import java.io.IOException;
import java.util.List;

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

		String fvname = request.getParameter("updateForm");
		String vname = request.getParameter("viewName");
		String funame=request.getParameter("editModule");
		String fdname=request.getParameter("deleteModule");
		System.out.println(fvname + " " + vname);
		/* if (fvname != null||vname!=null) { */

		if(funame!=null){
			if(funame.equals("edit")){
				int id=(int) request.getAttribute("id");
				module=model.individualmoduleFetch(id);
				request.setAttribute("module", module);
				RequestDispatcher rd = request.getRequestDispatcher("/UpdateModule.jsp");
				rd.forward(request, response);
			}
		}
		
		if (fvname != null) {
			if (fvname.equals("updateModule")) {
				String mcode = request.getParameter("mcode");
				String mname = request.getParameter("mname");
				String hours = request.getParameter("mhours");
				String check = request.getParameter("status");
				module.setModuleCode(mcode);
				module.setModuleName(mname);
				module.setNoOfHours(Integer.parseInt(hours));
				module.setStatus(check);
				model.updateModule(module);
				
			}
		}
		if (vname != null) {
			if (vname.equals("viewModule")) {
				List<Module> modules = model.fetchModules();
				request.setAttribute("Modules", modules);
				if (modules != null) {
					System.out.println(modules.toString());
					RequestDispatcher rd = request.getRequestDispatcher("/ViewModule.jsp");
					rd.forward(request, response);
				}

			}
		}
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
		} else if (checkName.equals(true)) {
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
