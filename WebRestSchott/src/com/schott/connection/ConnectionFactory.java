package com.schott.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	 private static final String DRIVER = "org.postgresql.Driver";
	    private static final String URL_FPP = "jdbc:postgresql://localhost:5432/postgres";
	    private static final String USER_FPP = "postgres";
	    private static final String PASS_FPP = "danilo89";
	    
	    
	    public static Connection GetConnection(){
	        try {
	            Class.forName(DRIVER);
	            
	            return DriverManager.getConnection(URL_FPP, USER_FPP, PASS_FPP);
	            
	                } catch (ClassNotFoundException | SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	    }
	    
	    
	    public static void closeConnection(Connection con){
	        if(con!=null){
	            try {
	                con.close();
	            } catch(SQLException ex){
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	    

	    
	    public static void closeConnection(Connection con, PreparedStatement stmt){
	       if(stmt!=null){
	            try {
	                con.close();
	            } catch(SQLException ex){
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	            closeConnection(con);
	    }
	     
	   
	    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
	        if(rs!=null){
	            try {
	                con.close();
	            } catch(SQLException ex){
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	            closeConnection(con, stmt, rs);
	    }
}
