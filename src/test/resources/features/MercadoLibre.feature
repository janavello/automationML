@MercadoLibre
Feature: Automatizacion MercadoLibre camisetas

  Scenario: 01 - Buscar en mercadolibre
    Given abro el navegador chrome en la pagina de mercadolibre
    When ingreso la palabra "camiseta" en la barra de busqueda
    And presiono le boton  buscar
    Then copio datos de las "" primeras paginas de resultados