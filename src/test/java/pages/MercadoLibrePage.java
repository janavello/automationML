package pages;

import org.openqa.selenium.WebDriver;

public class MercadoLibrePage extends WebBasePage{

    private String searchTextBox = "//input[@id='cb1-edit']";

    private String botonLupaMercadoLibre = "//header/div[1]/form[1]/button[1]/div[1]";

    private String nombrePrimerProducto = "//body/main[@id='root-app']/div[1]/div[2]/section[1]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/a[1]/h2[1]";


    private String nombrePP;
    private String precioPP;




    public MercadoLibrePage( ) {
        super(driver);
    }


    public void navigateToMercadoLibre(){
        navigateTo("https://www.mercadolibre.cl/");
    }

    public void escribirEnBarraDeBusqueda(String texto){
        write(searchTextBox,texto);
    }

    public void realizoBusqueda()   {
        clickElement(botonLupaMercadoLibre);

    }

    public void obtenerPrimerNombreProducto(){
        this.nombrePP = textFromElement(nombrePP);
        System.out.println("****************************************************************************");
        System.out.println(this.nombrePP);
        System.out.println("****************************************************************************");

    }
}
