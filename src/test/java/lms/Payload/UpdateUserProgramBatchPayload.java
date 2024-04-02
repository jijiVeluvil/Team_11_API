package lms.Payload;

import java.util.List;

public class UpdateUserProgramBatchPayload {
	
private String roleId;
private int programId;
private String userId;
private List<UserRoleProgramBatchPayload> userRoleProgramBatches;


public UpdateUserProgramBatchPayload() {
		
	}
public UpdateUserProgramBatchPayload(String roleId, String programId,
		String userId, UserRoleProgramBatchPayload userRoleProgramBatchPayload) {
	
}
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}

public int getProgramId() {
	return programId;
}
public void setProgramId(int programId) {
	this.programId = programId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<UserRoleProgramBatchPayload> getUserRoleProgramBatches() {
	return userRoleProgramBatches;
}
public void setUserRoleProgramBatches(List<UserRoleProgramBatchPayload> userRoleProgramBatches) {
	this.userRoleProgramBatches = userRoleProgramBatches;
}


}
