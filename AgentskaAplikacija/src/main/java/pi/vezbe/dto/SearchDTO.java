package pi.vezbe.dto;

import java.util.List;

public class SearchDTO {
	private String destination;
	private String dateFrom;
	private String dateTo;
	private String numberOfPersons;
	private String accommodationType;
	private String category;
	private List<String> searchServices;
	
	public SearchDTO() {
		
	}

	public SearchDTO(String destination, String dateFrom, String dateTo, String numberOfPersons,
			String accommodationType, String category, List<String> searchServices) {
		this.destination = destination;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.numberOfPersons = numberOfPersons;
		this.accommodationType = accommodationType;
		this.category = category;
		this.searchServices = searchServices;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getSearchServices() {
		return searchServices;
	}

	public void setSearchServices(List<String> searchServices) {
		this.searchServices = searchServices;
	}
	
	
}
