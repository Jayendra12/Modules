package org.seed.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.seed.bean.Module;
import org.seed.util.Connectivity;

public class InsertAndFetchModel {
	Connection con = Connectivity.connect();
	private static Logger log = Logger.getLogger(InsertAndFetchModel.class);
	int i;
	
	Boolean bool = false;
	Module module=new Module();

	public String insertModule(Module module) {
		String name = module.getModuleName();
		String code = module.getModuleCode();
		String status = module.getStatus();
		int noOfHours = module.getNoOfHours();
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");

		System.out.println(con);
		try {
			PreparedStatement stmt = con.prepareStatement("insert into modules"
					+ "(id,moduleCode,moduleName,noOfHours,status,moduleDate) values" + "(id_mod_seq.nextval,?,?,?,?,sysdate)");
			
			stmt.setString(1, code);
			stmt.setString(2, name);
			stmt.setInt(3, noOfHours);
			stmt.setString(4, status);
			i = stmt.executeUpdate();
			log.debug("data inserted succesfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Record inserted successfully";

	}
	public Module individualmoduleFetch(int id){
		String sql = "select * from modules where id="+id;
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				module.setModuleCode(rs.getString("moduleCode"));
				module.setModuleName(rs.getString("moduleName"));
				module.setNoOfHours(rs.getInt("noOfHours"));
				module.setStatus(rs.getString("status"));
				module.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return module;
		
	}

	public boolean isModuleCodeExists(String moduleCode) {
		String sql = "select moduleCode from modules where moduleCode='" + moduleCode.toUpperCase() + "'";
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
        bool=false;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String moduleCodeDb = rs.getString("moduleCode");
				if (moduleCodeDb.equalsIgnoreCase(moduleCode)) {
					bool = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bool);
		return bool;
	}

	public int updateModule(Module module) {
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
		String name = module.getModuleName();
		String status = module.getStatus();
		int noOfHours = module.getNoOfHours();
		String code=module.getModuleCode();
		int id = module.getId();

		String sql = "Update modules set moduleCode=?,modulename=?, noOfhours=?,status=? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, code);
			stmt.setString(2, name);
			stmt.setInt(3, noOfHours);
			stmt.setString(4, status);
			stmt.setInt(5, id);
			i = stmt.executeUpdate();
			log.debug("data updated succesfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(i);
		return i;

	}

	public int deleteModule(int id) {
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
		String sql = "delete from modules where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			i = stmt.executeUpdate();
			log.debug("record deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(i);
		return i;
	}

	public List<Module> fetchModules() {
		List<Module> moduleList = new ArrayList<Module>();
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
		String sql = "select * from modules order by moduleDate";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String code = rs.getString("moduleCode");
				String mName = rs.getString("moduleName");
				int hours = rs.getInt("noOfHours");
				String status = rs.getString("status");
				Date d = rs.getDate("moduleDate");
				Module module = new Module();
				module.setId(id);
				module.setModuleName(mName);
				module.setNoOfHours(hours);
				module.setModuleCode(code);
				module.setStatus(status);
				module.setModuleDate(d);
				moduleList.add(module);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(moduleList.size());
		return moduleList;
	}

	public boolean isModuleNameAndHoursUnique(String moduleName, int hours) {
		PropertyConfigurator.configure("Z:/scts81/ModuleManagement/log4j.properties");
		String sql = "select moduleName,noOfHours from modules";
        bool=false;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mname = rs.getString("moduleName");
				int nhours = rs.getInt("noOfHours");
				if (moduleName.equalsIgnoreCase(mname) && (hours == (nhours))){
					bool = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(bool);
		return bool;

	}

}
