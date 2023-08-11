import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Quote {
	private static int nextQuoteId = 0;
	private int quoteId;
	private int quoteUrID;
	private int quoteSpID;
	private String quoteService;
	private String quoteDetails;
	private double quoteAmount;
	private LocalDateTime responseDate;
	private static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH); // Date time format

	public String toString() {
		String toString = String.format("%-7d %-7d %-7d %-13s %-30s %-7.2f %-10s\n",getQuoteId(), GetQuoteUrID(),getQuoteSpID(),getQuoteService(),getQuoteDetails(),getQuoteAmount(),getResponseDate().format(dtFormat));
		return toString;
	}
	
	public Quote(int reqUrID, int reqSpID, String quoteService, String quoteDetails, double quoteAmount, LocalDateTime responseDate) {
		this.quoteId = nextQuoteId;
		this.quoteUrID = reqUrID;
		this.quoteSpID = reqSpID;
		this.quoteService = quoteService;
		this.quoteDetails = quoteDetails;
		this.quoteAmount = quoteAmount;
		this.responseDate = responseDate;
		
		nextQuoteId++;
	}
	
	public int getQuoteId() {
		return quoteId;
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

	public int GetQuoteUrID() {
		return quoteUrID;
	}

	public int getQuoteSpID() {
		return quoteSpID;
	}

	public LocalDateTime getResponseDate() {
		return responseDate;
	}
}
