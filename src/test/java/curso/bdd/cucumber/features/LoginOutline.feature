Feature: Validar el ingreso al sistema

  Scenario Outline: Autenticarse con las credenciales correctas de manera Outline
    Given Ingresar a la pagina de la aplicacion
    And Colocar las credenciales <usuario> y <password>
    And Dar clic en el botón Login
    Then Debo ver la página principal de la aplicación

    Examples: 
      | usuario  | password |
      | macorona |        5 |
      | tias2020 |        6 |
