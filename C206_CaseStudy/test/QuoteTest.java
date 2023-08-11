import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
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
	private Quote q1;
	private Quote q2;
	private Request r1;
	private Request r2;
	private ServiceProvider sp1;
	private ServiceProvider sp2;
	
	private ArrayList<User> userList;
	private ArrayList<Quote> quoteList;
	private ArrayList<Request> requestList;
	private ArrayList<ServiceProvider> serviceProviderList;

	
	@Before
	public void setUp() throws Exception {
		u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		u3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
		u4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
		u5 = new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08");
		
		q1 = new Quote(1,1, "Bathroom", "Replace tiles", 600.00, LocalDateTime.now());
		q2 = new Quote(2,2, "Kitchen", "Remodel floor", 1000.00, LocalDateTime.now());

		r1 = new Request(1, 1, "Bathroom", "Replace tiles", 400.00);
		r2 = new Request(2, 2, "Kitchen", "Remodel floor", 700.00);
		
		sp1 = new ServiceProvider("LiveSpaceReno", "LiveSpaceReno@Gmail.com", "password1", 2, "Renovation Description A");
		sp2 = new ServiceProvider("EcoConstructors", "EcoConstructors@Gmail.com", "password2", 3, "Renovation Description B");
		
		userList = new ArrayList<User>();
		quoteList =  new ArrayList<Quote>();
		requestList = new ArrayList<Request>();
		serviceProviderList = new ArrayList<ServiceProvider>();
	}

	@Test
	public void testAddQuote() {
		// Add request to request list
		requestList.add(r1);
		// Add quote into quote list
		C206_CaseStudy.addQuote(userList, quoteList, requestList,1);
		// Test that quoteList is not empty
		assertNotNull("Test that there is are quotes in the list", quoteList);
		
		// Test that there is 1 quote in the list
		assertEquals("Test that there is 1 quote in the list", quoteList.size() , 1);
		requestList.add(r2);
		
		// Test that Service provider cannot add quotes to request that do not belong to them
		assertNotSame("Test that the request does not belong to Service provider", r2.getReqSpID(), 1);
	}
	
	@Test
	public void testViewQuote() {
		// Add quote to quote list
		quoteList.add(q1);
		// Test that quote list is not empty
		assertNotNull("Test that there is are quotes in the list", quoteList);
		// Test that quoteList should display 1 quote
		assertEquals("Test that there is 1 quote in the quote list", 1, quoteList.size());
		// Test that q2 will not show up for sp1
		quoteList.add(q2);
		assertNotEquals("Test that q2 SpId is not 1", q2.getQuoteSpID(), 1);
	}
	
	@Test
	public void testDeleteQuote() {
		
	}
}
