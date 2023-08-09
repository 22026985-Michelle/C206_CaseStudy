
public class Request {

	private static int nextRequestId = 1; // Static variable to keep track of the next ID
    private int requestId;
	private String requestTimeSlot;
	private String requestService;
	private String requestDetails;
	
	
	public Request(String requestId, String requestTimeSlot, String requestService, String requestDetails) {
		this.requestId = nextRequestId; // Assign the current nextRequestId value to RequestId
        nextRequestId++; // Increment nextRequestId for the next user
		this.requestTimeSlot = requestTimeSlot;
		this.requestService = requestService;
		this.requestDetails = requestDetails;
	}
	
	public int getRequestId() {
		return requestId;
	}
	
	
	
	public String getRequestTimeSlot() {
		return requestTimeSlot;
	}
	
	public void setRequestTimeSlot(String requestTimeSlot) {
		this.requestTimeSlot = requestTimeSlot;
	}
	
	public String getRequestService() {
		return requestService;
	}
	
	public void setRequestService(String requestService) {
		this.requestService = requestService;
	}
	
	public String getRequestDetails() {
		return requestDetails;
	}
	
	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}
	
}
