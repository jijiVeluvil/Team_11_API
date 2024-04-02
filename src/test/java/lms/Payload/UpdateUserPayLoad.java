package lms.Payload;

public class UpdateUserPayLoad {
	
	private String userComments;
	private String userEduPg;
	private String userEduUg;
	private String userFirstName;
	private String userId;
	private String userLastName;
	private String userLinkedinUrl;
	private String userLocation;
	private String userLoginEmail;
	private String userMiddleName;
	private int userPhoneNumber;
	private String userTimeZone;
	private String userVisaStatus;

	

	public UpdateUserPayLoad() {
		
	}
		
		
	public UpdateUserPayLoad(String userComments, String userEduPg,String userEduUg, String userFirstName,
			String userId, String userLastName, String userLinkedinUrl, String userLocation,String userLoginEmail, String userMiddleName,
			int userPhoneNumber, String userTimeZone, String userVisaStatus) {
	
	}


	public String getUserComments() {
		return userComments;
	}


	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}


	public String getUserEduPg() {
		return userEduPg;
	}


	public void setUserEduPg(String userEduPg) {
		this.userEduPg = userEduPg;
	}


	public String getUserEduUg() {
		return userEduUg;
	}


	public void setUserEduUg(String userEduUg) {
		this.userEduUg = userEduUg;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserLinkedinUrl() {
		return userLinkedinUrl;
	}


	public void setUserLinkedinUrl(String userLinkedinUrl) {
		this.userLinkedinUrl = userLinkedinUrl;
	}


	public String getUserLocation() {
		return userLocation;
	}


	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}


	public String getUserLoginEmail() {
		return userLoginEmail;
	}


	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}


	public String getUserMiddleName() {
		return userMiddleName;
	}


	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}


	public int getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(int userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public String getUserTimeZone() {
		return userTimeZone;
	}


	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}


	public String getUserVisaStatus() {
		return userVisaStatus;
	}


	public void setUserVisaStatus(String userVisaStatus) {
		this.userVisaStatus = userVisaStatus;
	}

}
