package rough;

public class HomePage {

	public HomePage changeProfilePic(String fileName) {

		System.out.println("changeProfilePic with: " + fileName);

		return this;
	}

	public HomePage changePassword(String username, String password) {
		System.out.println("Updated passwoed with new password: " + password);

		return this;
	}
}
