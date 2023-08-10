
public class Quote {
	private int reqUrID;
	private int reqSpID;
	private String quoteService;
	private String quoteDetails;
	private double quoteAmount;
	private boolean quoteCheck;
	
	public Quote(int reqUrID, int reqSpID, String quoteService, String quoteDetails, double quoteAmount) {
		this.reqUrID = reqUrID;
		this.reqSpID = reqSpID;
		this.quoteService = quoteService;
		this.quoteDetails = quoteDetails;
		this.quoteAmount = quoteAmount;
		this.quoteCheck = false;
	}

	public String getQuoteService() {
		return quoteService;
	}

	public void setQuoteService(String quoteService) {
		this.quoteService = quoteService;
	}

	public String getQuoteDetails() {
		return quoteDetails;
	}

	public void setQuoteDetails(String quoteDetails) {
		this.quoteDetails = quoteDetails;
	}

	public double getQuoteAmount() {
		return quoteAmount;
	}

	public void setQuoteAmount(double quoteAmount) {
		this.quoteAmount = quoteAmount;
	}

	public boolean isQuoteCheck() {
		return quoteCheck;
	}

	public void setQuoteCheck(boolean quoteCheck) {
		this.quoteCheck = quoteCheck;
	}

	public int getReqUrID() {
		return reqUrID;
	}

	public int getReqSpID() {
		return reqSpID;
	}

	
}
