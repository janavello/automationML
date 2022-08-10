package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.PrintWriter;

public class MercadoLibrePage extends WebBasePage{

    private String searchTextBox = "//input[@id='cb1-edit']";

    private String botonLupaMercadoLibre = "//header/div[1]/form[1]/button[1]/div[1]";

    private String nombrePrimerProducto = "//body/main[@id='root-app']/div[1]/div[2]/section[1]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/a[1]/h2[1]";

    private String nombrePrimerProductoV2 = "/html/body/main/div/div[2]/section/ol[1]/li[1]/div/div/a/div[1]/div[3]/h2";

    private String nombreSegundoProducto = "/html/body/main/div/div[2]/section/ol[1]/li[2]/div/div/a/div/div[3]/h2";

    private String nombreTercerProducto = "/html/body/main/div/div[2]/section/ol[1]/li[3]/div/div/a/div/div[3]/h2";

    private String nombreProductoGenerico = "(//a[@class='ui-search-result__content ui-search-link'])";

    private String precioProductoGenerico = "(//div[@class='ui-search-price__second-line'])";

    private String precioPrimerProducto = "//*[@id='root-app']/div/div[2]/section/ol[1]/li[1]/div/div/a/div/div[4]/h2";

    private String precioPrimerProductoV2 = "/html/body/main/div/div[2]/section/ol[1]/li[1]/div/div/a/div[1]/div[1]/div/div/div/span[1]/span[2]/span[2]";


    private String mensajeReintentar = "//*[@id='root-app']/div/div/div/p";
    private String btnEntendido = "/html/body/div[2]/div[1]/div[2]/button[1]";

    private String btnEquisEntendido = "/html/body/div[3]/div/div/div[2]/div/button";

    private String nombrePP;
    private String precioPP;

    public String[] listadoPreciosPagina;
    public String[] listadonombresPagina;



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
        this.nombrePP = textFromElement(nombrePrimerProductoV2);
        System.out.println("****************************************************************************");
        System.out.println(this.nombrePP);
        System.out.println("****************************************************************************");

    }
    public void obtenerPrimerPrecioProducto(){
        this.precioPP = textFromElement(precioPrimerProductoV2);
        System.out.println("****************************************************************************");
        System.out.println(this.precioPP);
        System.out.println("****************************************************************************");

    }


    public void obtenerNombresDeTodosLosProductos(){
        String[] listadonombresPagina = new String[54];
        String[] listadoLinksPagina = new String[54];
        String[] listadoPreciosPagina = new String[54];
        int varPrecio= 1;
        for (int i = 0; i < listadonombresPagina.length; i++) {
            WebElement t=driver.findElement(By.xpath(nombreProductoGenerico + "[" + (i + 1) + "]"));
            WebElement precio=driver.findElement(By.xpath(precioProductoGenerico + "[" + varPrecio + "]"));
            listadonombresPagina[i] = t.getAttribute("title");
            System.out.println("****************************************************************************");
            System.out.println(listadonombresPagina[i]);
            System.out.println("****************************************************************************");
            listadoLinksPagina[i] = t.getAttribute("href");
            System.out.println("****************************************************************************");
            System.out.println(listadoLinksPagina[i]);
            System.out.println("****************************************************************************");
            listadoPreciosPagina[i] = precio.getText().split("pesos")[0];
            System.out.println("****************************************************************************");
            System.out.println(listadoPreciosPagina[i]);
            System.out.println("****************************************************************************");
            varPrecio = varPrecio+2;

        }


        //Escritura en Archivo txt
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < listadonombresPagina.length; i++)
                pw.println("  ** Producto " +(i+1)+" : "+ listadonombresPagina[i] +
                        "  ** Precio Producto " + (i+1) + " : "+ listadoPreciosPagina[i] +
                        "  ** Link Producto " + (i+1) + " : "+ listadoLinksPagina[i] );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }



    public void ifValidarThenClickBtnEntendido(){
        if (elementIsDisplayed(btnEntendido)){
            clickElement(btnEntendido);
        }
    }

    public void ifValidarThenClickBtnEquisEntendido(){
        if (elementIsDisplayed(btnEquisEntendido)){
            clickElement(btnEquisEntendido);
        }
    }

    public void validoMensajeErrorYActualizoPagina(){
        if (isElementPresent(By.xpath(mensajeReintentar))){
            driver.navigate().refresh();
        }
    }
}
