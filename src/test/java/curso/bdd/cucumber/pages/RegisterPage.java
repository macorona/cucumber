package curso.bdd.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//elementos web
	@FindBy(how = How.ID, using="btnRegistrar")
	public WebElement btnRegistrar;	
	
	@FindBy(how = How.NAME, using="nombre")
	public WebElement txtNombre;
	
	@FindBy(how = How.ID, using="idLstTitulos")
	public WebElement lstTitulos;
	
	@FindBy(how = How.NAME, using="usuario")
	public WebElement txtUsuario;
	
	@FindBy(how = How.NAME, using="password")
	public WebElement txtPassword;
	
	@FindBy(how = How.NAME, using="confPassword")
	public WebElement txtConfPassword;
	
	@FindBy(how = How.XPATH, using="//input[@name='edad']")
	public List<WebElement> lstEdades;	
	
	@FindBy(how = How.ID, using="btnProcesoRegistrar")
	public WebElement btnProcesoRegistrar;
	
	
	@FindBy(how = How.XPATH, using="//input[@name='genero']")
	List<WebElement> lstGeneros;
	//metodos
	public void ingresarSeccionRegistrar() {
		btnRegistrar.click();
	}
	
	public void ingresarNombre(String nombre) {
		txtNombre.sendKeys(nombre);
	}
	
	public void seleccionaTitulo(String titulo) {
		new Select(lstTitulos).selectByVisibleText(titulo);	
	}
	
	public void seleccionarGenero(String genero) {
		for(WebElement element: lstGeneros ) {
			if(element.getAttribute("value").equals(genero) ) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", element);					
				break;
			}
		}
	}
	
	public void ingresarUsuario(String usuario) {
		txtUsuario.sendKeys(usuario);
	}
	
	public void ingresarPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void ingresarConfPassword(String password) {
		txtConfPassword.sendKeys(password);
	}
	
	public void seleccionarEdad(String edad) {
		int rangoEdad;
		for(WebElement element: lstEdades ) {
			rangoEdad=Integer.parseInt(element.getAttribute("value"));
			if(rangoEdad>= Integer.parseInt(edad)) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", element);					
				break;
			}
			
		}
	}
	
	public void submitFormulario() {
		btnProcesoRegistrar.click();
	}
}
