import java.util.ArrayList;

public class C206_CaseStudy {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	private static ArrayList<ServiceProvider> sPList = new ArrayList<ServiceProvider>();

	public static void main(String[] args) {

		userList.add(new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28"));
		userList.add(new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09"));
		userList.add(new User("Celine", "celine@yahoo.com", "password3", "95726174",
				"Tampines 53 Pan Pacific Drive #11-35"));
		userList.add(new User("Daniel", "daniel@yahoo.com", "password4", "82910569",
				"Sengkang St 54 Rochester Drive #09-08"));
		userList.add(
				new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08"));
		adminList.add(new Administrator("robert", "robert@gmail.com", "p"/* "adpassword1" */));
		adminList.add(new Administrator("thomas", "thomas@gmail.com", "adpassword2"));
		adminList.add(new Administrator("bom", "bom@gmail.com", "adpassword3"));
		sPList.add(new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1",
				"Renovation Description A"));
		sPList.add(new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2",
				"Renovation Description B"));

		int option = 0;
		int opt1 = 0;

		while (option != 3) {

			mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

				while (option != 4) {
					loginMenu();
					opt1 = Helper.readInt("Enter an option > ");
					if (opt1 == 1) {
						User loginAccUser = getLoginAccountUser(userList);
						if (loginAccUser != null) {
							runUser(loginAccUser);
						}
					} else if (opt1 == 2) {
						Administrator loginAccAdmin = getLoginAccountAdmin(adminList);
						if (loginAccAdmin != null) {
							runAdmin(loginAccAdmin);
						}
					} else if (opt1 == 3) { // Login as Service Provider (Iz)
						ServiceProvider loginAccSP = getLoginAccountSP(sPList);
						runsP(loginAccSP);

					} else if (opt1 == 4) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}

			} else if (option == 2) {
				runVisitor();
			} else if (option == 3) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
	}

	private static void runUser(User loginAcc) {
		int memberOption = -1;

		while (memberOption != 4) {
			userMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == 1) {
				// View renovation services

			} else if (memberOption == 2) {
				// Create a new User account
				User ur = inputUser();
				C206_CaseStudy.addUser(userList, ur);
				System.out.println("User added");
			} else if (memberOption == 3) {
				// Request quote

			} else if (memberOption == 4) {
				System.out.println("Logging out.");
			}
		}
	}

