package pi.vezbe.dto;

public class SlikaDTO {
	
	private Long id;
	private String url;
	private Long idSmestaj;
	
	public SlikaDTO(Long id, Long idSmestaj, String url) {
		this.id = id;
		this.idSmestaj = idSmestaj;
		this.url = url;
	}
	
	public SlikaDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSmestaj() {
		return idSmestaj;
	}

	public void setIdSmestaj(Long idSmestaj) {
		this.idSmestaj = idSmestaj;
	}

}
