package SWE.models;

public class User {
	
	private String username;
	private String pw;
	private String vorname;
	private String nachname;

	public User(String username, String pw, String vorname, String nachname) {
		this.username = username;
		this.pw = pw;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String pw) {
		this.pw = pw;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return pw;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
}
