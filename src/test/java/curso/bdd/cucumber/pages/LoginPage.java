package curso.bdd.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//elementos web
	@FindBy(how = How.ID, using="idUsername")
	private WebElement txtUserName;
	
	@FindBy(how = How.ID, using="idPassword")
	private WebElement txtPassword;

	@FindBy(how = How.ID, using="btnLogin")
	private WebElement btnLogin;

	//métodos
	public void ingresarCredenciales(String usuario, String password ) {
		txtUserName.sendKeys(usuario);
		txtPassword.sendKeys(password);
	}
	
	public void submitCredenciales() {
		btnLogin.click();
	}
}
