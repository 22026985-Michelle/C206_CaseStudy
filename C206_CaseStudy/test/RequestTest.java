import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequestTest {
	
    private User u1;
	private User u2;
	private User u3;
    private User u4;
    private User u5;
    private Request r1;
	private Request r2;
    private ServiceProvider sp1;
    private ServiceProvider sp2;
    private Service service1;
	
    private ArrayList<User> userList;
    private ArrayList<Request> requestList;
    private ArrayList<ServiceProvider> serviceProviderList;
    private ArrayList<Service> serviceList;
    

    @Test
	  public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	  }

    // Xavier
    @Before
    public void setUp() throws Exception {
        u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		u3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
	    u4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
		u5 = new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08");

        sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 2, "Renovation Description A");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2", 3, "Renovation Description B");

        r1 = new Request(1, 1, "Bathroom", "Fix tiles", 300.00);
		r2 = new Request(2, 2, "Kitchen", "Repaint walls", 900.00);
		
		service1 = new Service(0, "Bathroom");
		
		userList = new ArrayList<User>();    
		requestList = new ArrayList<Request>();    
		serviceProviderList = new ArrayList<ServiceProvider>();    
		serviceList = new ArrayList<Service>();    
    }
	  
    // Xavier
    @Test
    public void testAddRequest() {
    	// Add service to the service list
    	serviceList.add(service1);
    	
		// Add request to the request list
        C206_CaseStudy.addRequest(requestList, serviceList, 0);

	    // Test that requestList is not empty
		assertNotNull("Test that there are requests in the list", requestList);
		
	    // Test that there is 1 request in the list
		assertEquals("Test that there is 1 request in the list", 1, requestList.size());

        // Add another request
        C206_CaseStudy.addRequest(requestList, serviceList, 0);

        // Test that there are 2 requests in the List
        assertEquals("Test that the second request is added", 2, requestList.size());

    }

    // Xavier
    @Test
    public void testViewRequest() {
    	// Add service to the service list
    	serviceList.add(service1);
    	
		// View the empty request list
        C206_CaseStudy.viewAllRequests(requestList, 0);

	    // Test that the requestList is empty
        assertEquals("Test that the request list is empty", 0, requestList.size());

        // Add 2 requests to the request list
        C206_CaseStudy.addRequest(requestList, serviceList, 0);
        C206_CaseStudy.addRequest(requestList, serviceList, 0);

		// Test that there are 2 requests in the list
		assertEquals("Test that there are 2 requests in the list", 2, requestList.size());
		
		// View the request list with 2 newly added requests
        C206_CaseStudy.viewAllRequests(requestList, 0);
    }

    // Xavier
    @Test
    public void testDeleteRequest() {
    	// Add service to the service list
    	serviceList.add(service1);
    	
        // Ensure there is a valid User ArrayList to delete from
	    assertNotNull("Test if there is a valid Request ArrayList to delete from", requestList);

		// Add a request
	    C206_CaseStudy.addRequest(requestList, serviceList, 0);

	    // View the request list with 1 newly added request
        C206_CaseStudy.viewAllRequests(requestList, 0);
        
        // Test that there is now 1 request in the list
		assertEquals("Test that there is 1 request in the list", 1, requestList.size());

        // Delete the request by id
	    C206_CaseStudy.deleteRequest(requestList, 0);

	    // View the empty request list
        C206_CaseStudy.viewAllRequests(requestList, 0);
	    
        // Check that the Request ArrayList size is 0 after deleting request
	    assertEquals("Test that User ArrayList size is 0 after deletion", 0, requestList.size());
    }

    // Xavier
	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;

        sp1 = null;
        sp2 = null;

		r1 = null;
		r2 = null;
		
		service1 = null;
		
	    userList.clear(); // Clear the list to reset the state
        serviceProviderList.clear(); // Clear the list to reset the state
	    requestList.clear(); // Clear the list to reset the state
	    serviceList.clear(); // Clear the list to reset the state
	    System.setIn(System.in);
    }

}