package lms.Payload;

public class UserRoleProgramBatchPayload {
	private int batchId;
	private String userRoleProgramBatchStatus;
	
	public UserRoleProgramBatchPayload() {
		
	}
	
	public UserRoleProgramBatchPayload(String batchId, String userRoleProgramString) {
		
	}

	
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getUserRoleProgramBatchStatus() {
		return userRoleProgramBatchStatus;
	}

	public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
		this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	}
	

}
