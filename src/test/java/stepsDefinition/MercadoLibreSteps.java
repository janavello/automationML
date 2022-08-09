package stepsDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MercadoLibrePage;


public class MercadoLibreSteps {
    MercadoLibrePage mercadoLibrePage = new MercadoLibrePage();

    @When("ingreso la palabra {string} en la barra de busqueda")
    public void ingresoLaPalabraEnLaBarraDeBusqueda(String arg0) {
        mercadoLibrePage.navigateToMercadoLibre();
    }

    @And("presiono le boton  buscar")
    public void presionoLeBotonBuscar() {
        
    }

    @Then("copio datos de las {string} primeras paginas de resultados")
    public void copioDatosDeLasPrimerasPaginasDeResultados(String arg0) {
    }

    @Given("abro el navegador chrome en la pagina de mercadolibre")
    public void abroElNavegadorChromeEnLaPaginaDeMercadolibre() {

    }
}
