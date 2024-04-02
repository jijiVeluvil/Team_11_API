package lms.Payload;

import java.util.List;

public class UpdateRoleIdPayload {
	private List<String> userRoleList;
	public List<String> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<String> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public UpdateRoleIdPayload() {
		
	}
	public UpdateRoleIdPayload(String userRoleList) {
	
	}
	
}
