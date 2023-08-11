
import java.time.LocalDate;

public class Appointment {
	
	private int appointmentId;
	private String appointmentService;
	private String appointmentStatus;
	private LocalDate appointmentDate;
	private String appointmentDescription;
	private int urAppointment;
	private int spAppointment;

	
	public Appointment(int appointmentId,String appointmentService, String appointmentStatus, LocalDate appointmentDate,
			String appointmentDescription,int UrAppointment,int SPAppointment) {
		this.appointmentId=appointmentId;
		this.appointmentService = appointmentService;
		this.appointmentStatus = appointmentStatus;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
		this.urAppointment = urAppointment;
		this.spAppointment = spAppointment;
	
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


	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
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
