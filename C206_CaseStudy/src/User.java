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
	private static int nextId = 1; // Static variable to keep track of the next ID
    private int urId;
	private String urUsername;
	private String urEmail;
	private String urPassword;
	private String urContactNum;
	private String urAddress;
	
	public User(String urUsername, String urEmail, String urPassword, String urContactNum, String urAddress) {
		this.urId = nextId; // Assign the current nextId value to urId
        nextId++; // Increment nextId for the next user
		this.urUsername = urUsername;
		this.urEmail = urEmail;
		this.urPassword = urPassword;
		this.urContactNum = urContactNum;
		this.urAddress = urAddress;
	}
	
	public String toString() {
		
		// Write your codes here
		String userInfo = String.format("%-5s %-10s %-35s %-20s %-16s %-20s",
				urId,
				urUsername,
				urEmail, 
				urPassword,
				urContactNum,
				urAddress);
		
		return userInfo;
	}
	
	public boolean login(String username, String password) {
		if (username.equals(getUrUsername()) && password.equals(getUrPassword())) {
			return true;
		}
		return false;
	}

	public String getUrUsername() {
		return urUsername;
	}

	public String getUrEmail() {
		return urEmail;
	}

	public void setUrEmail(String urEmail) {
		this.urEmail = urEmail;
	}

	public String getUrPassword() {
		return urPassword;
	}

	public void setUrPassword(String urPassword) {
		this.urPassword = urPassword;
	}

	public String getUrContactNum() {
		return urContactNum;
	}

	public void setUrContactNum(String urContactNum) {
		this.urContactNum = urContactNum;
	}

	public String getUrAddress() {
		return urAddress;
	}

	public void setUrAddress(String urAddress) {
		this.urAddress = urAddress;
	}

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}
	
}
