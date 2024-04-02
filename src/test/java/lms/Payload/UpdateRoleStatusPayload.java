package lms.Payload;

public class UpdateRoleStatusPayload {
	private String roleId;
	private String userRoleStatus;

	public UpdateRoleStatusPayload() {
		
	}
	public UpdateRoleStatusPayload(String roleId, String userRoleStatus) {
	
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	
}
