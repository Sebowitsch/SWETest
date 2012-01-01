package SWE.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SWE.models.Article;

public class Database {

	public Connection con = null;
	
	public Database() {
		//Connection aufbauen
		try
	    {
	        // Treiberklasse laden
			Class.forName("org.hsqldb.jdbcDriver");
	    }
	    catch ( Exception e )
	    {
	      System.err.println( "Treiberklasse nicht gefunden!");
	      e.printStackTrace();
	      return;
	    }  
	 
	    try
	    {
	      con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/laptopshop", "SA", "");
	    }
	    catch( SQLException e )
	    {
	        e.printStackTrace();
	    }
	}
	
	protected void finalize() throws Throwable
	{
		if ( con != null )
	    {
	        try 
	        {
	            con.close();
	        } 
	        catch ( SQLException e ) 
	        {
	            e.printStackTrace();
	        }
	    }
	}
	
	public boolean checkUsername(String username, String pw)
	{
		try
	    {
	      Statement stmt = con.createStatement(); 
	 
	      // Alle Kunden ausgeben
	      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM users " +
	      		"WHERE username = " + username + 
	    		" AND pw = " + pw + ";"); 
	      rs.next();

		  int count = rs.getInt("count") ;

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
