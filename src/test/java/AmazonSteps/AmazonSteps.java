package AmazonSteps;
import Acciones.Acciones;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonSteps {

    private WebDriver driver;
    private Acciones acciones;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("window-size=1920,1200");
        System.setProperty("webdriver.chrome.whitelistedIps", "");

        driver = new ChromeDriver(options);
        acciones = new Acciones(driver);

    }


    @Given("The user in on Amazon search page")
    public void the_user_in_on_amazon_search_page() {
        acciones.amazonPage();
    }
    @When("the user searches for {string}")
    public void the_user_searches_for(String item) {
        acciones.searchBar(item);
    }

    @When("click on the first result shown")
    public void click_on_the_first_result_shown() {
        acciones.clickResultado();
    }
    @Then("check the price for the first result shown is more than {int}")
    public void check_the_price_for_the_first_result_shown_is_more_than(Integer precio) {
        acciones.precioMayor(precio);
    }

    @After
    public void Close (){
        driver.close();
    }

}
