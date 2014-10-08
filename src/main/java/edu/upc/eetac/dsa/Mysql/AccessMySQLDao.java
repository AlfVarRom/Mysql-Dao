package edu.upc.eetac.dsa.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * ConexiÃ³n a BBDD
 *
 */
public class AccessMySQLDao {
	

		
		//Variable global de conexiÃ³n
		public static Connection connect = null; //variable de conexiÃ³n de mySQL
	 	
		//ConexiÃ³n a BBDD de MySQL
		public static void connectDatabase() throws Exception {
		    try {
		    
		      Class.forName("com.mysql.jdbc.Driver");
		      // setup the connection with the DB.
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost/School?"
		              + "user=sqluser&password=sqlpwd");
		    	} catch (Exception e) {
			      throw e;
			    } 
		}

		
	  //FunciÃ³n para recuperar una conexiÃ³n existente a la BBDD	
	  public static Connection getConnect() {
		  if (connect == null) 
			try {
				connectDatabase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return connect;
	  }
	  
	  //FunciÃ³n para cerrar conexiÃ³n a BBDD
	  public void cerrarConexion(){
		  connect = null;
	  }
} 
