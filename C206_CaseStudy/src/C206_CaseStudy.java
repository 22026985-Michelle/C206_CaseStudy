import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {
	
	private static final int ADMIN_OPTION_SEARCH_USER_USERNAME = 1;
	private static final int VISITOR_OPTION_CREATE_USER = 2;
	private static final int VISITOR_OPTION_QUIT = 3;
	private static final int ADMIN_OPTION_DELETE_USER = 3;
	private static final int ADMIN_OPTION_SEARCH_USER = 2;
	private static final int ADMIN_OPTION_VIEW_USERS = 1;
	private static final int ADMIN_OPTION_QUIT = 7;
	private static final int USER_OPTION_ADD_USER = 2;
	private static final int USER_OPTION_QUIT = 6;
	private static final int LOGIN_OPTION_ADMINISTRATOR = 2;
	private static final int MAINMENU_OPTION_LOGIN = 1;
	private static final int LOGIN_OPTION_USER = 1;
	private static final int LOGIN_OPTION_QUIT = 4;
	private static final int MAINMENU_OPTION_VISITOR = 2;
	private static final int MAINMENU_OPTION_QUIT = 3;
	private static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH); // Date time format
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	private static ArrayList<ServiceProvider> serviceProviderList = new ArrayList<ServiceProvider>();
	private static ArrayList<Quote> quoteList = new ArrayList<Quote>();
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	private static int loggedUrID = 0; // Keep track of which user is logged in
	private static int loggedSpID = 0; // Keep track of which service provider is logged in

	public static void main(String[] args) {

		userList.add(new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28"));
		userList.add(new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09"));
		userList.add(new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35"));
		userList.add(new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08"));
		userList.add(new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08"));
		adminList.add(new Administrator("robert", "robert@gmail.com", "p"/*"adpassword1"*/));
		adminList.add(new Administrator("thomas", "thomas@gmail.com", "adpassword2"));
		adminList.add(new Administrator("bom", "bom@gmail.com", "adpassword3"));
		serviceProviderList.add(new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", "Renovation Description A"));
		serviceProviderList.add(new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2","Renovation Description B"));

		int option = 0;
		int opt1 = 0;

		while (option != MAINMENU_OPTION_QUIT) {

			mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == MAINMENU_OPTION_LOGIN) {

				while (option != LOGIN_OPTION_QUIT) {
					
					loginMenu();
					opt1 = Helper.readInt("Enter an option > ");
					
					if (opt1 == LOGIN_OPTION_USER) {
						User loginAccUser = getLoginAccountUser(userList);
						if (loginAccUser != null) {
							runUser(loginAccUser);
							loggedUrID = loginAccUser.getUrId();
						}
					} else if (opt1 == LOGIN_OPTION_ADMINISTRATOR) {
						Administrator loginAccAdmin = getLoginAccountAdmin(adminList);
						if (loginAccAdmin != null) {
							runAdmin(loginAccAdmin);
						}
					} else if (opt1 == 3) { // Login as Service Provider (Iz)
						ServiceProvider loginAccSP = getLoginAccountServiceProvider(serviceProviderList);
						if (loginAccSP != null) {
							runServiceProvider(loginAccSP);
							loggedSpID = loginAccSP.getSpId();
						}
					} else if (opt1 == LOGIN_OPTION_QUIT) {
						System.out.println("Returning to main menu...");
						break;
					} else {
						System.out.println("Invalid option");
					}
				}

			} else if (option == MAINMENU_OPTION_VISITOR) {
				runVisitor();
			} else if (option == MAINMENU_OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
	}

	private static void runUser(User loginAcc) {
		int memberOption = -1;

		while (memberOption != USER_OPTION_QUIT) {
			userMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == 1) {
				// View renovation services (Thiha)
				
			} else if (memberOption == USER_OPTION_ADD_USER) {
				// Create a new User account
				User ur = inputUser();
				C206_CaseStudy.addUser(userList, ur);
			} else if (memberOption == 3) {
				// Request quote (Edmund)
				addQuote(serviceProviderList, quoteList);
			} else if (memberOption == 4){
				// View quote
				viewQuote(quoteList);
			}else if (memberOption == 5){
				// View appointment
				
			}else if (memberOption == USER_OPTION_QUIT) {
			
				System.out.println("Logging out.");
			}
		}
	}

	private static void runAdmin(Administrator loginAcc) {
		int memberOption = -1;

		while (memberOption != ADMIN_OPTION_QUIT) {
			adminMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == ADMIN_OPTION_VIEW_USERS) {
				// View users
				viewAllUsers(userList);
			} else if (memberOption == ADMIN_OPTION_SEARCH_USER) {
				// Search for a user
				int opt = Helper.readInt("Search by 1. Username or 2. ID? > ");
				if (opt==ADMIN_OPTION_SEARCH_USER_USERNAME) {
					searchUsernameUser(userList);
				}
				else {
					searchIdUser(userList);
				}
			} else if (memberOption == ADMIN_OPTION_DELETE_USER) {
			    // Delete a user
		        User userToDelete = inputUserToDelete(userList);
		        C206_CaseStudy.deleteUser(userList, userToDelete);
			} else if (memberOption == 4) { //View all service providers
				viewAllServiceProviders(serviceProviderList);
				
			}else if (memberOption == 5) { //Add service providers
				ServiceProvider SP = inputServiceProvider();
				C206_CaseStudy.addServiceProvider(serviceProviderList, SP);
				System.out.println("Service Provider added");
				
			}else if (memberOption == 6) { //delete service providers
				ServiceProvider serviceProviderToDelete = inputServiceProviderToDelete(serviceProviderList);
		        C206_CaseStudy.deleteServiceProvider(serviceProviderList, serviceProviderToDelete);
				
			}else if (memberOption == 7) {
				System.out.println("Logging out.");
			}
		}
	}
	
	private static void runServiceProvider(ServiceProvider loginAcc) {
		int serviceproviderOption = -1;

		while (serviceproviderOption != 6) {
			serviceProviderMenu();
			serviceproviderOption = Helper.readInt("Enter choice > ");

		   	} if (serviceproviderOption == 1) {
				// Manage Appoinment (Cheryl)
				//Option 1: View Appoinment
				//Option 2: Add Appoinment
				//Option 3: Delete Appoinment

			} else if (serviceproviderOption == 2) {
				// Manage Appoinment Request (Xavier)
				runRequest();
				//Option 1: View Appoinment Request
				//Option 2: Add Appoinment Request
				//Option 3: Delete Appoinment Request
			}else if (serviceproviderOption == 3) {
				viewServiceSP(serviceList, loggedSpID);
			}else if (serviceproviderOption == 4) {
				addService(serviceList, loggedSpID);
			}else if (serviceproviderOption == 5) {
				deleteService(serviceList, loggedSpID);
			} else if (serviceproviderOption == 6) {
				System.out.println("Logging out.");
			}
		}

	private static void runRequest() {
		
		int requestOption = -1;

		while (requestOption != 4) {
		    requestMenu();
		    requestOption = Helper.readInt("Enter choice > ");

		    if (requestOption == 1) {
				C206_CaseStudy.addRequest(serviceProviderList, requestList);
		    }
		    
		    else if (requestOption == 2) {
		    	viewAllRequests(requestList);
		    }

		    else if (requestOption == 3) {
		       
		    }
		    
		    else if (requestOption == 4) {
				System.out.println("Exiting request menu...");
		    }
		}
	}
	
	private static void runVisitor() {
		int memberOption = -1;

		while (memberOption != VISITOR_OPTION_QUIT) {
			visitorMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == 1) {
				// View renovation services (Thiha)

			} else if (memberOption == VISITOR_OPTION_CREATE_USER) {
				// Create a new User account
				User ur = inputUser();
				C206_CaseStudy.addUser(userList, ur);
			} else if (memberOption == VISITOR_OPTION_QUIT) {
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
	        }
	    }
	    if (loginAcc == null) {
	        System.out.println("Invalid username or password!");
	    }
	    return loginAcc;
	}

	private static Administrator getLoginAccountAdmin(ArrayList<Administrator> adminList) {
		Administrator loginAcc = null;
		String inputUsername = Helper.readString("Username > ");
		String inputPassword = Helper.readString("Password > ");
		
		for (Administrator ad : adminList) {
			if (ad.login(inputUsername, inputPassword)==true) {
				loginAcc = ad;
				break;
			}
		}
		if (loginAcc == null) {
			System.out.println("Invalid username or password!");
		}
		return loginAcc;
	}
	

	private static ServiceProvider getLoginAccountServiceProvider(ArrayList<ServiceProvider> serviceProviderList) {
		ServiceProvider loginAcc = null;
		String inputUsername = Helper.readString("Name > ");
		String inputPassword = Helper.readString("Password > ");
		for (ServiceProvider sp : serviceProviderList) {
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
		System.out.println("3. Delete a user by username or id");
		System.out.println("4. View all Service Providers");
		System.out.println("5. Add a Service Provider");
		System.out.println("6. Delete a Service Provider");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

	// Log in as User
	public static void userMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, USER");
		System.out.println("1. View Renovation Services");
		System.out.println("2. Create a new User account");
		System.out.println("3. Request Quote"); // add in more options
		System.out.println("4. View Quotes");
		System.out.println("5. View Appointments");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}
	 
	// Log in as Service Provider
	public static void serviceProviderMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, SERVICE PROVIDER");
		System.out.println("1. Manage Appointment"); 
		System.out.println("2. Manage Appointment Request");
		System.out.println("3. View Services");
		System.out.println("4. Add Services");
		System.out.println("5. Delete Services");
		System.out.println("6. Quit");
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
	
	// Managing Appointment Requests
	public static void requestMenu() {
		C206_CaseStudy.setHeader("MANAGE APPOINTMENT REQUESTS");
		System.out.println("1. Add New Appointment Request");
		System.out.println("2. View Appointment Requests");
		System.out.println("3. Delete Appointment Request");
		System.out.println("4. Quit");
		Helper.line(80, "-");
    }

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 View (CRUD - Read) ========================================

	// ========================= Option 1 View Users ========================= (Michelle)
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-84s\n", userList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllUsers(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		if (userList.isEmpty()) {
			System.out.println("No users available");
		} else {
			String output = String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
					"CONTACT NUMBER", "ADDRESS");
			output += retrieveAllUsers(userList);
			System.out.println(output);
		}
	}
	

	// ================================= Option 2 Add (CRUD - Create)=================================

	// ========================= Option 2 Add User ============================= (Michelle)
	public static User inputUser() {
	    User ur;

	    String username;
	    do {
	        username = Helper.readString("Enter username > ");
	        if (!isUsernameUnique(userList, username)) {
	            System.out.println("Username " + username + " is already taken. Please choose a different username.\n");
	        }
	    } while (!isUsernameUnique(userList, username));

	    String email = Helper.readString("Enter email address > ");

	    String password;
	    do {
	        password = Helper.readString("Enter password > ");
	        if (!isStrongPassword(password)) {
	            System.out.println("Password is not strong enough. Please choose a stronger password.");
	            System.out.println("A strong password should have at least 8 characters and include at least one uppercase letter, one lowercase letter, \none digit, and one special character.\n");
	        }
	    } while (!isStrongPassword(password));

	    String contactNum;
	    do {
	        contactNum = Helper.readString("Enter contact number > ");
	        if (!isContactNumUnique(userList, contactNum)) {
	            System.out.println("Contact number " + contactNum + " is already registered.\n");
	        }
	    } while (!isContactNumUnique(userList, contactNum));

	    String address = Helper.readString("Enter address > ");

	    ur = new User(username, email, password, contactNum, address);
	    return ur;
	}
	
	public static void addUser(ArrayList<User> userList, User ur) {
		User user;
		for (int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getUrUsername().equals(ur.getUrUsername()))
				return;
		}
		userList.add(ur);
		System.out.println("\nRegistration successful!");

	}
	
	public static boolean isUsernameUnique(ArrayList<User> userList, String username) {
	    for (User user : userList) {
	        if (user.getUrUsername().equalsIgnoreCase(username)) {
	            return false; // Username is not unique
	        }
	    }
	    return true; // Username is unique
	}

	public static boolean isContactNumUnique(ArrayList<User> userList, String contactNum) {
	    for (User user : userList) {
	        if (user.getUrContactNum().equals(contactNum)) {
	            return false; // Contact number is not unique
	        }
	    }
	    return true; // Contact number is unique
	}

	public static boolean isStrongPassword(String password) {
	    // Define password strength criteria
	    int minLength = 8; // Minimum length of the password
	    boolean hasUppercase = false; // Whether the password has at least one uppercase letter
	    boolean hasLowercase = false; // Whether the password has at least one lowercase letter
	    boolean hasDigit = false; // Whether the password has at least one digit
	    boolean hasSpecialChar = false; // Whether the password has at least one special character

	    // Check password length
	    if (password.length() < minLength) {
	        return false;
	    }if (password.length()==0) {
	        return false;
	    }

	    // Check for character types
	    for (char ch : password.toCharArray()) {
	        if (Character.isUpperCase(ch)) {
	            hasUppercase = true;
	        } else if (Character.isLowerCase(ch)) {
	            hasLowercase = true;
	        } else if (Character.isDigit(ch)) {
	            hasDigit = true;
	        } else {
	            hasSpecialChar = true;
	        }
	    }

	    // Check if all criteria are met
	    return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
	}

	// ================================= Option 3 Search =================================

	// ========================= Option 3 Search User ========================= (Michelle)
	public static boolean searchUsernameUser(ArrayList<User> userList) {
		boolean successUN = false;
		String output = String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
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
		String output = String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n", "ID", "USERNAME", "EMAIL", "PASSWORD",
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

	// ================================= Option 3 Delete (CRUD- Deletes)=================================
	
	// ========================= Option 3 Delete User ========================= (Michelle)
	
	public static User findUserById(ArrayList<User> userList, int id) {
	    for (User user : userList) {
	        if (user.getUrId() == id) {
	            return user;
	        }
	    }
	    return null;
	}

	public static User findUserByUsername(ArrayList<User> userList, String username) {
	    for (User user : userList) {
	        if (user.getUrUsername().equals(username)) {
	            return user;
	        }
	    }
	    return null;
	}	
	
	public static User inputUserToDelete(ArrayList<User> userList) {
	    viewAllUsers(userList);
	    int id = Helper.readInt("Enter the ID of the user to delete, or enter 0 to delete by username > ");
	    
	    if (id == 0) {
	        String username = Helper.readString("Enter username > ");
	        return findUserByUsername(userList, username);
	    } else {
	        return findUserById(userList, id);
	    }
	}

	public static void deleteUser(ArrayList<User> userList, User user) {
	    if (user != null) {
	        String option = Helper.readString("Delete user " + user.getUrId() + "? (Y/N) > ");
	        if (option.equalsIgnoreCase("Y")) {
	            String opt = Helper.readString("Confirm deletion of user " + user.getUrId() + "? (Y/N) > ");
	            if (opt.equalsIgnoreCase("Y")) {
	                userList.remove(user);
	                System.out.println("User with ID " + user.getUrId() + " deleted successfully.");
	            } else if (opt.equalsIgnoreCase("N")) {
	                System.out.println("Deletion aborted.");
	            } else {
	                System.out.println("Invalid input. Deletion aborted.");
	            }
	        } else if (option.equalsIgnoreCase("N")) {
	            System.out.println("Deletion aborted.");
	        } else {
	            System.out.println("Invalid input. Deletion aborted.");
	        }
	    } else {
	        System.out.println("User not found.");
	    }
	}
	
	// ======================================================================================================
	// ============================= Option 4 View Service Providers (READ) ================================= (Izdihar)
		public static String retrieveAllServcieProviders(ArrayList<ServiceProvider> serviceProviderList) {
			String output = "";
			for (int i = 0; i < serviceProviderList.size(); i++) {
				output += String.format("%-84s \n", serviceProviderList.get(i).toString());
			}
			return output;
		}
		
		public static void viewAllServiceProviders(ArrayList<ServiceProvider> serviceProviderList) {
			C206_CaseStudy.setHeader("SERVICE PROVIDER LIST");
			if (serviceProviderList.isEmpty()) {
				System.out.println("No Service Provider available");
			} else {
				String output = String.format("%-5s %-20s %-30s %-15s %-20s\n", "ID", "SP NAME", "EMAIL", "PASSWORD", "DESCRIPTION");
				output += retrieveAllServcieProviders(serviceProviderList);
				System.out.println(output);
			}
		}
		
	// ======================================================================================================
	// ===================================== Option 5 Add User (CREATE) ===================================== (Izdihar)
//		public static ServiceProvider inputServiceProvider() {
//			String username = Helper.readString("Enter username > ");
//			String email = Helper.readString("Enter email address > ");
//			String password = Helper.readString("Enter password > ");
//			String description = Helper.readString("Enter service description > ");
//
//			ServiceProvider SP = new ServiceProvider(username, email, password, description);
//			return SP;
//		}
		public static ServiceProvider inputServiceProvider() {
		    ServiceProvider sp;

		    String name;
		    do {
		    	name = Helper.readString("Enter Service Provider Name > ");
		        if (!isServiceProviderNameUnique(serviceProviderList, name)) {
		            System.out.println("Username " + name + " is already taken. Please choose a different username.\n");
		        }
		    } while (!isServiceProviderNameUnique(serviceProviderList, name));

		    String email = Helper.readString("Enter email address > ");

		    String password;
		    do {
		        password = Helper.readString("Enter password > ");
		        if (!isStrongPassword(password)) {
		            System.out.println("Password is not strong enough. Please choose a stronger password.");
		            System.out.println("A strong password should have at least 8 characters and include at least one uppercase letter, one lowercase letter, \none digit, and one special character.\n");
		        }
		    } while (!isContactNumUnique(userList, password));
		    String description = Helper.readString("Enter service description > ");

		    sp = new ServiceProvider(name, email, password, description );
		    return sp;
		}

		public static void addServiceProvider(ArrayList<ServiceProvider> serviceProviderList, ServiceProvider SP) {
			ServiceProvider serviceProvider;
			for (int i = 0; i < serviceProviderList.size(); i++) {
				serviceProvider = serviceProviderList.get(i);
				if (serviceProvider.getSpName().equalsIgnoreCase(SP.getSpName()))
					return;
			}
			serviceProviderList.add(SP);
			System.out.println("\nRegistration successful!");

		}
		
		public static boolean isServiceProviderNameUnique(ArrayList<ServiceProvider> serviceProviderList,String serviceProvider) {
			for (ServiceProvider sp : serviceProviderList) {
		        if (sp.getSpName().equalsIgnoreCase(serviceProvider)) {
		            return false; // Service Provider Name is not unique
		        }
		    }
		    return true; // Service Provider Name is unique
		}
		
		// ==================================================================================================
		// ============================== Option 6 Delete User (DELETE) ===================================== (Izdihar)
		
		public static ServiceProvider findServiceProviderById(ArrayList<ServiceProvider> serviceProviderList, int id) {
		    for (ServiceProvider serviceProvider : serviceProviderList) {
		        if (serviceProvider.getSpId() == id) {
		            return serviceProvider;
		        }
		    }
		    return null;
		}

		public static ServiceProvider findServiceProviderByName(ArrayList<ServiceProvider> serviceProviderList, String Name) {
			for (ServiceProvider serviceProvider : serviceProviderList) {
		        if (serviceProvider.getSpName().equals(Name)) {
		            return serviceProvider;
		        }
		    }
		    return null;
		}	
		
		public static ServiceProvider inputServiceProviderToDelete(ArrayList<ServiceProvider> serviceProviderList) {
			viewAllServiceProviders(serviceProviderList);
		    int id = Helper.readInt("Enter the ID of the Service Provider to delete, or enter 0 to delete by Name > ");
		    
		    if (id == 0) {
		        String Name = Helper.readString("Enter Name > ");
		        return findServiceProviderByName(serviceProviderList, Name);
		    } else {
		        return findServiceProviderById(serviceProviderList, id);
		    }
		}

		public static void deleteServiceProvider(ArrayList<ServiceProvider> serviceProviderList, ServiceProvider serviceProvider) {
		    if (serviceProvider != null) {
		        String option = Helper.readString("Delete Service Provider " + serviceProvider.getSpId() + "? (Y/N) > ");
		        if (option.equalsIgnoreCase("Y")) {
		            String opt = Helper.readString("Confirm deletion of Service Provider " + serviceProvider.getSpId() + "? (Y/N) > ");
		            if (opt.equalsIgnoreCase("Y")) {
		            	serviceProviderList.remove(serviceProvider);
		                System.out.println("User with ID " + serviceProvider.getSpId() + " deleted successfully.");
		            } else if (opt.equalsIgnoreCase("N")) {
		                System.out.println("Deletion aborted.");
		            } else {
		                System.out.println("Invalid input. Deletion aborted.");
		            }
		        } else if (option.equalsIgnoreCase("N")) {
		            System.out.println("Deletion aborted.");
		        } else {
		            System.out.println("Invalid input. Deletion aborted.");
		        }
		    } else {
		        System.out.println("Service Provider not found.");
		    }
		}
		
		// ======================================= Option 4 Add Quote ===================================== (Edmund)

		public static void addQuote(ArrayList<ServiceProvider> spList, ArrayList<Quote> quoteList) {
			boolean flag = false;
			while(!flag) {
				int serviceID = Helper.readInt("Input Service ID > ");
				for (ServiceProvider sp: spList) {
					if(serviceID == sp.getSpId()) {
						flag = true;
					}
				}
	
				if(flag) {
					String serviceType = Helper.readString("Input service type > ");
					String details = Helper.readString("Input details > ");
					double amount = Helper.readDouble("Input amount > ");
					Quote quote = new Quote(loggedUrID,serviceID, serviceType, details, amount);
					quoteList.add(quote);
					
					System.out.println("Quote succesfully added");
				}
			}
		}
		
		// ======================================= Option 5 View Quote ===================================== (Edmund)
		
		public static void viewQuote(ArrayList<Quote> quoteList) {
			String output = String.format("%-7s %-7s %-13s %-30s %-7s\n", "UR ID", "SP ID", "SERVICE TYPE", "DETAILS", "AMOUNT");
			if(!quoteList.isEmpty()) {
				for(Quote q: quoteList) {
					output += String.format("%-7d %-7d %-13s %-30s %-7.2f\n", q.getReqUrID(),q.getReqSpID(),q.getQuoteService(),q.getQuoteDetails(),q.getQuoteAmount());
				}
				System.out.println(output);
			}else {
				System.out.println("No Quotes");
			}
		}
		
		// ================================= Option 1 Add (CRUD - Create)=================================

		// ========================= Option 1 Add Appointment Request ============================= (Xavier)
		
		public static void addRequest(ArrayList<ServiceProvider> spList, ArrayList<Request> requestList) {
			boolean flag = false;
			
			while(!flag) {
				
				int spID = Helper.readInt("Enter Service Provider ID > ");
				
				for (ServiceProvider sp: spList) {
					
					if (spID == sp.getSpId()) {
						  flag = true;
					}
				}
	
				if (flag) {
					String newRequest = Helper.readString("Enter Date (dd/MM/yyyy format) > ");
					LocalDate requestDate = LocalDate.parse(newRequest, dtFormat);
					String serviceType = Helper.readString("Enter renovation service type > ");
					String details = Helper.readString("Enter details for enquired renovation service request > ");
					
//					Request request = new Request(loggedUrID, spID, requestDate, serviceType, details);
//					requestList.add(request);
					System.out.println("Request succesfully added");
				}
			}
		}
		
		// ================================= Option 2 View (CRUD - Read) ========================================

		// ========================= Option 2 View Appointment Requests ========================= (Xavier)
		
		public static String retrieveAllRequests(ArrayList<Request> requestList) {
			String output = "";

			for (int i = 0; i < requestList.size(); i++) {

				output += String.format("%-84s \n", requestList.get(i).toString());
			}
			return output;
		}
		
		public static void viewAllRequests(ArrayList<Request> requestList) {
			C206_CaseStudy.setHeader("APPOINTMENT REQUEST LIST");
			if (requestList.isEmpty()) {
				System.out.println("No requests available");
			} 
			
			else {
				String output = String.format("%-10s %-25s %-15s %-25s %-16s\n", "USER ID", "SERVICE PROVIDER ID", 
	                      "TIME SLOT", "SERVICE", "DETAILS");
				output += retrieveAllRequests(requestList);
				System.out.println(output);
			}
		}
		
		// ========================= View Services =========================
		
		private static void viewServiceSP(ArrayList<Service> sList, int loggedSp) {
			String output = String.format("%-7s %-15s\n", "SP ID", "SERVICES");
			int check = 0;
			if(!sList.isEmpty()) {
				for(Service s: sList) {
					if(s.getSpId() == loggedSp) {
					output += String.format("%-7d %-15s\n", s.getSpId(),s.getService());
					check++;
					}else if(check == 0) {
						System.out.println("There are no services assigned by you");
					}
 				}
				System.out.println(output);
			}else {
				System.out.println("No services available");
			}
		}
		
		// ========================= Add Services =========================
		
		private static void addService(ArrayList<Service> sList, int loggedSp) {
			String service = Helper.readString("Input service > ");
			
			sList.add(new Service(loggedSp, service));
			System.out.println("New service succesfully added");
		}
		// ========================= Delete Services =========================
		
		private static void deleteService(ArrayList<Service> sList, int loggedSp) {
			String output = String.format("%-7s %-15s\n", "SP ID", "SERVICES");
			int check = 0;
			int check2 = 0;
			if(!sList.isEmpty()) {
				for(Service s: sList) {
					if(s.getSpId() == loggedSp) {
					output += String.format("%-7d %-15s\n", s.getSpId(),s.getService());
					check++;
					}else if(check == 0) {
						System.out.println("There are no services assigned by you");
					}
 				}
				System.out.println(output);
				String selectDelete = Helper.readString("Type the service you wish to delete > ");
				for(Service s: sList) {
					if(selectDelete.equalsIgnoreCase(s.getService())) {
						sList.remove(s);
						check2++;
					}else if (check2 == 0) {
						System.out.println("No service found to delete");
					}
				}
			}else {
				System.out.println("No services available");
			}
		}
}
