import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceProviderTest {
	
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	private ServiceProvider sp3; 
	private ServiceProvider sp4;
	
	private ArrayList<ServiceProvider> serviceProviderList;
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Before
	public void setUp() throws Exception {

		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 10, "98778976");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2", 6, "98777645");
		
		serviceProviderList = new ArrayList<ServiceProvider>();
	}
	
	// User Story: <View all Service Providers> 
	// Use Case No. 1
	// View current serviceProviderList
	@Test
    public void viewSPTest1() {
		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
		
        // Assert that the number of service providers is 2.
        assertEquals(2, serviceProviderList.size());
    }
	
	// User Story: <View all Service Providers> 
	// Use Case No. 2
	// Delete all service provider and view the serviceProviderList
	@Test
	public void viewSPTest2() {
		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
	        
	    // Delete all service providers.
	    serviceProviderList.clear();
			
	    // Assert that the number of service providers is 0.
	    assertEquals(0, serviceProviderList.size());
	}
	
	// User Story: <View all Service Providers> 
	// Use Case No. 3
	// Add a service provider and view the serviceProviderList
	@Test
	public void viewSPTest3() {
		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);

		        
		// Delete all service providers.
		serviceProviderList.clear();
		    
		// Add a service provider.
	    serviceProviderList.add(new ServiceProvider("RenoSerV", "RenoSerV@gmail.com", "password3", 10, "98765643"));
				
		// Assert that the number of service providers is 0.
		assertEquals(1, serviceProviderList.size());
	}
	
	// User Story: <Add a Service Provider> 
	// Use Case No. 1
	// Add a service provider to the current serviceProviderList (name: ServiceProviderA, email: ServiceProviderA@Gmail.com)
	@Test
	public void addSPTest1() {
		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
		    
		// Add a service provider.
		sp3 = new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", 10, "98765643");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp3);

				
		// Assert that the number of service providers is 0.
		assertEquals(3, serviceProviderList.size());
	}
	
	// User Story: <Add a Service Provider> 
	// Use Case No. 2
	// Add a service provider with the same name to the current serviceProviderList (name: ServiceProviderA)
	@Test
	public void addSPTest2() {
		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
			    
		// Add a service provider.
		sp3 = new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", 10, "98765643");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp3);
		
		// Add a service provider with the same name.
		sp4 = new ServiceProvider("ServiceProviderA", "ServiceProviderB@Gmail.com", "password4", 11, "98765432");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp4);
		
		// Assert that the number of service providers is 0.
		assertEquals(3, serviceProviderList.size());
	}
	
	// User Story: <Add a Service Provider> 
		// Use Case No. 3
		// Add a service provider with the same e-mail to the current serviceProviderList (email: ServiceProviderA@Gmail.com)
		@Test
		public void addSPTest3() {
			// Create an ArrayList of service providers.
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);
				    
			// Add a service provider.
			sp3 = new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", 10, "98765643");
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp3);
			
			// Add a service provider with the same email.
			sp4 = new ServiceProvider("ServiceProviderB", "ServiceProviderA@Gmail.com", "password4", 11, "98765432");
			C206_CaseStudy.addServiceProvider(serviceProviderList, sp4);
			
			// Assert that the number of service providers is 0.
			assertEquals(3, serviceProviderList.size());
		}
	
	
	@After
	public void tearDown() throws Exception {
		sp1 = null;
		sp2 = null;
	    serviceProviderList.clear(); // Clear the list to reset the state
	    System.setIn(System.in);
	}


}