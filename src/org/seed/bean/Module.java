package org.seed.bean;

import java.util.Date;

public class Module {
	int id;
	String moduleCode;
	String moduleName;
	int noOfHours;
	String status;
	Date moduleDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getModuleDate() {
		return moduleDate;
	}
	public void setModuleDate(Date moduleDate) {
		this.moduleDate = moduleDate;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleCode=" + moduleCode + ", moduleName=" + moduleName + ", noOfHours="
				+ noOfHours + ", status=" + status + ", moduleDate=" + moduleDate + "]";
	}
	
	

}
