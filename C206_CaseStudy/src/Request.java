import java.time.LocalDate;

public class Request {

	private int reqUrID;
	private int reqSpID;
	private LocalDate requestTimeSlot;
	private String requestService;
	private String requestDetails;
	
	public Request(int reqUrID, int reqSpID, LocalDate requestTimeSlot, String requestService, String requestDetails) {
		super();
		this.reqUrID = reqUrID;
		this.reqSpID = reqSpID;
		this.requestTimeSlot = requestTimeSlot;
		this.requestService = requestService;
		this.requestDetails = requestDetails;
	}

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	public int getReqUrID() {
		return reqUrID;
	}

	public int getReqSpID() {
		return reqSpID;
	}

	public LocalDate getRequestTimeSlot() {
		return requestTimeSlot;
	}

	public String getRequestService() {
		return requestService;
	}
	

	

	
}
