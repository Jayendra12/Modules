package org.seed.junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.seed.bean.Module;
import org.seed.model.InsertAndFetchModel;

public class Test {
	private InsertAndFetchModel im;
	 Module module=new Module();
	   
	   @Before
	   public void init(){
		   im=new InsertAndFetchModel();
	   }
	 /* @org.junit.Test
	  public void fetchModulesTest(){
		                              
		  assertNotNull("List is not null", im.fetchModules());
	  }*/
	 /* @org.junit.Test
	  public void fetchModulesTest(){
		  assertNull("list is null", im.fetchModules());
	  }*/
	  
	   
	  /* @org.junit.Test
	   public void isModuleNameAndHoursUnique(){
		   String nme="Core Java";
		   int hours=60;
		   assertTrue(im.isModuleNameAndHoursUnique(nme, hours));
		   
	   }*/
	   
	   
	  /* @org.junit.Test
	   public void isModuleNameAndHoursUniqueTest(){
		   String name="Core Java ";
		   int hours=70;
		   assertFalse(im.isModuleNameAndHoursUnique(name, hours));		   
	   }*/
	   
	 /*  @org.junit.Test
	  public void deleteModuleTest(){
		  int id=500;
		  assertEquals("deleted",1,im.deleteModule(id));
	  }*/
	/*  @org.junit.Test
	  public void deleteModuleTest(){
		  int id=503;
		  assertNotEquals("Not deleted", 2,im.deleteModule(id));
	  }
	   */
	   
	  
	  /* @org.junit.Test
	   public void updateModuleTest(){
		   module.setModuleName("Core Java");
		   module.setNoOfHours(90);
		   module.setStatus("on");
		   module.setId(503);
		   assertEquals("Updated",1,im.updateModule(module));
	   }*/
	   
	  /* @org.junit.Test
	   public void updateModuleTest(){
		   module.setModuleName("Core Java");
		   module.setNoOfHours(90);
		   module.setStatus("off");
		   module.setId(503);
		   assertNotEquals("Not Updated",null,im.updateModule(module));
	   }*/
	   
	 /* @org.junit.Test 
	  public void isModuleCodeExistsTest(){
		  String code="CJV-01";
		  assertFalse(im.isModuleCodeExists(code));
	  }*/
	 /* @org.junit.Test 
	  public void isModuleCodeExistsTest(){
		  String code="CJV-01";
		  assertTrue(im.isModuleCodeExists(code));
	  }*/
	  
	 /* @org.junit.Test
	   public void registerUserTest(){
		   
		   module.setModuleCode("CJV-01");
		   module.setModuleName("Core Java");;
		   module.setNoOfHours(90);;
		   module.setStatus("on");;
		  
		   assertEquals("Inserted", null, im.insertModule(module));
	   }*/
	   
		/*  @org.junit.Test
		   public void registerUserTest(){			  
			   assertEquals("not Inserted",null, im.insertModule(module));
		   }*/
	  

}
