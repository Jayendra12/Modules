package org.seed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
* The  program implements an application that
* simply displays "interns" to the table.
*
* @author  Jayendra Kambli
* @version 1.0
* @since  8/1/2017
* This connect method gives connection object
*/
public class Connectivity {
	public final static String DB_URL="jdbc:oracle:thin:@sharesrv:1521:orcl";
	public final static  String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
	public final static String DB_USERNAME="spic";
	public final static String DB_PASSWORD="spic";
	
	
	/**
	   * This method is used to get Connection object This is
	   * a the simplest form of a class method, just to
	   * show the usage of various javadoc Tags.
	   * 
	   * @return Connection object
	   */
	public static Connection connect(){
		Connection con = null;
		try {
			Class.forName(DB_DRIVER);
		    con= DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
