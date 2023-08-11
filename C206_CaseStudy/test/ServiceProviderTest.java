import static org.junit.Assert.*;
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
	
//	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
//		assertTrue("C206_CaseStudy_SampleTest ",true);
//	}
	
	@Before
	public void setUp() throws Exception {

		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", "10", "98778976");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2","6", "98777645");
		
		serviceProviderList = new ArrayList<ServiceProvider>();
	}
	
	// User Story: <View all Service Providers> 
	//Use Case No. 1
	@Test
    public void viewSPTest1() {
		// Create an ArrayList of service providers.
        ArrayList<ServiceProvider> serviceProviderList = new ArrayList<>();
        serviceProviderList.add(sp1);
        serviceProviderList.add(sp2);
		
        // Assert that the number of service providers is 2.
        assertEquals(2, serviceProviderList.size());
    }
	
	// User Story: <View all Service Providers> 
	// Use Case No. 2
	@Test
	public void viewSPTest2() {
		// Create an ArrayList of service providers.
	    ArrayList<ServiceProvider> serviceProviderList = new ArrayList<>();
	    serviceProviderList.add(sp1);
	    serviceProviderList.add(sp2);
	        
	    // Delete all service providers.
	    serviceProviderList.clear();
			
	    // Assert that the number of service providers is 0.
	    assertEquals(0, serviceProviderList.size());
	}
	
	// User Story: <View all Service Providers> 
	// Use Case No. 3
	@Test
	public void viewSPTest3() {
		// Create an ArrayList of service providers.
		ArrayList<ServiceProvider> serviceProviderList = new ArrayList<>();
		serviceProviderList.add(sp1);
		serviceProviderList.add(sp2);
		        
		// Delete all service providers.
		serviceProviderList.clear();
		    
		// Add a service provider.
	    serviceProviderList.add(new ServiceProvider("RenoSerV", "RenoSerV@gmail.com", "password3", "10", "98765643"));
				
		// Assert that the number of service providers is 0.
		assertEquals(1, serviceProviderList.size());
	}
	
	// User Story: <Add a Service Provider> 
	// Use Case No. 1
	@Test
	public void addSPTest1() {
		// Create an ArrayList of service providers.
		ArrayList<ServiceProvider> serviceProviderList = new ArrayList<>();
		serviceProviderList.add(sp1);
		serviceProviderList.add(sp2);
		    
		// Add a service provider.
	    serviceProviderList.add(new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", "10", "98765643"));
				
		// Assert that the number of service providers is 0.
		assertEquals(3, serviceProviderList.size());
	}
	
	// User Story: <Add a Service Provider> 
	// Use Case No. 2
	@Test
	public void addSPTest2() {
		// Create an ArrayList of service providers.
		ArrayList<ServiceProvider> serviceProviderList = new ArrayList<>();
		serviceProviderList.add(sp1);
		serviceProviderList.add(sp2);
			    
		// Add a service provider.
		serviceProviderList.add(new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", "10", "98765643"));
		
		// Add a service provider with the same name.
        try {
            ServiceProvider serviceProviderA = new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password4", "11", "98765432");
            serviceProviderList.add(serviceProviderA);
        } catch (Exception e) {
            // Handle the exception.
            assertEquals("Username ServiceProviderA is already taken. Please choose a different username.", e.getMessage());
        }
        // View the current service provider list.
        serviceProviderList2(serviceProviderList);
	}
     private void serviceProviderList2(ArrayList<ServiceProvider> serviceProviderList) {
            // Get the number of service providers in the list.
            int numberOfServiceProviders = serviceProviderList.size();

            // Assert that the number of service providers is 2.
            assertEquals(2, numberOfServiceProviders);
        }
	
	
	@After
	public void tearDown() throws Exception {
		sp1 = null;
		sp2 = null;
	    serviceProviderList.clear(); // Clear the list to reset the state
	    System.setIn(System.in);
	}


}

