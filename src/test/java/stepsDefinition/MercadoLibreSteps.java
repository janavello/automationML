package stepsDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MercadoLibrePage;


public class MercadoLibreSteps {
    MercadoLibrePage mercadoLibrePage = new MercadoLibrePage();

    @When("ingreso la palabra {string} en la barra de busqueda")
    public void ingresoLaPalabraEnLaBarraDeBusqueda(String palabraABuscar) {
        mercadoLibrePage.escribirEnBarraDeBusqueda(palabraABuscar);
    }

    @And("presiono el boton  buscar")
    public void presionoElBotonBuscar() throws InterruptedException {
        mercadoLibrePage.realizoBusqueda();
    }

    @Given("abro el navegador chrome en la pagina de mercadolibre")
    public void abroElNavegadorChromeEnLaPaginaDeMercadolibre() {
        mercadoLibrePage.navigateToMercadoLibre();

    }

    @Then("copio datos de las {int} primeras paginas de resultados")
    public void copioDatosDeLasPrimerasPaginasDeResultados(int cantPaginas) {
        mercadoLibrePage.obtenerPrimerNombreProducto();
    }
}
