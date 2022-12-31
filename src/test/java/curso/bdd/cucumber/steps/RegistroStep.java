package curso.bdd.cucumber.steps;

import curso.bdd.cucumber.base.BaseUtil;
import curso.bdd.cucumber.pages.LoginPage;
import curso.bdd.cucumber.pages.RegisterPage;
import cucumber.api.java8.En;

import org.openqa.selenium.By;

import curso.bdd.cucumber.utils.Utilidades;
import cucumber.api.java8.En;


public class RegistroStep implements En{
	private BaseUtil baseUtil;
	private RegisterPage registerPage;
	
	public RegistroStep(BaseUtil baseUtil){
		Given("Navegar a la pagina de login {string}",(String pagina)->{
			System.out.println("Ingresar a la pagina de la aplicacion");
			this.baseUtil = baseUtil;
			this.baseUtil.getDriver().get(pagina);
			Utilidades.esperar(2000);
		});
		
		Given("Observo la pantalla con el formulario",()->{
			System.out.println("Observo la pantalla con el formulario");
			this.baseUtil = baseUtil;
			
			registerPage = new RegisterPage(this.baseUtil.getDriver());
			//this.baseUtil.getDriver().get("http://E20003634:8887/#!/registrar");
			registerPage.ingresarSeccionRegistrar();
			
			Utilidades.esperar(2000);
		});
		
		And("Coloco el nombre del usuario {string}",(String nombre)->{
			System.out.println("Colocar el nombre como "+nombre);
			registerPage.ingresarNombre(nombre);
			Utilidades.esperar(1000);
		});
		
		And("Selecciono el titulo {string}",(String titulo)->{
			System.out.println("Selecciono el titulo "+titulo);
			registerPage.seleccionaTitulo(titulo);
			Utilidades.esperar(1000);
		});
		
		And("Coloco el usuario {string}",(String usuario)->{
			System.out.println("Coloco el usuario"+usuario);
			registerPage.ingresarUsuario(usuario);
			Utilidades.esperar(1000);
		});
		
		And("Coloco el password {string}",(String password)->{
			System.out.println("Coloco el password "+password);
			registerPage.ingresarPassword(password);
			Utilidades.esperar(1000);
		});
		And("Selecciono la edad {string}",(String edad)->{
			System.out.println("Selecciono la edad "+edad);
			registerPage.seleccionarEdad(edad);
			Utilidades.esperar(1000);
		});
		
		And("Selecciono el genero {string}",(String genero)->{
			System.out.println("Selecciono la edad "+genero);
			registerPage.seleccionarGenero(genero);
			Utilidades.esperar(1000);
		});
		
		And("Coloco la confirmacion del password {string}",(String password)->{
			System.out.println("Coloco la confirmacion del password "+password);
			registerPage.ingresarConfPassword(password);
			Utilidades.esperar(1000);
		});
		And("Damos click en registro",()->{
			Utilidades.esperar(1000);
			registerPage.submitFormulario();
		});
		Then("Observo la alerta de registro exitoso",()->
		{
			Utilidades.esperar(3000);
		});
	}
}

