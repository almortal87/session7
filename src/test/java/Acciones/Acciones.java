package Acciones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Acciones {

    public WebDriver driver;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchbar;
/*
    @FindBy(className = "a-size-medium a-color-base a-text-normal")
    private WebElement primerResultado;
   */
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")
    private WebElement primerResultado;

    @FindBy(xpath = "(//span[@class='a-price-whole'])[6]")
    private WebElement precio;

    public Acciones(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void amazonPage() {
        driver.get("https://www.amazon.com");
    }


    public void searchBar(String item) {
        searchbar.sendKeys(item);
        searchbar.submit();
    }

    public void clickResultado (){
        primerResultado.click();
    }

    public void precioMayor (int precioMinimo){
        System.out.println(precio.getText());
        Assert.assertTrue(Integer.parseInt(precio.getText())>precioMinimo);
    }

}
