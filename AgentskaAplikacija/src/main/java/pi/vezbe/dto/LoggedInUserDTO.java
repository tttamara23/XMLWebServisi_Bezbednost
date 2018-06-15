package pi.vezbe.dto;

public class LoggedInUserDTO {
	
	private String name;
	private String role;
	
	public LoggedInUserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public LoggedInUserDTO(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
