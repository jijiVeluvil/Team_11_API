package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UpdateUserProgramBatchPayload;
import lms.Payload.UserRoleProgramBatchPayload;
import lms.StepDefinitions.BatchModule;
import lms.StepDefinitions.UserModule;
import lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram;
import lms.Utils.ExcelReader;

public class UpdateUserProgramBatchRequestbody {

	public List userRoleProgramList = new ArrayList();
	public UpdateUserProgramBatchPayload updateUserProgramBatchPayload;
	public List<UpdateUserProgramBatchPayload> Requestbody(String filePath, String querry){
	
		List<UpdateUserProgramBatchPayload> updateUserProgramBatchPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			updateUserProgramBatchPayload= new UpdateUserProgramBatchPayload();
			updateUserProgramBatchPayload.setProgramId(PostReqProgram.createdProgramId);
			updateUserProgramBatchPayload.setRoleId(rowdata.get("userRole2"));
			updateUserProgramBatchPayload.setUserId(UserModule.UserId);
			UserRoleProgramBatchPayload payload =new UserRoleProgramBatchPayload();
			payload.setBatchId(BatchModule.batchId);
			payload.setUserRoleProgramBatchStatus(rowdata.get("status1"));
			userRoleProgramList.add(payload);
			updateUserProgramBatchPayload.setUserRoleProgramBatches(userRoleProgramList);
			
			
			
		updateUserProgramBatchPayloadList.add(updateUserProgramBatchPayload);
		
		
		}
		return updateUserProgramBatchPayloadList;
		
	}
}
