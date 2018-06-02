package pi.vezbe.dto;

import java.util.List;

public class SearchDTO {
	private String destination;
	private String dateFrom;
	private String dateTo;
	private String numberOfPersons;
	private Long accommodationType;
	private Long category;
	private List<Long> searchServices;
	
	public SearchDTO() {
		
	}

	public SearchDTO(String destination, String dateFrom, String dateTo, String numberOfPersons,
			Long accommodationType, Long category, List<Long> searchServices) {
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

	public Long getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(Long accommodationType) {
		this.accommodationType = accommodationType;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public List<Long> getSearchServices() {
		return searchServices;
	}

	public void setSearchServices(List<Long> searchServices) {
		this.searchServices = searchServices;
	}
	
	
}
