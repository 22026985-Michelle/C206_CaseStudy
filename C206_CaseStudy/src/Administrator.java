/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Michelle Armirola
 * Student ID: 22026985
 * Class: W64L
 * Date/Time created: Friday 28-07-2023 21:57
 */

/**
 * @author Michelle Armirola, 22026985
*/
public class Administrator {
	private int adId;
	private String adUsername;
  	private String adEmail;
  	private String adPassword;
  	
	public Administrator(String adUsername, String adEmail, String adPassword) {
		this.adId = 0;
		this.adUsername = adUsername;
		this.adEmail = adEmail;
		this.adPassword = adPassword;
	}
	
	public boolean login(String username, String password) {
		if (username.equals(getAdUsername()) && password.equals(getAdPassword())) {
			return true;
		}
		return false;
	}

	public String getAdUsername() {
		return adUsername;
	}

	public void setAdUsername(String adUsername) {
		this.adUsername = adUsername;
	}

	public String getAdEmail() {
		return adEmail;
	}

	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	public String getAdPassword() {
		return adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	public int getAdId() {
		return adId;
	}
  	
  	
}
