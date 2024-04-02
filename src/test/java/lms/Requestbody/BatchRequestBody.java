package lms.Requestbody;

import java.util.*;
import java.util.List;

import lms.Payload.BatchPayload;
import lms.StepDefinitions.BatchModule;
import lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram;
import lms.Utils.ExcelReader;

public class BatchRequestBody {
//   public static int  batchId;
	// int programId=17229;

	public BatchPayload batchPayload;

	public List<BatchPayload> Requestbody(String filePath, String querry) {
		List<BatchPayload> batchpayloadList = new ArrayList<>();
		ExcelReader er = new ExcelReader();

		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath, querry);
		for (Map<String, String> rowdata : data) {
			batchPayload = new BatchPayload();

			this.batchPayload.setBatchId(BatchModule.batchId);

			this.batchPayload.setBatchName(rowdata.get("batchName"));
			this.batchPayload.setBatchDescription(rowdata.get("batchDescription"));
			this.batchPayload.setBatchStatus(rowdata.get("batchStatus"));

			if (rowdata.get("batchNoOfClasses") != null && !"".equals(rowdata.get("batchNoOfClasses"))) {
				int batchnoOfClasses = (Integer.parseInt(rowdata.get("batchNoOfClasses")));
				this.batchPayload.setBatchNoOfClasses(batchnoOfClasses);
			}

			this.batchPayload.setProgramId(PostReqProgram.createdProgramId);

			this.batchPayload.setProgramName(rowdata.get("programName"));

			batchpayloadList.add(batchPayload);

		}
		return batchpayloadList;
	}
}
