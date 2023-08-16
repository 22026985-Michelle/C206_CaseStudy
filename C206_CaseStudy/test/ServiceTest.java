import static org.junit.Assert.*; 
 
import java.io.ByteArrayInputStream; 
import java.util.ArrayList; 
 
import org.junit.After; 
import org.junit.AfterClass; 
import org.junit.Before; 
import org.junit.BeforeClass; 
import org.junit.Test; 
 
public class ServiceTest { 
 
    private Service s1; 
    private Service s2; 
    private Service s3; 
    private Service s4; 
  
    private ArrayList<Service> serviceList; 
  
    @Before 
    public void setUp() throws Exception { 
 
        s1 = new Service(32456, "ToiletRenovation"); 
        s2 = new Service(33457, "BedroomRenovation"); 
 
        serviceList = new ArrayList<Service>(); 
 
        //Create an ArrayList of Services. 
        C206_CaseStudy.addService(serviceList, s1); 
        C206_CaseStudy.addService(serviceList, s2); 
 
   } 
  
 //User Story: 
 //As a Service Provider, I want to add new renovation services,  
 //so that the users are able to browse the new services and  
 //choose the one they want.    
    
    
   @Test 
   public void addServiceTest() { 
   
       //Add a renovation service to the current serviceList - Normal 
       //(id: 32321 , name: KitchenRenovation) 
       //Assert that the serviceproviderList now contains 3 records 
       s3 = new Service(32441, "KitchenRenovation"); 
       C206_CaseStudy.addService(serviceList, s3);  
       assertEquals(3, serviceList.size()); 
   
       //Check if the Service List exists - Boundary 
       //Assert that serviceList is not empty 
       assertNotNull(serviceList); 
 
       //Add a service provider with the same name to the current list - Error 
       //(id: 32321 , name: KitchenRenovation) 
       //Assert that the serviceList contains 3 records (The 4th record being rejected) 
       s4 = new Service(32441, "KitchenRenovation"); 
       C206_CaseStudy.addService(serviceList, s4);  
       assertEquals(3, serviceList.size()); 
 
       //Add a service provider with the same id to the current list - Error 
       //(id: 32321 , name: KitchenRenovation) 
       //Assert that the serviceList contains 3 records (The 4th record being rejected) 
       s4 = new Service(32441, "KitchenRenovation"); 
       C206_CaseStudy.addService(serviceList, s4);  
       assertEquals(3, serviceList.size()); 
 
 } 
  
 //User Story: 
 //As a Service Provider, I want to delete an existing renovation service,  
 //so that the users will only be able to see the services that are  
 //currently available to them.  
   
   
    @Test 
    public void deleteServiceTest() { 
 
        //Delete a service - Normal 
        //Delete a service provider. 
        C206_CaseStudy.deleteService(serviceList, s1); 
   
        //Check if the Service List exists - Boundary 
        //Assert that serviceList contains records 
        //Assert that the serviceList now contains 1 record 
        //(Since the first record has been deleted) 
        assertNotNull(serviceList); 
        assertEquals(1, serviceList.size()); 
 
        //Check if the deleted service is still in the serviceList by NAME - Normal 
        //Find Service with the name "ToiletRenovation". Assert Null, when method 
        //find, returns null. (Record not found) 
        assertNull(C206_CaseStudy.findServiceByName(serviceList, "ToiletRenovation")); 
   
        //Check if the deleted service is still in the serviceList by ID - Normal 
        //Find Service with the id 32456. Assert Null, when method 
        //find, returns null. (Record not found) 
        assertNull(C206_CaseStudy.findServiceById(serviceList, 32456)); 
    } 
  
 //User Story: 
 //As a Service Provider, I want to view all services currently  
 //available so that I can ensure that the platform’s services  
 //are well monitored and maintained. 
    @Test 
    public void viewServiceTest() { 
 
        //View current serviceList - Normal 
        //Assert that the number of services is 2. 
        assertEquals(2, serviceList.size()); 
 
        //No.2  Test - Delete all services and view the serviceList - Boundary 
        //Delete all service providers. 
        //Assert that the serviceList is empty (No records) 
        serviceList.clear();   
        assertEquals(0, serviceList.size()); 
 
        //Add a renovation service and view the serviceList - Normal 
        //Add a service. 
        //Assert that the number of service is 1. 
        serviceList.add(new Service(32441, "LivingRoomRenovation")); 
        assertEquals(1,serviceList.size()); 
 
 } 
  
    @After 
    public void tearDown() throws Exception { 
        s1 = null; 
        s2 = null; 
        s3 = null; 
        s4 = null; 
        serviceList.clear(); 
        System.setIn(System.in); 
   } 
 
}
