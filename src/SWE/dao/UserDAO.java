package SWE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SWE.hsqldb.Database;
import SWE.models.User;

public class UserDAO {

	public UserDAO() {
		
	}
	
	public int saveUser(User u) {
		Database db = new Database();
		
		try
	    {
	      Statement stmt = db.con.createStatement(); 
	 
	      // Insert ausf¸hren
	      int i = stmt.executeUpdate("INSERT INTO users " +
	    		  "VALUES ('" + u.getUsername() + "','" + u.getPassword() + "','" + u.getVorname() + "','" + u.getNachname() + "');");
 
	      // Statement schlieﬂen
	      stmt.close();
	      
	      return i;
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }
		
		return -1;
	}
	
	public boolean checkLogin(String username, String pw)	
	{
		Database db = new Database();
		
		try
	    {
	      Statement stmt = db.con.createStatement(); 
	 
	      // Alle Kunden ausgeben
	      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS c FROM users " +
	      		"WHERE username = '" + username + 
	    		"' AND pw = '" + pw + "';"); 
	      rs.next();

		  int count = rs.getInt("c") ;

		  // Resultset schlieﬂen
	      rs.close(); 
	      // Statement schlieﬂen
	      stmt.close();
		  
		  if(count != 0)
		  {
			  return true;
		  }
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }
		
		return false;
	}
}
