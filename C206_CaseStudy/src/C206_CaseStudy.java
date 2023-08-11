import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private static final int USER_OPTION_QUIT = 7;
	private static final int LOGIN_OPTION_ADMINISTRATOR = 2;
	private static final int MAINMENU_OPTION_LOGIN = 1;
	private static final int LOGIN_OPTION_USER = 1;
	private static final int LOGIN_OPTION_QUIT = 4;
	private static final int MAINMENU_OPTION_VISITOR = 2;
	private static final int MAINMENU_OPTION_QUIT = 3;
	private static final int ADMIN_OPTION_VIEW_SERVICES = 1;
	private static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH); // Date time format
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	private static ArrayList<ServiceProvider> serviceProviderList = new ArrayList<ServiceProvider>();
	private static ArrayList<Quote> quoteList = new ArrayList<Quote>();
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
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
		requestList.add(new Request(1, 1, "Bathroom", "Replace tiles", 400.00));
		appointmentList.add(new Appointment("Replace Tiles","Incomplete",LocalDate.parse("11/01/2023", dtFormat),"Appointment Description",3,1));
		appointmentList.add(new Appointment("Replace Pipes","Incomplete",LocalDate.parse("23/01/2023", dtFormat),"Appointment Description",3,1));
		appointmentList.add(new Appointment("Replace Walls","Incomplete",LocalDate.parse("11/02/2023", dtFormat),"Appointment Description",3,2));
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

			
			if (memberOption == ADMIN_OPTION_VIEW_SERVICES) {
				// View renovation services (Thiha) 
				viewServiceSP(serviceList, loggedSpID);
			} else if (memberOption == USER_OPTION_ADD_USER) {
				// Create a new User account
				User ur = inputUser();
				C206_CaseStudy.addUser(userList, ur);
			} else if (memberOption == 3) {
				// Send Request
				addRequest(serviceProviderList, serviceList, requestList);
			} else if (memberOption == 4){
				// View Request
				viewAllRequests(requestList);
			}else if (memberOption == 5){
				// Delete Request
				deleteRequest(requestList, loggedUrID);
			}else if (memberOption == 6){
				// View appointment (Create user view for appointments)
				viewAppointmentsUr(appointmentList,loggedUrID);
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
		int serviceproviderOption1 = -1;

		while (serviceproviderOption != 6) {
			serviceProviderMenu();
			serviceproviderOption = Helper.readInt("Enter choice > ");

		   	if (serviceproviderOption == 1) {
		   		
		   		while (serviceproviderOption1!=5) {
		   			
		   	  		serviceproviderOption1= Helper.readInt("Enter choice > ");
		  
		   		if(serviceproviderOption1 ==1) {
		   		//Option 1: View Appointment
		   			viewAppointmentsSP(appointmentList,loggedSpID);
		   		}
		   		else if (serviceproviderOption1==2) {
		   		//Option 2: Add Appointment
		   			addAppointment(appointmentList,loggedSpID);
		   		}
		   		else if (serviceproviderOption1==3) {
		   		//Option 3: Delete Appointment
		   			deleteApppointment(appointmentList ,loggedSpID);
		   		}
		   		else if (serviceproviderOption==4) {
		   		//Option 4: Update Appointment (select field to edit and select record to edit)	
		   			updateAppointment(appointmentList,loggedSpID);
		   		}
		   		
		   		else if (serviceproviderOption==5) {
		   		// Option 5 : Quit	
		   			System.out.println("Exiting appointment menu...");
		   		}
		   		
		   		}

			} else if (serviceproviderOption == 2) {
				// Manage Quotes (Edmund)
				quoteMenu();
				int quoteChoice = Helper.readInt("Select option > ");
				if(quoteChoice == 1) {
					addQuote(userList, quoteList, requestList);
				}else if (quoteChoice == 2) {
					viewQuote(quoteList);
				}else if (quoteChoice == 3) {
					deleteQuote(quoteList);
				}else {
					System.out.println("Invalid Choice");
				}

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
		
		}
	
	private static void runVisitor() {
		int memberOption = -1;

		while (memberOption != VISITOR_OPTION_QUIT) {
			visitorMenu();
			memberOption = Helper.readInt("Enter choice > ");

			if (memberOption == ADMIN_OPTION_VIEW_SERVICES) {
				// View renovation services (Thiha)
				viewServiceSP(serviceList, loggedSpID);
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
				} 
			}
			if (loginAcc == null) {
				System.out.println("Invalid username or password!");
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
		System.out.println("3. Make Request"); // add in more options
		System.out.println("4. View Request");
		System.out.println("5. Delete Request");
		System.out.println("6. View Appointments");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}
	 
	// Log in as Service Provider
	public static void serviceProviderMenu() {
		C206_CaseStudy.setHeader("WELCOME BACK, SERVICE PROVIDER");
		System.out.println("1. Manage Appointments"); 
		System.out.println("2. Manage Request and Quotes");
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

	public static void quoteMenu() {
		C206_CaseStudy.setHeader("MANAGE QUOTES");
		System.out.println("1. Add New Quote");
		System.out.println("2. View Quote");
		System.out.println("3. Delete Quote");
		System.out.println("4. Quit");
		Helper.line(80, "-");
    }
	
	public static void appointmentMenu() {
		C206_CaseStudy.setHeader("MANAGE APPOINTMENTS");
		System.out.println("1. View Appointments");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Update Appointment");
		System.out.println("5. Quit");
		Helper.line(80, "-");
		
	}
	
	public static void  updateAppMenu() {
		C206_CaseStudy.setHeader("UPDATE APPOINTMENT RECORD");
		System.out.println("1. Update Appointment Status");
		System.out.println("2. Update Appointment Date");
		System.out.println("3. Update Appointment Description");
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
	        if (username.isEmpty()) {
	            System.out.println("Username cannot be left blank! Please input a username.\n");
	        } else if (!isUsernameUnique(userList, username)) {
	            System.out.println("Username " + username + " is already taken. Please choose a different username.\n");
	        }
	    } while (username.isEmpty() || !isUsernameUnique(userList, username));

	    String email;
	    do {
	        email = Helper.readString("Enter email > ");
	        if (email.isEmpty()) {
	            System.out.println("Email cannot be left blank! Please input an email.\n");
	        } else if (!isValidEmail(email)) {
	            System.out.println("Email " + email + " does not contain '@' and '.'. Please give a different email.\n");
	        }
	    } while (!isValidEmail(email));

	    String password;
	    do {
	        password = Helper.readString("Enter password > ");
	        if (password.isEmpty()) {
	            System.out.println("Password cannot be left blank! Please input a password.\n");
	        } else if (!isStrongPassword(password)) {
	            System.out.println("Password is not strong enough. Please choose a stronger password.");
	            System.out.println("A strong password should have at least 8 characters and include at least one uppercase letter,"
	                    + " one lowercase letter, \none digit, and one special character.\n");
	        }
	    } while (password.isEmpty() || !isStrongPassword(password));

	    String contactNum;
	    boolean isValidContact = false;
	    do {
	        contactNum = Helper.readString("Enter contact number > ");
	        if (contactNum.isEmpty()) {
	            System.out.println("Contact number cannot be left blank! Please input a contact number.\n");
	        } else if (!isContactNumUnique(userList, contactNum)) {
	            System.out.println("Contact number " + contactNum + " is already registered.\n");
	        } else if (!contactNum.matches("[89]\\d{7}")) {
	            System.out.println("Singapore contact number should start with 9 or 8 followed by 7 digits from 0-9\n");
	        } else {
	            isValidContact = true;
	        }
	    } while (contactNum.isEmpty() || !isContactNumUnique(userList, contactNum) || !isValidContact);

	    String address;
	    do {
	        address = Helper.readString("Enter address > ");
	        if (address.isEmpty()) {
	            System.out.println("Address cannot be left blank! Please input an address.\n");
	        }
	    } while (address.isEmpty());

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
	        if (user.getUrUsername().equals(username)) {
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
	
	private static boolean isValidEmail(String email) {
		if (email.contains("@")&&email.contains(".")) {
			return true;
		}
		else {
			return false;
		}
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

	// ================================= Option 4 Delete (CRUD - Delete)=================================
	
	// ========================= Option 4 Delete User ========================= (Michelle)
	
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
		// ============================= Option 5 Add Service Provider (CREATE) ================================= (Izdihar)
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
			    } while (!isStrongPassword(password));
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
		// ========================= Option 6 Delete Service Provider (DELETE) ============================== (Izdihar)
		
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

//		public static void deleteServiceProvider(ArrayList<ServiceProvider> serviceProviderList, ServiceProvider serviceProvider) {
//		    if (serviceProvider != null) {
//		        String option = Helper.readString("Delete Service Provider " + serviceProvider.getSpId() + "? (Y/N) > ");
//		        if (option.equalsIgnoreCase("Y")) {
//		            String opt = Helper.readString("Confirm deletion of Service Provider " + serviceProvider.getSpId() + "? (Y/N) > ");
//		            if (opt.equalsIgnoreCase("Y")) {
//		            	serviceProviderList.remove(serviceProvider);
//		                System.out.println("User with ID " + serviceProvider.getSpId() + " deleted successfully.");
//		            } else if (opt.equalsIgnoreCase("N")) {
//		                System.out.println("Deletion aborted.");
//		            } else {
//		                System.out.println("Invalid input. Deletion aborted.");
//		            }
//		        } else if (option.equalsIgnoreCase("N")) {
//		            System.out.println("Deletion aborted.");
//		        } else {
//		            System.out.println("Invalid input. Deletion aborted.");
//		        }
//		    } else {
//		        System.out.println("Service Provider not found.");
//		    }
//		}
		
		public static void deleteServiceProvider(ArrayList<ServiceProvider> serviceProviderList, ServiceProvider serviceProvider) {
		    if (serviceProvider != null) {
		        String option = Helper.readString("Delete Service Provider " + serviceProvider.getSpId() + "? (Y/N) > ");
		        if (option.equalsIgnoreCase("Y")) {
		            	serviceProviderList.remove(serviceProvider);
		                System.out.println("User with ID " + serviceProvider.getSpId() + " deleted successfully.");
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

		public static void addQuote(ArrayList<User> urList, ArrayList<Quote> quoteList, ArrayList<Request> rList) {
			boolean flag = false;
			int reqId = 0;
			System.out.println(loggedSpID);
			while(!flag) {
				if(!rList.isEmpty()) {
					reqId = Helper.readInt("Input Request ID > ");
					for (Request r: rList) {
						System.out.println(r.getReqId());
						System.out.println(r.getReqSpID());
						if(reqId == r.getReqId() && loggedSpID == r.getReqSpID()) {
							flag = true;
						}else {
							System.out.println("That request either does not exist or does not belong to you");
						}
					}
				}else {
					System.out.println("There are no for you requests for you");
				}

	
				if(flag) {
					int urId = 0;
					String qService = "";
					String qDetails = "";
					for(Request r: rList) {
						if(r.getReqId() == reqId) {
							urId = r.getReqUrID();
							qService = r.getRequestService();
							qDetails = r.getRequestDetails();
						}
					}
					double amount = Helper.readDouble("Input amount > ");
					LocalDateTime today = LocalDateTime.now();
					Quote quote = new Quote(urId,loggedSpID, qService, qDetails, amount, today);
					quoteList.add(quote);
						
					System.out.println("Quote succesfully added");
				}
			}
		}
		
		
		// ======================================= Option 5 View Quote ===================================== (Edmund)
		
		public static void viewQuote(ArrayList<Quote> quoteList) {
			String output = String.format("%-7s %-7s %-7s %-13s %-30s %-7s %-10s\n", "Q ID", "UR ID", "SP ID", "SERVICE TYPE", "DETAILS", "AMOUNT", "RESPONSE DATE");
			int check = 0;

			if(!quoteList.isEmpty()) {
				for(Quote q: quoteList) {
					if(q.getQuoteSpID() == loggedSpID) {
						output += q.toString();
						check++;
					}
					if(check == 0) {
						System.out.println("No quotes created by you");
					}
				}
				System.out.println(output);
			}else {
				System.out.println("No Quotes");
			}
		}
		
		// ======================================= Option 6 Delete Quote ===================================== (Edmund)
		public static void deleteQuote(ArrayList<Quote> quoteList) {
			if(!quoteList.isEmpty()) {
				String output = String.format("%-7s %-7s %-7s %-13s %-30s %-7s %-10s\n", "Q ID", "UR ID", "SP ID", "SERVICE TYPE", "DETAILS", "AMOUNT", "RESPONSE DATE");
				int check2 = 0;
				for(Quote q: quoteList) {
					if(q.getQuoteSpID() == loggedSpID) {
						output += q.toString();
					}
				}
				if (check2 == 0) {
					System.out.println("There are no quotes that have been created by you");
				}else {
				System.out.println(output);
					int quoteID = Helper.readInt("Insert quote ID you wish to delete > ");
					int check = 0;
					for(Quote q: quoteList) {
						if(q.getQuoteId() == quoteID) {
							char uSure = Helper.readChar("Are you sure you wish to delete quote? (Y/N) > ");
							if(uSure == 'y' || uSure == 'Y') {
								quoteList.remove(q);
								check++;
								System.out.println("Quote was successfully deleted");
							}
							break;
						}
						if (check == 0) {
							System.out.println("No quote ID of " + quoteID + " was found");
						}
					}
				}
			}
		}
		
		// ================================= Option 1 Add (CRUD - Create)=================================

		// ========================= Option 1 Add Appointment Request ============================= (Xavier)
		
		public static void addRequest(ArrayList<ServiceProvider> spList, ArrayList<Service> sList, ArrayList<Request> requestList) {
			boolean flag = false;
			
			while(!flag) {
				
				int spID = Helper.readInt("Enter Service Provider ID > ");
				
				for (ServiceProvider sp: spList) {
					
					if (spID == sp.getSpId()) {
						  flag = true;
					}
				}
	
				if (flag) {
					
					String serviceType = Helper.readString("Enter renovation service type > ");
					String details = Helper.readString("Enter details for enquired renovation service request > ");
					double amount = Helper.readDouble("Enter amount > ");
   				Request request = new Request(loggedUrID, spID, serviceType, details, amount);
   					requestList.add(request);
					System.out.println("Request succesfully added");
				}
			}
		}
		
		// ================================= Option 2 View (CRUD - Read) ========================================

		// ========================= Option 2 View Appointment Requests ========================= (Xavier)
		
		public static void viewAllRequests(ArrayList<Request> requestList) {
			String output = String.format("%-10s %-25s %-15s %-25s %-16s\n", "USER ID", "SERVICE PROVIDER ID", 
	                      "SERVICE", "DETAILS", "AMOUNT");
			
			if  (!requestList.isEmpty()) {
				
				for (Request r: requestList) {
					output += String.format("%-10d %-25d %-15s %-25s %-16f\n", 
							r.getReqUrID(),r.getReqSpID(),r.getRequestService(),r.getRequestDetails(),r.getReqAmount());
				}
				
				System.out.println(output);
			}
			
			else {
				System.out.println("No requests available");
			}
        }
		
		// ================================= Option 3 Delete (CRUD - Delete) ========================================

	    // ========================= Option 3 Delete Appointment Request ========================= (Xavier)
		
		public static void deleteRequest(ArrayList<Request> RequestList, int loggedUr) {
			if (!requestList.isEmpty()) {
				
				String output = String.format("%-10s %-25s %-15s %-25s %-16s\n", "USER ID", "SERVICE PROVIDER ID", 
	                      "SERVICE", "DETAILS", "AMOUNT");
				
				for (Request r: requestList) {
					output += String.format("%-10d %-25d %-15s %-25s %-16f\n", 
							r.getReqUrID(),r.getReqSpID(),r.getRequestService(),r.getRequestDetails(),r.getReqAmount());
				}

				System.out.println(output);

				int requestID = Helper.readInt("Insert request ID you wish to delete > ");
				int check = 0;

				for(Request r: requestList) {
					
                    if(r.getReqId() == requestID) {
						   requestList.remove(r);
						   check++;
					}

                    else if (check == 0) {
						System.out.println("No request ID of " + requestID + " was found");
					}
                    
				}

			}

            else {
				System.out.println("There are no requests that have been created by you yet");
			}
			
		}
		
		
		// ========================= View Services ========================= (Thiha)
		
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
		
		// ========================= Add Services =========================(Thiha)
		
		private static void addService(ArrayList<Service> sList, int loggedSp) {
			String service = Helper.readString("Input service > ");
			
			sList.add(new Service(loggedSp, service));
			System.out.println("New service succesfully added");
		}
		// ========================= Delete Services =========================(Thiha)
		
		private static void deleteService(ArrayList<Service> sList, int loggedSp) { 
		      String output = String.format("%-7s %-15s\n", "SP ID", "SERVICES"); 
		      int check = 0; 
		      int check2 = 0; 
		 
		      if (!sList.isEmpty()) { 
		          for (Service s : sList) { 
		              if (s.getSpId() == loggedSp) { 
		                  output += String.format("%-7d %-15s\n", s.getSpId(), s.getService()); 
		                  check++; 
		              } 
		          } 
		 
		          if (check == 0) { 
		              System.out.println("There are no services assigned by you"); 
		          } else { 
		              System.out.println(output); 
		              String selectDelete = Helper.readString("Type the service you wish to delete > "); 
		              System.out.println(); 
		               
		              ArrayList<Service> servicesToDelete = new ArrayList<>(); 
		               
		              for (Service s : sList) { 
		                  if (selectDelete.equalsIgnoreCase(s.getService())) { 
		                      servicesToDelete.add(s); 
		                      check2++; 
		                  } 
		              } 
		               
		              if (check2 == 0) { 
		                  System.out.println("No service found to delete"); 
		              } else { 
		               System.out.println("Are you sure? (y/n)"); 
		               char confirmDeleteService = Helper.readChar(">"); 
		               if(confirmDeleteService == 'y') { 
		                   sList.removeAll(servicesToDelete); 
		                   System.out.println("Service deleted successfully"); 
		               }else { 
		                System.out.println("Operation cancelled"); 
		                 
		               } 
		 
		              } 
		          } 
		      } else { 
		          System.out.println("No services available"); 
		      } 
		  }
		
//====================================== Option 6 View Appointment=================================
		
        private static void viewAppointmentsUr(ArrayList<Appointment>appointmentList,int loggedUrID) {
        String output = String.format("%8s %8s %8s %8s \n", "APPOINTMENT ID","APPOINTMENT STATUS","APPOINTMENT DATE","APPOINTMENT DESCRIPTION");
			int check = 0;
			if(!appointmentList.isEmpty()) {
				for(Appointment ap: appointmentList) {
					if(ap.getUrAppointment() == loggedUrID) {
					output += String.format("%8d %8s %8s %8s\n",ap.getAppointmentId(),ap.getAppointmentStatus(),ap.getAppointmentDate().toString(),ap.getAppointmentDescription());
					check++;
					}else if(check == 0) {
						System.out.println("There are no appointments assigned to you");
					}
 				}
				System.out.println(output);
			}else {
				System.out.println("No appointments available");
			}
		}
		
// ======================================= Option 1 View Appointment ===================================== (Cheryl)
		
				private static void viewAppointmentsSP(ArrayList<Appointment> appointmentList,int loggedSpID) {
					
					String output = String.format("%8s %8s %8s %8s\n", "APPOINTMENT ID","APPOINTMENT STATUS","APPOINTMENT DATE","APPOINTMENT DESCRIPTION");
					int check = 0;
					if(!appointmentList.isEmpty()) {
						for(Appointment ap: appointmentList) {
							if(ap.getSPAppointment() == loggedSpID) {
							output += String.format("%8d %8s %8s %8s\n",ap.getAppointmentId(),ap.getAppointmentStatus(),ap.getAppointmentDate().toString(),ap.getAppointmentDescription());
							check++;
							}else if(check == 0) {
								System.out.println("There are no appointments assigned to you");
							}
		 				}
						System.out.println(output);
					}else {
						System.out.println("No appointments available");
					}
				}
				
//================================Option 2 Add Appointment=========================(Cheryl)
			private static void addAppointment(ArrayList<Appointment> appointmentList,int loggedSpID) {
					
					String appservice = Helper.readString("Enter the Appointment Service > ");
					String appstatus = "Incomplete";
					String appdatestring = Helper.readString("Enter the appointment's date in the 'dd/MM/yyyy' format > ");
					LocalDate appdate = LocalDate.parse(appdatestring, dtFormat);
					String appdescription = Helper.readString("Enter a description to add to the appointment > ");
					int customerid = Helper.readInt("Enter the customer id of the customer involved > ");
					int spid = loggedSpID;
					
					appointmentList.add(new Appointment(appservice,appstatus,appdate,appdescription,customerid,spid));
				}
				
		//================================Option 3 Delete Appointment=====================(Cheryl)
			
					
			private static void deleteApppointment(ArrayList<Appointment> appointmentList , int loggedSpID) {
				
				String deleteapp ="N";
				int check =0;
				String output = String.format("%s %s %s %s\n", "APPOINTMENT ID","APPOINTMENT STATUS","APPOINTMENT DATE","APPOINTMENT DESCRIPTION");

				int deleteappid = Helper.readInt("Select an appointment to delete by entering its appointment id > ");
				
				for (Appointment ap : appointmentList) {
			        if (ap.getAppointmentId()==deleteappid) {
	
			        	check++;
			        	if(ap.getSPAppointment()==loggedSpID) {

			        	output += String.format("%d %s %s %s\n",ap.getAppointmentId(),ap.getAppointmentStatus(),ap.getAppointmentDate().toString(),ap.getAppointmentDescription());
			        	
			        	System.out.println(output);
			        	
			        	deleteapp = Helper.readString("Are you sure you would like to remove this record? (Y/N) > ");
			        	
			        	if (deleteapp.equalsIgnoreCase("Y")) {
			        		
			        		appointmentList.remove(ap);
			        		System.out.println("Appointment record has been deleted");}
			        	
			        	else {
			        		System.out.println("No changes made");
			        	}

			            }
			        	else {
			        		System.out.println("You do not have access to that appointment record");
			        	}
			        }
			        
				if (check==0) {
					System.out.println("There is no appointment with that id number");
					}			
				}
				
			}
				
				
		//================================Option 4 Update Appointment ===============(Cheryl)
			
	 private static void updateAppointment(ArrayList<Appointment> appointmentList,int loggedSpID){
		 
			int check =0;
			String output = String.format("%s %s %s %s\n", "APPOINTMENT ID","APPOINTMENT STATUS","APPOINTMENT DATE","APPOINTMENT DESCRIPTION");
			int updateopt=0;

			int upappid = Helper.readInt("Select an appointment to update by entering its appointment id > ");
			
			for (Appointment ap : appointmentList) {
		        if (ap.getAppointmentId()==upappid) {

		        	check++;
		        	if(ap.getSPAppointment()==loggedSpID) {

		        	output += String.format("%d %s %s %s\n",ap.getAppointmentId(),ap.getAppointmentStatus(),ap.getAppointmentDate().toString(),ap.getAppointmentDescription());	        	
		        	System.out.println(output);	        	
		        	updateAppMenu();		        	
		        	updateopt = Helper.readInt("Select appointment detail to update > ");
		        	
		        	if (updateopt==1) {
		        		String newstatus = Helper.readString("Enter the new appointment status > ");
		        		ap.setAppointmentStatus(newstatus);
		        		System.out.print("Appointment Status Updated!");
		        	}
		        	
		        	else if (updateopt==2) {
		        		String newdatestring = Helper.readString("Enter the new appointment date > ");
		        		LocalDate newdate = LocalDate.parse(newdatestring, dtFormat);
		        		ap.setAppointmentDate(newdate);
		        		System.out.println("Appointment Date Updated!");
		        	}
		        	
		        	else if (updateopt==3) {
		        		String newdescript = Helper.readString("");
		        		ap.setAppointmentDescription(newdescript);
		        		System.out.println("Appointment Description Updated!");
		        		
		        	}
		        	
		        	else {
		        		System.out.println("No changes made");
		        	}

		            }
		        	else {
		        		System.out.println("You do not have access to that appointment record");
		        	}
		        }
		        
			if (check==0) {
				System.out.println("There is no appointment with that id number");
				}			
			}
			
		}
}


