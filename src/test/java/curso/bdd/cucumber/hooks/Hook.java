package curso.bdd.cucumber.hooks;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import curso.bdd.cucumber.base.BaseUtil;
import curso.bdd.cucumber.base.Configuracion;
import curso.bdd.cucumber.utils.Utilidades;


public class Hook {
	private BaseUtil baseUtil;
    //BaseUtil por injección de dependencias
	public Hook(BaseUtil base) {
		super();
		this.baseUtil = base;
	}
	
	@Before
	public void InicializarTest() {
		System.out.println("***Before");
		//baseUtil.setStepInfo("WebDriver");
		//baseUtil.setDriver(Configuracion.createChromeDriver());
		baseUtil.setDriver(Configuracion.createEdgeDriver());
		baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(), 10));
		baseUtil.getDriver().manage().window().maximize();
	}
	
	@After
	public void FinalizarTest(Scenario scenario) {
		System.out.println("****After");
		System.out.println(scenario.getName());
		System.out.println(scenario.getStatus());
		if(scenario.isFailed()) {
			System.out.print("Fallo el scenario");
		} else {
			System.out.print("\nNombre scenario: " + scenario.getName());
		}
		Utilidades.esperar(2000);
		System.out.print("\nCerrar el navegador\n");		
		baseUtil.getDriver().close();
		baseUtil.getDriver().quit();
	}	
}
