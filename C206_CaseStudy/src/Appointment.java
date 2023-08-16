import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Appointment {
	
	private static int nextAppointmentId =0;
	private int appointmentId;
	private String appointmentService;
	private String appointmentStatus;
	private LocalDate appointmentDate;
	private static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
	private String appointmentDescription;
	private int urAppointment;
	private int spAppointment;


	
	public Appointment(int urAppointment,int spAppointment ,String appointmentService,String appointmentStatus,LocalDate appointmentDate,String appointmentDescription) {
		this.appointmentId=nextAppointmentId;
		this.appointmentService = appointmentService;
		this.appointmentStatus = appointmentStatus;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
		this.urAppointment = urAppointment;
		this.spAppointment = spAppointment;
		nextAppointmentId++;
	
	}
	
	public String toString() {
		   // Write your codes here
		   String AppointmentInfo = String.format("%-15d %-9d %-21d %-9s %-10s %-9s %-9s \n",
				   getAppointmentId(),
				   getUrAppointment(),
				   getSPAppointment(),
				   getAppointmentService(),
				   getAppointmentStatus(),
				   getAppointmentDate().toString(),
				   getAppointmentDescription());
			
		   return AppointmentInfo;
		}
	
	public int getAppointmentId(){
		return appointmentId;
	}


	public String getAppointmentService() {
		return appointmentService;
	}


	public void setAppointmentService(String appointmentService) {
		this.appointmentService = appointmentService;
	}


	public String getAppointmentStatus() {
		return appointmentStatus;
	}


	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(LocalDate newdate) {
		this.appointmentDate = newdate;
	}

	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}


	public void setAppointmentDescription(String appointmentDescription) {
		this.appointmentDescription = appointmentDescription;
	}
	
	
	public int getUrAppointment() {
		return urAppointment;
	}


	public void setUrAppointment(int urAppointment) {
		this.urAppointment = urAppointment;
	}
	
	public int getSPAppointment() {
		return spAppointment;
	}


	public void setSPAppointment(int spAppointment) {
		this.spAppointment = spAppointment;
	}
	
	

}
