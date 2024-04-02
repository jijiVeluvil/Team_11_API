package lms.Requestbody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lms.Payload.UserLogin;
import lms.Payload.UserPayload;
import lms.Payload.UserRoleMap;
import lms.Utils.ExcelReader;

public class UserModuleBody  {
	public  UserPayload userPayLoad;
	public  UserRoleMap UserRoleMap = new UserRoleMap();
	public  UserLogin userLogin = new UserLogin();
	
	@SuppressWarnings("rawtypes")
	public  List userRoleMaps = new ArrayList();

	@SuppressWarnings("unchecked")
	public  List<UserPayload> requestBody(String filePath, String querry) {
		List<UserPayload> userPayLoadList = new ArrayList();
		ExcelReader er = new ExcelReader();
		List<Map<String, String>> data = er.getExcelDataWithFilloAPI(filePath,querry);
		for (Map<String, String> rowData : data) {
			this.userPayLoad = new UserPayload();
			this.userPayLoad.setUserComments(rowData.get("userComments"));
			this.userPayLoad.setUserEduPg(rowData.get("userEduPg"));
			this.userPayLoad.setUserEduUg(rowData.get("userEduUg"));
			this.userPayLoad.setUserFirstName(rowData.get("userFirstName"));
			this.userPayLoad.setUserLastName(rowData.get("userLastName"));
			this.userPayLoad.setUserLinkedinUrl(rowData.get("userLinkedinUrl"));
			this.userPayLoad.setUserLocation(rowData.get("userLocation"));
			this.userLogin.setLoginStatus(rowData.get("loginStatus"));
			this.userLogin.setpassword(rowData.get("password"));
			this.userLogin.setuserLoginEmail(rowData.get("userLoginEmail"));
			//this.userLogin.add(UserLogin);
			this.userPayLoad.setUserLogin(userLogin);
			this.userPayLoad.setUserMiddleName(rowData.get("userMiddleName"));
			this.userPayLoad.setUserPhoneNumber(rowData.get("userPhoneNumber"));
			this.UserRoleMap.setRoleId(rowData.get("roleId"));
			this.UserRoleMap.setUserRoleStatus(rowData.get("userRoleStatus"));
			this.userRoleMaps.add(UserRoleMap);
			this.userPayLoad.setUserRoleMaps(userRoleMaps);
			this.userPayLoad.setUserTimeZone(rowData.get("userTimeZone"));
			this.userPayLoad.setUserVisaStatus(rowData.get("userVisaStatus"));
			userPayLoadList.add(userPayLoad);
		}
		return userPayLoadList;
	}

}


