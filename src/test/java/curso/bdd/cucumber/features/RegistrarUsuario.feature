Feature: Registrar un nuevo usuario en el sistema y validar sus credenciales 

	Background: Precondiciones para el escenario
  	Given Navegar a la pagina de login "http://127.0.0.1:8887/#!/autenticar"
  	
  Scenario: Registro de usuario
    Given Observo la pantalla con el formulario
    And Coloco el nombre del usuario "Fernando"
    And Selecciono el titulo "Ingeniero"
    And Coloco el usuario "Fer2022"
    And Coloco el password "123456"
    And Coloco la confirmacion del password "123456"
    And Selecciono la edad "24"
    And Selecciono el genero "male"
    And Damos click en registro
    Then Observo la alerta de registro exitoso
    
  Scenario: Validiar el nuevo usuario 
    Given Ingresar a la pagina de la aplicacion  
  	And Colocar el usuario como "Fer2022" y el password como "123456"
		And Dar clic en el botón Login
		Then Debo ver la página principal de la aplicación