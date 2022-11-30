package rough;

public class LoginPage {

	public LoginPage openLoginPage() {
		System.out.println("LoginPage is displayed");
		return this;
	}

	public LoginPage enterUserName() {
		System.out.println("Username is entered");
		return this;
	}

	public LoginPage enterPassword() {
		System.out.println("Password is entered");
		
		return this;
	}

	public HomePage clickOnLogin() {
		System.out.println("Login is clicked");
		
		return new HomePage();
	}
	
	

}
