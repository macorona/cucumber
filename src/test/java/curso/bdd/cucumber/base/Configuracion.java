package curso.bdd.cucumber.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Configuracion {
	public static String URL = "http://127.0.0.1:8887/#!/autenticar";
	public static String USER_NAME = "macorona";
	public static String PASSWORD = "Curso2021";
	
	public static String SCREENSHOTS_DIR = System.getProperty("user.dir")
			+ File.separator
			+ "screenshots"
			+ File.separator;
	
	public static String modifyWindows(String inPath) {
		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			return inPath + ".exe";
		} else {
			return inPath;
		}
	}
	
	public static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver",  modifyWindows(System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver"));
		return new ChromeDriver();
	}
	
	public static WebDriver createFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver",  modifyWindows(System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver"));
		return new FirefoxDriver();
	}
	
	public static WebDriver createEdgeDriver() {
		System.setProperty("webdriver.edge.driver",  modifyWindows(System.getProperty("user.dir") + File.separator + "drivers" + File.separator +  "msedgedriver"));
		return new EdgeDriver();
	}
	
	public static WebDriver createSafariDriver() {
		return new SafariDriver();
	}
	
	/*public static WebDriver createHtmlUnitDriver() {
		return new HtmlUnitDriver(true);
	}*/	

}
