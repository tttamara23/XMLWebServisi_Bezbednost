package pi.vezbe.dto;

public class SlikaDTO {
	
	private Long id;
	private String url;
	private Long idSmestaj;
	
	public SlikaDTO(Long id, String url, Long idSmestaj) {
		this.id = id;
		this.url = url;
		this.idSmestaj = idSmestaj;
	}
	
	public SlikaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getIdSmestaj() {
		return idSmestaj;
	}

	public void setIdSmestaj(Long idSmestaj) {
		this.idSmestaj = idSmestaj;
	}

}
