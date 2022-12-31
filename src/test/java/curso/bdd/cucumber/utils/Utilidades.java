package curso.bdd.cucumber.utils;

public class Utilidades {
	public static void esperar(long tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
	}
}
