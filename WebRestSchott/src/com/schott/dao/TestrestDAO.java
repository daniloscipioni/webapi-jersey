package com.schott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.schott.connection.ConnectionFactory;

public class TestrestDAO {
	
private PreparedStatement stmt = null;
	
	
	
	public String returnErrorSql;
	
		
	public String getReturnErrorSql() {
		return returnErrorSql;
	}

	public void setReturnErrorSql(String returnErrorSql) {
		this.returnErrorSql = returnErrorSql;
	}


	
	public void InsertPost(String value1, String value2 )
    {  

		Connection con = ConnectionFactory.GetConnection();
		
        try {
            PreparedStatement stmt = con.prepareStatement("insert into test.tbl_testpost(value1,value2)values(?, ?)");
		    stmt.setString(1, value1);
			stmt.setString(2, value2);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
        
    }
	

}
