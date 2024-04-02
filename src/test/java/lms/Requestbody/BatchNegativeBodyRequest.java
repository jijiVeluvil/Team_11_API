package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.BatchPayload;
import lms.Utils.ExcelReader;

public class BatchNegativeBodyRequest {
	public BatchPayload batchPayload;
	//List<UpdateUserBody> updateUserPayloadList = new ArrayList<>();
	public List<BatchPayload> Requestbody(String filePath, String querry){
		List<BatchPayload> batchpayloadList = new ArrayList<>();
		ExcelReader er = new ExcelReader();
		//List<Map<String, String>> data = er.getExcelDataWithFilloAPI(ConstantFilePaths.USER_MODULE_DATA,
		//		ConstantFilePaths.UPDATE_USER_QUERRY);
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			batchPayload = new BatchPayload();
			
			if (rowdata.get("batchId") != null && !"".equals(rowdata.get("batchId"))) {
				int batchId = (Integer.parseInt(rowdata.get("batchId")));
				this.batchPayload.setBatchId(batchId);
			}
		
			this.batchPayload.setBatchName(rowdata.get("batchName"));
			this.batchPayload.setBatchDescription(rowdata.get("batchDescription"));
			this.batchPayload.setBatchStatus(rowdata.get("batchStatus"));
			
			if (rowdata.get("batchNoOfClasses") != null && !"".equals(rowdata.get("batchNoOfClasses"))) {
				int batchnoOfClasses = (Integer.parseInt(rowdata.get("batchNoOfClasses")));
				this.batchPayload.setBatchNoOfClasses(batchnoOfClasses);
			}
			
		
			
			if (rowdata.get("programId") != null && !"".equals(rowdata.get("programId"))) {
				int programId = (Integer.parseInt(rowdata.get("programId")));
				this.batchPayload.setProgramId(programId);
			}
			this.batchPayload.setProgramName(rowdata.get("programName"));
			
			batchpayloadList.add(batchPayload);
		
		
		}
		return batchpayloadList;
}
}


