/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Michelle Armirola
 * Student ID: 22026985
 * Class: W64L
 * Date/Time created: Friday 28-07-2023 18:37
 */

/**
 * @author Michelle Armirola, 22026985
*/
public class User {
	private String username;
	private String email;
	private String password;
	private String contactNum;
	private String address;
	
	public User(String username, String email, String password, String contactNum, String address) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.contactNum = contactNum;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
