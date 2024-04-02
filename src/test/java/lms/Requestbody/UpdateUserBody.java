package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UpdateUserPayLoad;
import lms.Utils.ExcelReader;

public class UpdateUserBody {
	String UserId = "U138";
	public UpdateUserPayLoad updateuserPayload;
	public List<UpdateUserPayLoad> Requestbody(String filePath, String querry){
		List<UpdateUserPayLoad> updateUserPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			updateuserPayload = new UpdateUserPayLoad();
			this.updateuserPayload.setUserComments(rowdata.get("usercomments"));
			this.updateuserPayload.setUserEduPg(rowdata.get("edupg"));
			this.updateuserPayload.setUserEduUg(rowdata.get("eduug"));
			this.updateuserPayload.setUserFirstName(rowdata.get("userfirstname"));
			this.updateuserPayload.setUserId(UserId);
			this.updateuserPayload.setUserLastName(rowdata.get("userlastname"));
			this.updateuserPayload.setUserLinkedinUrl(rowdata.get("linkdinurl"));
			this.updateuserPayload.setUserLocation("location");
			this.updateuserPayload.setUserLoginEmail(rowdata.get("loginemail"));;
			this.updateuserPayload.setUserMiddleName(rowdata.get("usermiddlename"));
			int phonenumber = (Integer.parseInt(rowdata.get("phonenumber")));
			this.updateuserPayload.setUserPhoneNumber(phonenumber);
			this.updateuserPayload.setUserTimeZone(rowdata.get("timezone"));
			this.updateuserPayload.setUserVisaStatus(rowdata.get("visastatus"));
			
			updateUserPayloadList.add(updateuserPayload);
		
		
		}
		return updateUserPayloadList;
		
	}
	
	
	public List<UpdateUserPayLoad> Requestbodygetting(String filePath,String querry){
		List<UpdateUserPayLoad> updateUserPayloadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowdata : data) {
			
			String comments = (rowdata.get("usercomments"));
			String eduPg = (rowdata.get("edupg"));
			String eduUg = (rowdata.get("eduug"));
			String firstname = (rowdata.get("userfirstname"));
			//this.updateuserPayload.setUserId(UserId);
			String lastname = (rowdata.get("userlastname"));
			String linkdinurl = (rowdata.get("linkdinurl"));
			String location = rowdata.get("location");
			String loginEmail = (rowdata.get("loginemail"));;
			String middleName =(rowdata.get("usermiddlename"));
			int phonenumber = (Integer.parseInt(rowdata.get("phonenumber")));
			String timeZone = (rowdata.get("timezone"));
			String visaStatus = (rowdata.get("visastatus"));
			UpdateUserPayLoad updateuserPayload = new UpdateUserPayLoad(comments, eduPg, eduUg, firstname, UserId, lastname,
					linkdinurl, location, loginEmail, middleName, phonenumber, timeZone, visaStatus);
			
			updateUserPayloadList.add(updateuserPayload);
		
		
		}
		return updateUserPayloadList;
		
	}
	
	
	
	
	
}
