package rough;

public class LoginPageTest {

	public static void main(String[] args) {
		LoginPage loginPage = new LoginPage();
//		loginPage.enterUserName();
//		loginPage.enterPassword();
//		loginPage.clickOnLogin();
		
		//Method Chaining
		loginPage
		.openLoginPage()
		.enterUserName()
		.enterPassword()
		.clickOnLogin()
		.changePassword("alpha", "Hacker78")
		.changeProfilePic("vv78.png");
		
	  
		
		

	}
}
