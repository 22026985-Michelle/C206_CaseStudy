public class ServiceProvider {

	private String spName;
	private String spEmail;
	private String numOfDeisgners;
	private String spPassword;
	private int spId;
	private String spContact;	
	private static int nextspId = 1;
	
	public ServiceProvider(String spName, String spEmail, String spPassword, String numOfDeisgners, String spContact ) {
		this.spName = spName;
		this.spEmail = spEmail;
		this.spPassword = spPassword;
		this.numOfDeisgners = numOfDeisgners;
		this.spContact = spContact;
		this.spId = nextspId;
		
		nextspId++;
	}
	
	public boolean login(String username, String password) {
		if (username.equals(getSpName()) && password.equals(getSpPassword())) {
			return true;
		}
		return false;
	}
	public String toString() {
		
		// Write your codes here
		String userInfo = String.format("%-5s %-20s %-30s %-15s %-20s %-10s",
				spId,
				spName,
				spEmail,
				spPassword, 
				numOfDeisgners, 
				spContact);
		
		return userInfo;
	}

	public String getSpName() {
		return spName;
	}

	public String getSpEmail() {
		return spEmail;
	}

	public void setSpEmail(String spEmail) {
		this.spEmail = spEmail;
	}

	public String getSpServiceDescription() {
		return numOfDeisgners;
	}

	public String getSpPassword() {
		return spPassword;
	}

	public void setSpPassword(String spPassword) {
		this.spPassword = spPassword;
	}

	public int getSpId() {
		return spId;
	}
	
	
}
