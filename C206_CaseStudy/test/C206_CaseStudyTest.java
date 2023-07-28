import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private Administrator a1;
	private Administrator a2;
	private Administrator a3;
	
	private ArrayList<User> userList;
	private ArrayList<Administrator> adminList;
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Before
	public void setUp() throws Exception {
		u1 = new User("Addy", "addy@gmail.com", "password1", "95846024", "Choa Chu Kang St 21 Blk 398 #05-28");
		u2 = new User("Billy", "billy@yahoo.com", "password2", "86957206", "Hougang St 3 Blk 864 #21-09");
		u3 = new User("Celine", "celine@yahoo.com", "password3", "95726174", "Tampines 53 Pan Pacific Drive #11-35");
		u4 = new User("Daniel", "daniel@yahoo.com", "password4", "82910569", "Sengkang St 54 Rochester Drive #09-08");
		u5 = new User("Emilly", "emilly@gmail.com", "password5", "92847563", "Bukit Timah St 18 Waterway #09-08");
		a1 = new Administrator("robert", "robert@gmail.com", "adpassword1");
		a2 = new Administrator("thomas", "thomas@gmail.com", "adpassword2");
		a3 = new Administrator("bom", "bom@gmail.com", "adpassword3");
		
		userList = new ArrayList<User>();
		adminList =  new ArrayList<Administrator>();
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;
		u4 = null;
		u5 = null;
		a1 = null;
		a2 = null;
		a3 = null;
		userList = null;
		adminList = null;
	}

}
