import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
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
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Before
	public void setUp() throws Exception {

		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 10, "98778976");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2", 6, "98777645");

		serviceProviderList = new ArrayList<ServiceProvider>();

		// Create an ArrayList of service providers.
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp2);

		// Redirect System.in for testing input
		ByteArrayInputStream userInput = new ByteArrayInputStream("Y\n".getBytes());
		System.setIn(userInput);

	}

	// User Story: As an Administrator, I want to view all the service providers so
	// that I can ensure the platform's
	// user base is well-monitored.
	// No. 1 - 3
	@Test
	public void viewServiceProviderTest() {
		// ===================================================
		// No.1 Normal Test - View current serviceProviderList
		// ===================================================
		// Assert that the number of service providers is 2.
		assertEquals(2, serviceProviderList.size());

		// ===================================================
		// No.2 Boundary Test - Delete all service provider and view the
		// serviceProviderList
		// ===================================================
		// Delete all service providers.
		serviceProviderList.clear();

		// Assert that the serviceproviderList is empty (No records)
		assertEquals(0, serviceProviderList.size());

		// ===================================================
		// No. 3 Normal Test - Add a service provider and view the serviceProviderList
		// ===================================================
		// Add a service provider.
		serviceProviderList.add(new ServiceProvider("RenoSerV", "RenoSerV@gmail.com", "password3", 10, "98765643"));

		// Assert that the number of service providers is 1.
		assertEquals(1, serviceProviderList.size());

	}

	// User Story: As an Administrator, I want to add new service providers so that
	// they can use the portal to offer
	// renovation services to users with ease.
	// No. 1 - 5
	@Test
	public void addServiceProviderTest() {
		// ===================================================
		// No.1 Boundary Test - Check if the Service Provider List exists
		// ===================================================
		// Assert that serviceProviderList contains records
		assertNotNull(serviceProviderList);

		// ===================================================
		// No.2 Normal Test - Add a service provider to the current serviceProviderList
		// (name: ServiceProviderA,
		// email: ServiceProviderA@Gmail.com, Contact num: 98765643)
		// ===================================================
		// Add a service provider.
		sp3 = new ServiceProvider("ServiceProviderA", "ServiceProviderA@Gmail.com", "password3", 10, "98765643");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp3);

		// Assert that the serviceproviderList now contains 3 records
		assertEquals(3, serviceProviderList.size());

		// ===================================================
		// No. 3 Error Test - Add a service provider with the same name to the current
		// serviceProviderList (name: ServiceProviderA)
		// ===================================================
		// Add a service provider with the same name.
		sp4 = new ServiceProvider("ServiceProviderA", "ServiceProviderB@Gmail.com", "password4", 11, "98765432");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp4);

		// Assert that the serviceproviderList now contains 3 records (4th record
		// rejected)
		assertEquals(3, serviceProviderList.size());

		// ===================================================
		// No. 4 Error Test - Add a service provider with the same e-mail to the current
		// serviceProviderList (email: ServiceProviderA@Gmail.com)
		// ===================================================
		// Add a service provider with the same email.
		sp4 = new ServiceProvider("ServiceProviderB", "ServiceProviderA@Gmail.com", "password4", 11, "98765432");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp4);

		// Assert that the serviceproviderList now contains 3 records (4th record
		// rejected)
		assertEquals(3, serviceProviderList.size());

		// ===================================================
		// No. 5 Error Test - Add a service provider with the same contact number to the
		// current serviceProviderList (number: 98765643)
		// ===================================================
		// Add a service provider with the same contact number.
		sp4 = new ServiceProvider("ServiceProviderB", "ServiceProviderB@Gmail.com", "password4", 11, "98765643");
		C206_CaseStudy.addServiceProvider(serviceProviderList, sp4);

		// Assert that the serviceproviderList now contains 3 records (4th record
		// rejected)
		assertEquals(3, serviceProviderList.size());
	}

	// User Story: As an Administrator, I want to delete service providers so that I
	// can remove service providers
	// that are no longer using the Renovation Portal and not mislead users.
	// No. 1 - 3
	@Test
	public void deleteServiceProviderTest() {
		// ===================================================
		// No. 1 Boundary Test - Check if the Service Provider List exists
		// ===================================================
		// Assert that serviceProviderList contains records
		assertNotNull(serviceProviderList);

		// ===================================================
		// No. 2 Normal Test - Delete a service provider record
		// ===================================================
		// Delete a service provider.
		C206_CaseStudy.deleteServiceProvider(serviceProviderList, sp1);

		// Assert that the serviceproviderList now contains 1 records (1st record
		// deleted)
		assertEquals(1, serviceProviderList.size());

		// ===================================================
		// No. 3 Normal Test - Check if deleted service provider is in the
		// serviceProviderList
		// ===================================================
		// Find Service Provider with name "ServiceProviderA". Assert Null when method
		// find return null. (Record not found)
		assertNull(C206_CaseStudy.findServiceProviderByName(serviceProviderList, "ServiceProviderA"));
	}

	@After
	public void tearDown() throws Exception {
		sp1 = null;
		sp2 = null;
		sp3 = null;
		sp4 = null;
		serviceProviderList.clear(); // Clear the list to reset the state
		System.setIn(System.in);
	}

}