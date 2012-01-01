package SWE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SWE.models.Article;
import SWE.hsqldb.Database;

public class ArticleDAO {
	
	public ArticleDAO() {
		
	}
	
	public void saveArticle(Article a) {
		
	}
	
	public List<Article> recentArticles() {
		
		Database db = new Database();
		List<Article> recent = new ArrayList<Article>();
		
		try
	    {
			Statement stmt = db.con.createStatement(); 
			// Alle Kunden ausgeben
			ResultSet rs = stmt.executeQuery("SELECT * FROM articles;"); 
			
			while (rs.next()) {
		        Article article = new Article();
		        article.setId(rs.getInt("id"));
		        article.setBezeichnung(rs.getString("bezeichnung"));
		        article.setPreis(rs.getDouble("preis"));
		        article.setSofortkauf(rs.getBoolean("sofortkauf"));
		        article.setDatum(rs.getDate("datum"));
		        recent.add(article);
		    }
			
			// Resultset schlieﬂen
			rs.close(); 
			// Statement schlieﬂen
			stmt.close();
	    }
	    catch ( SQLException e )
	    {
	    	e.printStackTrace();
	    }
		
		return recent;
	}
	
	
	public Article getArticleById(int id){
		Database db = new Database();
		Article article = null;
		
		try
	    {
			Statement stmt = db.con.createStatement(); 
			// Alle Kunden ausgeben
			ResultSet rs = stmt.executeQuery("SELECT * FROM articles WHERE id = " + id + ";"); 
			
			rs.next();
			
			article = new Article();
	        
		    article.setId(rs.getInt("id"));
	        article.setBezeichnung(rs.getString("bezeichnung"));
	        article.setPreis(rs.getDouble("preis"));
	        article.setSofortkauf(rs.getBoolean("sofortkauf"));
	        article.setDatum(rs.getDate("datum"));
			
			// Resultset schlieﬂen
			rs.close();
			// Statement schlieﬂen
			stmt.close();
	    }
	    catch ( SQLException e )
	    {
	    	e.printStackTrace();
	    }
		
		return article;
	}
	
	public Article getArticlesByName(String name) {
		Database db = new Database();
		Article article = null;
		
		try
	    {
			Statement stmt = db.con.createStatement(); 
			// Alle Kunden ausgeben
			ResultSet rs = stmt.executeQuery("SELECT * FROM articles WHERE bezeichnung = " + name + ";"); 
			
			rs.next();
			
			article = new Article();
	        
		    article.setId(rs.getInt("id"));
	        article.setBezeichnung(rs.getString("bezeichnung"));
	        article.setPreis(rs.getDouble("preis"));
	        article.setSofortkauf(rs.getBoolean("sofortkauf"));
	        article.setDatum(rs.getDate("datum"));
			
			// Resultset schlieﬂen
			rs.close();
			// Statement schlieﬂen
			stmt.close();
	    }
	    catch ( SQLException e )
	    {
	    	e.printStackTrace();
	    }
		
		return article;
	}
	
}
