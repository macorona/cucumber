package curso.bdd.cucumber.steps;

//import static org.testng.Assert.assertTrue;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.java8.En;
import curso.bdd.cucumber.base.BaseUtil;
import curso.bdd.cucumber.pages.LoginPage;
import curso.bdd.cucumber.utils.Utilidades;
import io.cucumber.datatable.DataTable;
import curso.bdd.cucumber.base.Credencial;



public class LoginStep implements En {
	private BaseUtil baseUtil;
	private LoginPage loginPage;
	
	public LoginStep(BaseUtil baseUtil) {
		
		//this.loginPage = new LoginPage(this.base.driver);
		/*DataTableType((Map<String, String> entry) -> new Credencial (
	            entry.get("usuario"),
	            entry.get("password")
		));*/

	    /*@ParameterType(".*")
	    public String usuario(String email) {
	    	return email.concat("@com.mx");
	    }*/	

	    //ParameterType("email", ".*", (String email) -> email + "@com.mx" );
		Given("^Ingresar a la pagina de la aplicacion$", () -> {
			this.baseUtil = baseUtil;
			//System.out.println("El driver es: " + this.base.driver);
			System.out.println("Ingreso a la página");
			loginPage = new LoginPage(this.baseUtil.getDriver());
			this.baseUtil.getDriver().get("http://127.0.0.1:8887/#!/autenticar");
			
		});		
		

		//Given("^Ingresar a la pagina de la aplicacion$", () -> {
		Given("^Inicializar page$", () -> {
			//this.baseUtil = baseUtil;
			//System.out.println("El driver es: " + this.base.driver);
			System.out.println("Inicializar clase page ...");
			loginPage = new LoginPage(this.baseUtil.getDriver());
			//this.baseUtil.getDriver().get("http://127.0.0.1:8887/#!/autenticar");
			
		});

		And("Colocar el usuario como {string} y el password como {string}", (String usuario, String password) -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println("Usuario: " + usuario);
			System.out.println("Password: " + password);
			//this.loginPage = new LoginPage(this.base.driver);
			this.loginPage.ingresarCredenciales(usuario, password);	
			Utilidades.esperar(2000);
		});
		
		And("^Dar clic en el botón Login$", () -> {
			System.out.println("Clic en botón login");
			//this.base.driver.findElement(By.id("btnLogin")).click();
			//this.loginPage = new LoginPage(this.base.driver);
			this.loginPage.submitCredenciales();
		});

		Then("^Debo ver la página principal de la aplicación$", () -> {
			// Write code here that turns the phrase above into concrete actions
			assertTrue("No estoy en la página principal", this.baseUtil.getDriver().findElement(By.id("nav-mobile")).isDisplayed());
			System.out.println("Estoy en la página principal");
		});
		
		/*And("Colocar credenciales", (io.cucumber.datatable.DataTable dataTable) -> {
			System.out.println("table: " + dataTable.asLists());
			List<Map<String, String>> usuarios = dataTable.asMaps(String.class, String.class);
			String usuario = usuarios.get(0).get("usuario");
			String password = usuarios.get(0).get("password");
			
			System.out.println("Mis crdenciales: " + usuario + " - " + password);
			

		});*/

		/*And("Colocar las credenciales", (DataTable table) -> {
			List<String> credenciales = table.asList();
			String usuario = credenciales.get(0);
			String password = credenciales.get(1);
			//System.out.println("table: " + table.asLists());
			System.out.println("Usuario: " + usuario);
			System.out.println("Password: " + password);
			this.baseUtil.getDriver().findElement(By.id("idUsername")).sendKeys(credenciales.get(0));
			this.baseUtil.getDriver().findElement(By.id("idPassword")).sendKeys(credenciales.get(1));	

			Utilidades.esperar(2000);	
			
		});*/

		/*And("Colocar credenciales", (io.cucumber.datatable.DataTable dataTable) -> {
			// Write code here that turns the phrase above into concrete actions
			List<Credencial> lstCredenciales = new ArrayList<>();
			lstCredenciales = dataTable.asList(Credencial.class);
			System.out.println("lstCredenciales: " + lstCredenciales);
			for (Credencial cred: lstCredenciales) {
				System.out.println("Usuario: " + cred.getUsuario());
				System.out.println("Password: " + cred.getPassword());
			}

		});*/
		
		//Outline
		And("Colocar las credenciales (.*) y (.*)",(String usuario,String password)->{
			System.out.println("Usuario: "+usuario);
			System.out.println("Password: "+password);
			this.baseUtil.getDriver().findElement(By.id("idUsername")).sendKeys(usuario);
			this.baseUtil.getDriver().findElement(By.id("idPassword")).sendKeys(password);
		});




	}

}
