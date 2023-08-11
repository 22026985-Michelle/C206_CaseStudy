import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private Administrator a1;
	private Administrator a2;
	private Administrator a3;
	
	private ArrayList<User> userList;
	private ArrayList<Administrator> adminList;
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	// Michelle
	@Before
	public void setUp() throws Exception {
		u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		u3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
		u4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
		u5 = new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08");
		
		a1 = new Administrator("robert", "robert@gmail.com", "adpassword1");
		a2 = new Administrator("thomas", "thomas@gmail.com", "adpassword2");
		a3 = new Administrator("bom", "bom@gmail.com", "adpassword3");
		
		
		userList = new ArrayList<User>();
		adminList =  new ArrayList<Administrator>();
	}

	// Michelle
	@Test
	public void testAddUser() {
		// User list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		// Add an item
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added", u1, userList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", u2, userList.get(1));
		
		// Add an item that has missing detail
		User ur_missing = new User("Billy", "billy@yahoo.com", "password2", "86957206", "");
		C206_CaseStudy.addUser(userList, ur_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
	}
	
	// Michelle
	@Test
	public void testRetrieveAllUsers() {
		// Test if User list is not null but empty - boundary
		assertNotNull("Test if there is valid User arraylist to retrieve item", userList);
		
		//test if the list of Users retrieved from the C206_CaseStudy is empty - boundary
		String allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserslist", testOutput, allUsers);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that User arraylist size is 2", 2, userList.size());
		
		//test if the expected output string same as the list of Users retrieved from the C206_CaseStudy	
		allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		testOutput = String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n","7" , "Addy", "addy@gmail.com", 
				"password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		testOutput += String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n","8", "Billy", "billy@yahoo.com", 
				"password2", "86957206", "Hougang St 3 Blk 864 #21-09");
	
		assertEquals("Test that ViewAllUserslist", testOutput, allUsers);
		
	}
	
	// Michelle
	@Test
	public void testDeleteUser() {
	    // Redirect System.in for testing input
	    ByteArrayInputStream inputStream = new ByteArrayInputStream("Y\nY\n".getBytes());
	    System.setIn(inputStream);
	    
	    // Ensure there is a valid User ArrayList to delete from
	    assertNotNull("Test if there is a valid User ArrayList to delete from", userList);

	    // Add users to the list
	    C206_CaseStudy.addUser(userList, u5);

	    // Check that the User ArrayList size is 2 after adding the Users
	    assertEquals("Test that User arraylist size is 1", 1, userList.size());
	    
	    // Delete one of the Users by Id
	    C206_CaseStudy.deleteUser(userList, u5); // Deleting the last User
	    
	    // Restore System.in
	    System.setIn(System.in);
	    
	    // Check that the User ArrayList size is now 1 after deleting a User
	    assertEquals("Test that User ArrayList size is 0 after deletion", 0, userList.size());

	    // Get the expected output after deleting the User
	    String expectedOutput = "";

	    // Retrieve all Users from the list
	    String allUsers = C206_CaseStudy.retrieveAllUsers(userList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allUsers);

	    // Check that the retrieved Users match the expected output after deleting a User
	    assertEquals("Test that ViewAllUsers after delete", expectedOutput, allUsers);
	}
	
	// Michelle
	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;
		u4 = null;
		u5 = null;
		
		a1 = null;
		a2 = null;
		a3 = null;
		
		userList.clear(); // Clear the list to reset the state
	    adminList.clear(); // Clear the list to reset the state
	    System.setIn(System.in);
	}


}