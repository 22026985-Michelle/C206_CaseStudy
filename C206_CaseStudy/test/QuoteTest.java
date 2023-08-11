import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuoteTest {
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	
	private ArrayList<User> userList;
	private ArrayList<Quote> quoteList;
	private ArrayList<ServiceProvider> serviceProviderList;

	
	@Before
	public void setUp() throws Exception {
		u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		u3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
		u4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
		u5 = new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08");
		
		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", "Renovation Description A");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2","Renovation Description B");
		
		userList = new ArrayList<User>();
		quoteList =  new ArrayList<Quote>();
		serviceProviderList = new ArrayList<ServiceProvider>();
	}


}
