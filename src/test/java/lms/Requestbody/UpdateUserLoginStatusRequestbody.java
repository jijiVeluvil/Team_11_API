package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UpdateUserLoginStatusPayload;
import lms.Utils.ExcelReader;

public class UpdateUserLoginStatusRequestbody {

	public UpdateUserLoginStatusPayload updateUserLoginStatusPayload;
	List<String> roleIds = new ArrayList();
	public List<UpdateUserLoginStatusPayload> Requestbody(String filePath, String querry){
		
		List<UpdateUserLoginStatusPayload> updateUserLoginStatusPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			updateUserLoginStatusPayload = new UpdateUserLoginStatusPayload();
			this.updateUserLoginStatusPayload.setLoginStatus(rowdata.get("status1"));
			this.updateUserLoginStatusPayload.setPassword(rowdata.get("password"));
			
			roleIds.add(rowdata.get("userRole2"));
			this.updateUserLoginStatusPayload.setRoleIds(roleIds);
			this.updateUserLoginStatusPayload.setStatus(rowdata.get("status1"));
			this.updateUserLoginStatusPayload.setUserLoginEmail(rowdata.get("loginemail"));
						
			updateUserLoginStatusPayloadList.add(updateUserLoginStatusPayload);
		
		
		}
		return updateUserLoginStatusPayloadList;
		
	}

}
