package pi.vezbe.dto;

public class ChangePasswordDTO {
	
	private String oldPassword;
	private String newPassword;
	private String passwordConfirm;
	
	public ChangePasswordDTO(String oldPassword, String newPassword, String passwordConfirm) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.passwordConfirm = passwordConfirm;
	}
	
	public ChangePasswordDTO() {
		
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
