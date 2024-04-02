package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UpdateRoleIdPayload;
import lms.Utils.ExcelReader;

public class UpdateUserRoleIDRequestBody {

	public UpdateRoleIdPayload updateRoleIdPayload;
	List<String> roleList = new ArrayList();
	public List<UpdateRoleIdPayload> Requestbody(String filePath, String querry){
		
		List<UpdateRoleIdPayload> updateRoleIdPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			updateRoleIdPayload = new UpdateRoleIdPayload();
			
			String staffRole = rowdata.get("userRole2");
			
			roleList.add(staffRole);
			
			this.updateRoleIdPayload.setUserRoleList(roleList);
			
			
			updateRoleIdPayloadList.add(updateRoleIdPayload);
		
		
		}
		return updateRoleIdPayloadList;
		
	}
}
