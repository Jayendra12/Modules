package org.seed.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	private static Logger log = Logger.getLogger(ModuleRegisterAndFetchServlet.class);
	

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
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    HttpSession session=request.getSession();
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
		String fupdatename = request.getParameter("updateForm");
		String vname = request.getParameter("viewName");
		String funame = request.getParameter("updateModule");
		String deleteName = request.getParameter("deleteModule");
		String moduleCode = request.getParameter("mcode1");
		String moduleName = request.getParameter("mname1");
		String moduleHours = request.getParameter("mhours1");
		Boolean code1 = model.isModuleCodeExists(moduleCode);
		Boolean checkName1 = model.isModuleNameAndHoursUnique(moduleName, Integer.parseInt(moduleHours));
		request.setAttribute("moduleCheck1", checkName1);
		request.setAttribute("code1", code1);

		log.debug(fupdatename + " " + vname + " " + funame);
		/* if (fvname != null||vname!=null) { */
		/* individual module fetch */
		if (code1.equals(true)) {
			RequestDispatcher rd = request.getRequestDispatcher("/UpdateModule.jsp");
			rd.forward(request, response);
		} else if (checkName1.equals(true)) {
			RequestDispatcher rd = request.getRequestDispatcher("/UpdateModule.jsp");
			rd.forward(request, response);
		}
		if (funame != null) {
			module = model.individualmoduleFetch(Integer.parseInt(funame));
			request.setAttribute("module", module);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateModule.jsp");
			rd.forward(request, response);
		}
		/* update module */
		if (fupdatename != null) {

			String id = fupdatename;
			log.debug(id);
			String mcode = request.getParameter("mcode");
			String mname = request.getParameter("mname");
			String hours = request.getParameter("mhours");
			String check = request.getParameter("mstatus");
			log.debug(check);
			module.setId(Integer.parseInt(id));
			module.setModuleCode(mcode);
			module.setModuleName(mname);
			module.setNoOfHours(Integer.parseInt(hours));

			if (check != null)
				module.setStatus(check);
			else
				module.setStatus("off");

			i = model.updateModule(module);
			log.debug(i);
			if (i != 0) {
				response.sendRedirect("UpdateModule.jsp?update=success");
			}

		}
		/* fetch all modules */
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
		if (deleteName != null) {
			i = model.deleteModule(Integer.parseInt(deleteName));
			if (i != 0) {
				List<Module> modules1 = model.fetchModules();
				request.setAttribute("afterDelete", modules1);
				log.debug(modules1.toString());
				if (modules1 != null) {
					System.out.println(modules1.toString());
					RequestDispatcher rd = request.getRequestDispatcher("/ViewModule.jsp?moduleDelete=true");
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
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
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
			if (status != null)
				module.setStatus(status);
			else
				module.setStatus("off");

			String msg = model.insertModule(module);
			response.sendRedirect("CreateModule.jsp?Message=" + msg);
		}

	}

}
