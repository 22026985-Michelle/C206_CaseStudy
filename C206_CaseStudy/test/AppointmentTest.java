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
    	
    	appointmentList.add(ap1);
    	appointmentList.add(ap2);
    	appointmentList.add(ap3);

    	
        user1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		user2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		user3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
	    user4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
	    
	    userList.add(user1);
	    userList.add(user2);
	    userList.add(user3);
	    userList.add(user4);
    	
    	sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 2, "Renovation Description A");
    	C206_CaseStudy.addServiceProvider(serviceProviderList, sp1);
    	
    	appointmentList = new ArrayList<Appointment>();
    	userList = new ArrayList<User>();
    	serviceProviderList = new ArrayList<ServiceProvider>();
    	
    }
    
 // Cheryl
    @Test
	public void testViewAppointmentsUr() {
    	
    }
    
 // Cheryl
    @Test
	public void testViewAppointmentsSp() {
    	
    }
    
 // Cheryl
    @Test
	public void testAddApppointment() {
    	
    }
    
 // Cheryl
    @Test
	public void testDeleteAppointment() {
    	
    }
    
 // Cheryl
    @Test
	public void testUpdateAppointment() {
    	
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
