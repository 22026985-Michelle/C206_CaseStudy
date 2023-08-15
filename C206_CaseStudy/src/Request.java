public class Request {
	private static int nextReqId = 1;
	private int reqId;
	private int reqUrID;
	private int reqSpID;
	private String requestService;
	private String requestDetails;
	private double reqAmount;
	private boolean reqCheck;
	
	public Request(int reqUrID, int reqSpID, String requestService, String requestDetails, double reqAmount) {
		this.reqId = nextReqId;
		nextReqId++;
		this.reqUrID = reqUrID;
		this.reqSpID = reqSpID;
		this.requestService = requestService;
		this.requestDetails = requestDetails;
		this.reqAmount = reqAmount;
		this.reqCheck = false;
		
	}
	
   public String toString() {
		
	   // Write your codes here
	   String requestInfo = String.format("%-15s %-10s %-15s %-15s %-15s %-16.2f\n",
			   reqId,
			   reqUrID,
			   reqSpID,
			   requestService,
			   requestDetails,
			   reqAmount);
		
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
	
	public void setRequestService(String requestService) {
		this.requestService = requestService;
	}
	
	public double getReqAmount() {
		return reqAmount;
	}
	
	public void setReqAmount(double requestAmount) {
		this.reqAmount = requestAmount;
	}

	public boolean getReqCheck() {
		return reqCheck;
	}

	public void setReqCheck(boolean reqCheck) {
		this.reqCheck = reqCheck;
	}
}
