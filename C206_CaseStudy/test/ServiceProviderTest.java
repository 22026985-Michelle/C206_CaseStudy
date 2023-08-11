import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceProviderTest {
	
	private Administrator a1;
	private Administrator a2;
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	
	private ArrayList<Administrator> adminList;
	private ArrayList<ServiceProvider> serviceProviderList;
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	// Izdihar
	@Before
	public void setUp() throws Exception {
		
		a1 = new Administrator("robert", "robert@gmail.com", "adpassword1");
		a2 = new Administrator("thomas", "thomas@gmail.com", "adpassword2");
		
		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", "Renovation Description A");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2","Renovation Description B");
		
		adminList =  new ArrayList<Administrator>();
		serviceProviderList = new ArrayList<ServiceProvider>();
	}
	
	// Izdihar
		@Test
		public void testAddUser() {
			// User list is not null, so that can add a new item - boundary
			assertNotNull("Test if there is valid User arraylist to add to", serviceProviderList);
			assertEquals("Test that the User arraylist is empty.", 0, serviceProviderList.size());
			//Given an empty list, after adding 1 item, the size of the list is 1 - normal
			//The item just added is as same as the first item of the list
			// Add an item
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
			assertEquals("Check that Service Provider arraylist size is 1", 1, serviceProviderList.size());
			assertSame("Check that Service Provider is added", sp1, serviceProviderList.get(0));
			
			//Add another item. test The size of the list is 2? - normal
			//The item just added is as same as the second item of the list
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
			assertEquals("Check that User arraylist size is 2", 2, serviceProviderList.size());
			assertSame("Check that User is added", sp2, serviceProviderList.get(1));
			
			// Add an item that has missing detail
			ServiceProvider missingSP = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2","Renovation Description B");
			C206_CaseStudy.addServiceProvider(serviceProviderList, missingSP);
			assertEquals("Test that the User arraylist size is unchanged.", 2, serviceProviderList.size());
		}

		
	// Izdihar
	@Test
	public void testRetrieveAllServiceProvider() {
		// Test if User list is not null but empty - boundary
		assertNotNull("Test if there is valid Service Provider arraylist to retrieve item", serviceProviderList);
		
		//test if the list of Users retrieved from the C206_CaseStudy is empty - boundary
		String allServiceProvider= C206_CaseStudy.retrieveAllServcieProviders(serviceProviderList);
		String testOutput = "";
		assertEquals("Check that ViewAllServiceProviderlist", testOutput, allServiceProvider);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
		assertEquals("Test that Service Provider arraylist size is 2", 2, serviceProviderList.size());
		
		//test if the expected output string same as the list of Users retrieved from the C206_CaseStudy	
		allServiceProvider = C206_CaseStudy.retrieveAllServcieProviders(serviceProviderList);
		testOutput = String.format("%-5s %-20s %-30s %-15s %-20s\n","4", "LiveSpaceReno", "LiveSpaceReno@Gmail.com", 
				"password1", "Renovation Description A ");
		testOutput += String.format("%-5s %-20s %-30s %-15s %-20s\n","5", "EcoConstructors", "EcoConstructors@Gmail.com", 
				"password2","Renovation Description B ");
	
		assertEquals("Test that ViewAllServiceproviderList", testOutput, allServiceProvider);
		
	}
		
	// Izdihar
	@Test
	public void testDeleteServiceProvider() {
		// Redirect System.in for testing input
	    ByteArrayInputStream inputStream = new ByteArrayInputStream("Y\n".getBytes());
	    System.setIn(inputStream);

	    // Add users to the list
	    C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);

	    // Check that the User ArrayList size is 2 after adding the Users
	    assertEquals("Test that Service Provider arraylist size is 2", 2, serviceProviderList.size());
	    
	    // Delete one of the Users by Id
	    C206_CaseStudy.deleteServiceProvider(serviceProviderList, sp1); // Deleting the first User
	    
	    // Restore System.in
	    //System.setIn(System.in);
	    
	    // Check that the User ArrayList size is now 1 after deleting a User
	    assertEquals("Test that User ArrayList size is 1 after deletion", 1, serviceProviderList.size());

	    // Get the expected output after deleting the User
	    String expectedOutput = String.format("%-5s %-20s %-30s %-15s %-20s\n","9","EcoConstructors", "EcoConstructors@Gmail.com", "password2","Renovation Description B ");

	    // Retrieve all Users from the list
	    String allServiceProviders = C206_CaseStudy.retrieveAllServcieProviders(serviceProviderList);

	    // Print the expected and actual outputs for comparison
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + allServiceProviders);

	    // Check that the retrieved Users match the expected output after deleting a User
	    assertEquals("Test that ViewAllServiceProvider after delete", expectedOutput, allServiceProviders);
	}
	
	// Izdihar
	@After
	public void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		
		sp1 = null;
		sp2 = null;
		
	    adminList.clear(); // Clear the list to reset the state
	    serviceProviderList.clear(); // Clear the list to reset the state
	    System.setIn(System.in);
	}


}

