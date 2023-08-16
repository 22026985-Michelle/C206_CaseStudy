import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppointmentTest {
	
	private Appointment ap1;
	private Appointment ap2;
	private Appointment ap3;
	
	private ArrayList<User> userList;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<ServiceProvider> serviceProviderList;
	
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private ServiceProvider sp1;
	
	private static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
	
	
	// Cheryl
	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}
	
	// Cheryl
    @Before
    public void setUp() throws Exception {
    	ap1 = new Appointment(3,1,"Replace Tiles","Incomplete",LocalDate.parse("10/01/2023", dtFormat),"Appointment Description");
    	ap2 = new Appointment(4,2,"Replace Floors","Incomplete",LocalDate.parse("12/01/2023", dtFormat),"Appointment Description");
    	ap3 = new Appointment(4,1,"Replace Tiles","Incomplete",LocalDate.parse("10/01/2023", dtFormat),"Appointment Description");

    	
    	sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 2, "Renovation Description A");
    	C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
    	
    	appointmentList = new ArrayList<Appointment>();
    	userList = new ArrayList<User>();
    	serviceProviderList = new ArrayList<ServiceProvider>();
    	
    }
    

    
 // Cheryl
    @Test
	public void testViewAppointmentsSp() {
    	
    	appointmentList.add(ap1);
    	appointmentList.add(ap2);
    	appointmentList.add(ap3);
    	
    	//Test that appointmentList is not empty
    	assertNotNull("Test that there are appointment records in the list", appointmentList);
    	
    	//Test that there are three records in the current appointmentList
    	assertEquals("Test that there are 3 appointment records in the list", appointmentList.size() , 3);
    	
    	//Test that sp1 would only be able to view two of the records
    	assertEquals("Test that ap1 spAppointment is the same as sp1's id(1)", ap1.getSPAppointment(),1);
    	assertEquals("Test that ap3 spAppointment is the same as sp1's id(1)", ap3.getSPAppointment(),1);
    	
    	//Test that sp1 will not have access to ap2
    	assertNotEquals("Test that ap2 spAppointment is not the same as sp1's id(1)", ap2.getSPAppointment(), 1);
    }
    
 // Cheryl
    @Test
	public void testAddApppointment() {
    	
    	//Test that appointmentList is initially empty
    	assertNotNull("Test if there is valid Appointment arraylist to add to", appointmentList);
    	assertEquals("Test that the Appointment arraylist is empty.", 0, appointmentList.size());
    	
    	//Test that appointmentList is not empty
    	appointmentList.add(ap1);
    	appointmentList.add(ap2);
    	appointmentList.add(ap3);
    	   	
    	assertNotNull("Test that there are appointment records in the list", appointmentList);
    	assertEquals("Test that the appointment records have been added to the list.", 3, appointmentList.size());
    	
    	//Test that appointments can be added to the appointmentList
    	appointmentList.add(new Appointment(5,1,"Repair Toliet","Incomplete",LocalDate.parse("01/04/2023", dtFormat),"Appointment Description"));
    	
    	//Test that appointments now has 4 records
    	assertEquals("Test that the appointment records have been added to the list.", 4, appointmentList.size());
    	

    }
    
 // Cheryl
    @Test
	public void testDeleteAppointment() {
    	
    	appointmentList.add(ap1);
    	appointmentList.add(ap2);
    	appointmentList.add(ap3);
    	
    	//Test that appointmentList is not empty
    	assertNotNull("Test if there is valid Appointment arraylist to add to", appointmentList);
    	
    	appointmentList.remove(ap1);
    	
    	//Test that appointmentList has has only 2 records
    	assertEquals("Test that there are 3 appointment records in the list", appointmentList.size() , 3);
    	//Test that deleted record is no longer in the appointmentList
    	
    	//Test that sp1 is not given access to delete ap2
    	assertNotEquals("Test that ap2 spAppointment is not the same as sp1's id(1)", ap2.getSPAppointment(), 1);

    	
    }
    
    
 // Cheryl
	@After
	public void tearDown() throws Exception {
		ap1=null;
		ap2=null;
		ap3=null;
		
		user1=null;
		user2=null;
		user3=null;
		user4=null;
		
		sp1=null;
		
	    userList.clear(); 
        serviceProviderList.clear(); 
	    appointmentList.clear();
		
		System.setIn(System.in);
	}
	
	
	

}
