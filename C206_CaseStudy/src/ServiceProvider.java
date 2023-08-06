
public class ServiceProvider {

	private String spName;
	private String spEmail;
	private String spServiceDescription;
	private String spPassword;
	private int spId;
	private static int nextspId = 1;
	
	public ServiceProvider(String spName, String spEmail, String spPassword, String spServiceDescription ) {
		this.spName = spName;
		this.spEmail = spEmail;
		this.spPassword = spPassword;
		this.spServiceDescription = spServiceDescription;
		this.spId = nextspId;
		nextspId++;
	}
	
	public boolean login(String username, String password) {
		if (username.equals(getSpName()) && password.equals(getSpPassword())) {
			return true;
		}
		return false;
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
		return spServiceDescription;
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