	private static void runAdmin(Administrator loginAcc) {
		int memberOption = -1;

		while (memberOption != 4) {
			adminMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == 1) {
				// View users
				viewAllUsers(userList);
			} else if (memberOption == 2) {
				// Search for a user
				int opt = Helper.readInt("Search by 1. Username or 2. ID? > ");
				if (opt == 1) {
					searchUsernameUser(userList);
				} else {
					searchIdUser(userList);
				}
			} else if (memberOption == 3) {
				// Delete a user
				deleteUser(userList);
			} else if (memberOption == 4) {
				System.out.println("Logging out.");
			}
		}
	}
	
	private static void runsP(ServiceProvider loginAcc) {
		int sPOption = -1;

		while (sPOption != 4) {
			sPMenu();
			sPOption = Helper.readInt("Enter choice > ");

			if (sPOption == 1) {
				// Manage Quotes (Edmund)
				//Option 1: View Quotes
				//Option 2: Reply Quotes
				System.out.println("Test 1");
				
			} else if (sPOption == 2) {
				// Manage Appoinment (Cheryl)
				//Option 1: View Appoinment
				//Option 2: Add Appoinment
				//Option 3: Delete Appoinment
				System.out.println("Test 2");
			} else if (sPOption == 3) {
				// Manage Appoinment Request (Xavier)
				//Option 1: View Appoinment Request
				//Option 2: Add Appoinment Request
				//Option 3: Delete Appoinment Request
				System.out.println("Test 3");
			} else if (sPOption == 4) {
				System.out.println("Logging out.");
			}
		}
	}

	private static void runVisitor() {
		int memberOption = -1;

		while (memberOption != 3) {
			visitorMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == 1) {
				// View renovation services

			} else if (memberOption == 2) {
				// Create a new User account
				User ur = inputUser();
				C206_CaseStudy.addUser(userList, ur);
				System.out.println("User added");
			} else if (memberOption == 3) {
				System.out.println("Returning to main menu...");
			}
		}
	}

	private static User getLoginAccountUser(ArrayList<User> userList) {
		User loginAcc = null;
		String inputUsername = Helper.readString("Username > ");
		String inputPassword = Helper.readString("Password > ");

		for (User ur : userList) {
			if (ur.login(inputUsername, inputPassword) == true) {
				loginAcc = ur;
				break;
			} else {
				System.out.println("Invalid username or password!");
				break;
			}
		}
		return loginAcc;
	}

	private static Administrator getLoginAccountAdmin(ArrayList<Administrator> adminList) {
		Administrator loginAcc = null;
		String inputUsername = Helper.readString("Username > ");
		String inputPassword = Helper.readString("Password > ");

		for (Administrator ad : adminList) {
			if (ad.login(inputUsername, inputPassword) == true) {
				loginAcc = ad;
				break;
			} else {
				System.out.println("Invalid username or password!");
				break;
			}
		}
		return loginAcc;
	}

	private static ServiceProvider getLoginAccountSP(ArrayList<ServiceProvider> sPList) {
		ServiceProvider loginAcc = null;
		String inputUsername = Helper.readString("Username > ");
		String inputPassword = Helper.readString("Password > ");
		for (ServiceProvider sp : sPList) {
			if (sp.login(inputUsername, inputPassword) == true) {
				loginAcc = sp;
				break;
			} else {
				System.out.println("Invalid username or password!");
				break;
			}
		}
		return loginAcc;
	}

	private static void mainMenu() {
		// Write code here for the mainMenu method.
		Helper.line(80, "-");
		System.out.println("WELCOME TO RENOVATION PORTAL APP");
		Helper.line(80, "-");
		System.out.println("1. Log in\n2. Continue as a Visitor\n3. Quit");
		Helper.line(80, "-");
	}

	public static void loginMenu() {
		Helper.line(80, "-");
		System.out.println("1. Log in as User\n2. Log in as Administrator\n3. Log in as Service Provider\n4. Quit");
		Helper.line(80, "-");

	}

	// Log in as Administrator
	public static void adminMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, ADMIN");
		System.out.println("1. View all users");
		System.out.println("2. Search for a user by username or id");
		System.out.println("3. Delete a user");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	// Log in as User
	public static void userMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, USER");
		System.out.println("1. View Renovation Services");
		System.out.println("2. Create a new User account");
		System.out.println("3. Request quote"); // add in more options
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	// Log in as Service Provider
	public static void sPMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, SERVICE PROVIDER");
		System.out.println("1. Manage Quotes");
		System.out.println("2. Manage Appoinment"); 
		System.out.println("3. Manage Appoinment Request");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	// Continue as Guest
	public static void visitorMenu() {
		C206_CaseStudy.setHeader("WELCOME, VISITOR");
		System.out.println("1. View Renovation Services");
		System.out.println("2. Register as a User");
		System.out.println("3. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 View (CRUD - Read)
	// ========================================

	// ========================= Option 1 View Users =========================
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-84s \n", userList.get(i).toString());
		}
		return output;
	}
	
	

	public static void viewAllUsers(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		if (userList.isEmpty()) {
			System.out.println("No users available");
		} else {
			String output = String.format("%-5s %-10s %-20s %-10s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
					"CONTACT NUMBER", "ADDRESS");
			output += retrieveAllUsers(userList);
			System.out.println(output);
		}
	}
	

	// ================================= Option 2 Add (CRUD -
	// Create)=================================

	// ========================= Option 2 Add User =============================
	public static User inputUser() {
		String username = Helper.readString("Enter username > ");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter password > ");
		String contactNum = Helper.readString("Enter contact number > ");
		String address = Helper.readString("Enter address > ");

		User ur = new User(username, email, password, contactNum, address);
		return ur;
	}

	public static void addUser(ArrayList<User> userList, User ur) {
		User user;
		for (int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getUrUsername().equalsIgnoreCase(ur.getUrUsername()))
				return;
		}
		userList.add(ur);
		System.out.println("Registration successful!");

	}
	// ================================= Option 3 Loan (CURD-
	// Update)=================================

	// ========================= Option 3 Delete User =========================
	public static boolean searchUsernameUser(ArrayList<User> userList) {
		boolean successUN = false;
		String output = String.format("%-5s %-10s %-20s %-10s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
				"CONTACT NUM", "ADDRESS");
		String username = Helper.readString("Enter username > ");

		for (User ur : userList) {
			if (ur.getUrUsername().equalsIgnoreCase(username)) {
				output += String.format("%-84s \n", ur.toString());

				successUN = true;
			}

		}
		if (successUN == true) {
			System.out.println(output);
		}
		if (successUN == false) {
			System.out.println("Invalid user!");
		}
		return successUN;
	}

	public static boolean searchIdUser(ArrayList<User> userList) {
		boolean success = false;
		String output = String.format("%-5s %-10s %-20s %-10s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
				"CONTACT NUM", "ADDRESS");
		int id = Helper.readInt("Enter the ID of user > ");

		for (User ur : userList) {
			if (id == (ur.getUrId())) {
				output += String.format("%-84s \n", ur.toString());

				success = true;
			}

		}
		if (success == true) {
			System.out.println(output);
		}
		if (success == false) {
			System.out.println("Invalid user!");
		}
		return success;
	}

	public static void deleteUser(ArrayList<User> userList) {
		boolean success = false;
		boolean success1 = false;
		viewAllUsers(userList);

		int id = Helper.readInt("Enter the ID user to delete > ");
		id--;
		for (User ur : userList) {
			if (id == ur.getUrId()) {
				String option = String.format(Helper.readString("Delete user %d? (Y/N) > "), ur.getUrId());
				if (option.equalsIgnoreCase("Y")) {
					String confirm = String.format(Helper.readString("Confirm deletion of user %d? (Y/N) > "),
							ur.getUrId());
					if (confirm.equalsIgnoreCase("Y")) {
						userList.remove(ur.getUrId());
						System.out.println("\nUser successfully deleted!");
						success = true;

					}
				}
				success1 = true;
			}

		}
		if (success == false) {
			System.out.println("Deletion aborted.");
		}
		if (success1 == false) {
			System.out.println("Invalid user!");
		}

	}

}
