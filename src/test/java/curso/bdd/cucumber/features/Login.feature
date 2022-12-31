Feature: Validar el ingreso al sistema

	Background: Precondiciones para el escenario
  	Given Ingresar a la pagina de la aplicacion

  Scenario: Autenticarse con las credenciales correctas
    Given Inicializar page
		And Colocar el usuario como "macorona" y el password como "Curso2021"
    And Dar clic en el botón Login
    Then Debo ver la página principal de la aplicación
