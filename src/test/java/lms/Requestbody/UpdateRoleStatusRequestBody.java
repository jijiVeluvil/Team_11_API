package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UpdateRoleIdPayload;
import lms.Payload.UpdateRoleStatusPayload;
import lms.Utils.ExcelReader;

public class UpdateRoleStatusRequestBody {
	String UserId = "U138";
	public UpdateRoleStatusPayload updateRoleStatusPayload;

	public List<UpdateRoleStatusPayload> Requestbody(String filePath, String querry) {

		List<UpdateRoleStatusPayload> updateRoleStatusPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath, querry);
		for (Map<String, String> rowdata : data) {
			updateRoleStatusPayload = new UpdateRoleStatusPayload();
			updateRoleStatusPayload.setRoleId(rowdata.get("userRole2"));
			updateRoleStatusPayload.setUserRoleStatus(rowdata.get("status1"));

			updateRoleStatusPayloadList.add(updateRoleStatusPayload);

		}
		return updateRoleStatusPayloadList;

	}
}
