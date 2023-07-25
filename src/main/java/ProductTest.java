import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class ProductTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Mazaady\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://staging.mazaady.com/login");


        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @DataProvider(name = "product-data")
    public Object[][] getProductData() {
        return new Object[][]{
                {"Luxurious Abaya", "CLOTHING, SHOES , BAGS", "100", "300", "125"},
                //TODO extendable to  add more test data as needed
        };
    }

    @Test(dataProvider = "product-data")
    public void testAddProduct(String title, String category, String startPrice, String buyNowPrice, String estimatePrice) throws InterruptedException, AWTException {
        loginPage.login("tester@task.com", "11111111");
        productPage.addProduct(title, category, startPrice, buyNowPrice, estimatePrice);
        Assert.assertTrue(driver.getTitle().contains("Mazaady"));
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
