package lms.Payload;

public class UserLogin {
	private String loginStatus;
	private String password;
	private String userLoginEmail;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getuserLoginEmail() {
		return userLoginEmail;
	}
	public void setuserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	

}
