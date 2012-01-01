package SWE.models;

/**
 * java -cp lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 laptopshop
 * 
 */

import java.sql.Date;

public class Article {

	private Integer id;
	private String bezeichnung;
	private double preis;
	private boolean sofortkauf;
	private Date datum;

	public Article() {
		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getID(){
		return id;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung()	{
		return bezeichnung;
	}
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public double getPreis()	{
		return preis;
	}
	
	public void setSofortkauf(boolean sofortkauf) {
		this.sofortkauf = sofortkauf;
	}
	
	public boolean getSofortkauf()	{
		return sofortkauf;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Date getDatum()	{
		return datum;
	}

}
