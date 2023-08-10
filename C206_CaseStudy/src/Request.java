import java.time.LocalDate;

public class Request {
	private static int nextReqId = 0;
	private int reqId;
	private int reqUrID;
	private int reqSpID;
	private String requestService;
	private String requestDetails;
	
	public Request(int reqUrID, int reqSpID, String requestService, String requestDetails) {
		this.reqId = nextReqId;
		this.reqUrID = reqUrID;
		this.reqSpID = reqSpID;
		this.requestService = requestService;
		this.requestDetails = requestDetails;
		
		nextReqId++;
	}
	
    public String toString() {
		
		// Write your codes here
		String requestInfo = String.format("%-10s %-25s %-15s %-25s %-16s\n",
				reqUrID,
				reqSpID,
				requestService,
				requestDetails);
		
		return requestInfo;
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

	public int getReqId() {
		return reqId;
	}

	public String getRequestService() {
		return requestService;
	}
	

	

	
}
