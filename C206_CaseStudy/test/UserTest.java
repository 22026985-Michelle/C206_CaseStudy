import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User u1;
    private User u2;
    private ArrayList<User> userList;

    @Before
    public void setUp() throws Exception {
        u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
        u1.setUrId(1); // Assign the desired ID

        u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
        u2.setUrId(2); // Assign the desired ID

        userList = new ArrayList<User>();          
    }

	// Michelle
	@Test
	public void testAddUser() {
		// Test User list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		 
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		// Add an item
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added", u1, userList.get(0));
		
		// Add another item. Test The size of the list is 2. - normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", u2, userList.get(1));
		
		// Add a User that has missing detail
		// Test that the User list does not change in size
		User ur_missing = new User("Billy", "billy@yahoo.com", "password2", "86957206", "");
		C206_CaseStudy.addUser(userList, ur_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
		
		// Add a User that already exists in the User list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", u2, userList.get(1));
	}
	
	// Michelle
	@Test
	public void testRetrieveAllUsers() {
		// Test if User list is not null but empty - boundary
		assertNotNull("Test if there is valid User arraylist to retrieve item", userList);
		
		// Test if the list of Users retrieved from the C206_CaseStudy is empty - boundary
		String allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserslist", testOutput, allUsers);
		
		// Given an empty list, after adding 2 Users, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that User arraylist size is 2", 2, userList.size());
		
		// Test if the expected output string same as the list of Users retrieved from the C206_CaseStudy	
		allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		testOutput = String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n","1" , "Addy", "addy@gmail.com", "password1", 
				"95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		testOutput += String.format("%-5s %-10s %-35s %-20s %-16s %-20s\n","2", "Billy", "billy@yahoo.com", "password2",
				"86957206", "Hougang St 3 Blk 864 #21-09");
	
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
	    // Check that the User ArrayList size is 2 after adding the Users	
	    // Check that the User ArrayList size is now 1 after deleting a User
	    C206_CaseStudy.addUser(userList, u1);
	    assertEquals("Test that User arraylist size is 1", 1, userList.size());
	    
	    // Delete one of the Users by Id
	    // After deleting 1 User, test if the size of the list is 0 - normal 
	    C206_CaseStudy.deleteUser(userList, u1); 
	    assertEquals("Test that User ArrayList size is 0 after deletion", 0, userList.size());
	    
	    // Restore System.in
	    System.setIn(System.in);

	    // Test if the list of Users retrieved from the C206_CaseStudy is nothing - boundary
	    String allUsers = C206_CaseStudy.retrieveAllUsers(userList);
	    String expectedOutput = "";
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
        userList.clear();
    }}