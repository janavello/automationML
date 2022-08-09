package pages;

import org.openqa.selenium.WebDriver;

public class MercadoLibrePage extends WebBasePage{


    public MercadoLibrePage( ) {
        super(driver);
    }


    public void navigateToMercadoLibre(){
        navigateTo("https://www.mercadolibre.cl/");
    }

}
