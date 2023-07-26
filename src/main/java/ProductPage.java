import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class ProductPage {
    private WebDriver driver;

    private Actions actions;

    @FindBy(xpath = "//a[contains(text(),'Add Product')]")
    private WebElement addProductButton;

    @FindBy(xpath = "//form//button[@type='button']")
    private WebElement stepOneButton;

    @FindBy(xpath =  "//*[@id=\"step-2\"]/span/div[2]/div[13]/div/button[2]")
    private WebElement stepTwoButton;

    @FindBy(xpath ="//button[contains(@class,'btn-buy') and contains(text(), 'Next Step')]")
    private WebElement stepThreeButton;

    @FindBy(xpath = "//button[@class='close'][@data-dismiss='modal']")
    private WebElement closeButton;

    @FindBy(name = "title")
    private WebElement titleInput;

    @FindBy(xpath = "//input[@placeholder='select category']")
    private WebElement categoryInput;

    @FindBy(xpath = "//input[@placeholder='select subcategory']")
    private WebElement subCategory;

    @FindBy(xpath = "//input[@placeholder='Select Class']")
    private WebElement classType;

    @FindBy(xpath = "//input[@placeholder='Select Brand']")
    private WebElement brandType;

    @FindBy(xpath = "//input[@placeholder='Select Type']")
    private WebElement type;

    @FindBy(xpath = "//td[@data-type='General'][@data-value='S']")
    private WebElement sizeElement;

    @FindBy(xpath = "//input[@placeholder='Select Material Made']")
    private WebElement materialMade;

    @FindBy(xpath = "//input[@placeholder='Select Color']")
    private WebElement color;

    @FindBy(xpath = "//input[@placeholder='Select Condition']")
    private WebElement condition;

    @FindBy(css = "input[aria-autocomplete='list'][aria-labelledby='vs13__combobox'][aria-controls='vs13__listbox'][type='search'][autocomplete='off'][class='vs__search']")
    private WebElement countryMade;

    @FindBy(name = "415")
    private WebElement modelNumber;
    @FindBy(xpath = "//input[@placeholder='Quantity']")
    private WebElement quantity;

    @FindBy(css = "input[aria-autocomplete='list'][aria-labelledby='vs5__combobox'][aria-controls='vs5__listbox'][type='search'][autocomplete='off'][class='vs__search']")
    private WebElement country;

    @FindBy(css = "input[aria-autocomplete='list'][aria-labelledby='vs6__combobox'][aria-controls='vs6__listbox'][type='search'][autocomplete='off'][class='vs__search']")
    private WebElement state;

    @FindBy(css = "input[aria-autocomplete='list'][aria-labelledby='vs7__combobox'][aria-controls='vs7__listbox'][type='search'][autocomplete='off'][class='vs__search']")
    private WebElement city;

    @FindBy(xpath = "//input[@placeholder='Product Address']")
    private WebElement productAddress;

    @FindBy(id = "tinymce_description_ifr")
    private  WebElement auctionDetails;
    @FindBy(id =  "tinymce_policy_ifr")
    private WebElement policyAndExchangeDetails;

    @FindBy(xpath = "//*[@id=\"step-2\"]/span/div[2]/div[10]/div/div/div[1]/div/div[3]/label")
    private  WebElement mainImageLabel;

    @FindBy(xpath = "//*[@id=\"vs8__combobox\"]")
    private WebElement currencyInput;

    @FindBy(xpath ="//input[@placeholder='Starting Bid Value']")
    private WebElement startPriceInput;

    @FindBy(xpath = "//input[@placeholder='Bid Increment Value']")
    private WebElement bidIncrement;

    @FindBy(xpath = "//input[@placeholder='Buy Now Value']")
    private WebElement buyNowPriceInput;

    @FindBy(xpath = ".//button[@type='submit' and @class='btn btn-buy pl-5 pr-5 pt-2 pb-2 m-auto']")
    private WebElement addButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProduct(String title, String category, String startPrice, String buyNowPrice, String estimatePrice) throws InterruptedException, AWTException {

        //dismiss the pop up that appears after login
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-secondary"))).click();

        // Find the element to hover over
        // Get the dropdown menu element
        WebElement dropdownMenu = driver.findElement(By.className("dropdown"));

        // Wait until the dropdown menu is visible
        wait.until(ExpectedConditions.visibilityOf(dropdownMenu));

        // Create an Actions object and move the mouse to the element
        actions = new Actions(driver);
        actions.moveToElement(dropdownMenu).perform();

        // Wait until the AddProduct is appeared
        wait.until(ExpectedConditions.visibilityOf(addProductButton));
        actions.moveToElement(addProductButton).click().build().perform();

        stepOneButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        titleInput.click();
        titleInput.sendKeys(title);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        categoryInput.click();
        categoryInput.sendKeys(category+ "\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        subCategory.click();
        subCategory.sendKeys("Clothes\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        classType.click();
        classType.sendKeys("Arabian clothes\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        brandType.click();
        brandType.sendKeys("Al Aseel\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        type.click();
        type.sendKeys("Abaya\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        sizeElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        materialMade.click();
        materialMade.sendKeys("Canvas\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        color.click();
        color.sendKeys("Black\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        condition.click();
        condition.sendKeys("New\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        modelNumber.click();
        modelNumber.sendKeys("415\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        countryMade.click();
        countryMade.sendKeys("United States\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        quantity = driver.findElement(By.xpath("//input[@placeholder='Quantity']"));
        quantity.click();
        quantity.sendKeys("2\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        country.click();
        country.sendKeys("Bahamas\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        state.click();
        state.sendKeys("Hope Town\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        city.click();
        city.sendKeys("Hope Town\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        productAddress.click();
        productAddress.sendKeys("California, USA\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        auctionDetails.click();
        driver.switchTo().frame(auctionDetails);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('body').innerHTML = '<div>Auction Title: Luxurious Black Abaya - Perfect for Special Occasions!</div><p>Description: This stunning black Abaya is made from high-quality fabric and features. Bid now and make a statement</p>';");


        // Switch back to the parent frame
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        policyAndExchangeDetails.click();
        driver.switchTo().frame(policyAndExchangeDetails);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('body').innerHTML = '<div>Exchange Policy: Exchange allowed within 7 days of delivery!</div><p> Return Policy: No returns or exchanges after 7 days</p>';");

        // Switch back to the parent frame
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Locate the label element using its 'data-v-6ff5a0de' attribute
        // Click on the element to open the file dialog
        mainImageLabel.click();

        // Wait for the file dialog to appear
        // Simulate key presses to navigate to the file after dialog box is opened
        String filePath = "Image.jpg";
        StringSelection ss = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss, ss);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000); // Wait for the file dialog to catch up
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        /**dismiss the pop up that appears after uploading the mainImage successfully**/
//        WebDriverWait waitFour = new WebDriverWait(driver, 50);
//        waitFour.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-secondary"))).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        // TODO Add the productsImage function should be the same as the mainImageUpload but different webElement

        stepTwoButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find the Starting Bid field
        // Enter the value 500 into the field
        startPriceInput.sendKeys(startPrice);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Enter the value 200 into the field
        bidIncrement.sendKeys(estimatePrice);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Enter the value 700 into the field
        buyNowPriceInput.sendKeys(buyNowPrice);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        currencyInput.click();
        currencyInput.sendKeys("USA (USD)\n");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        stepThreeButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Submit the form Step 4
        // Inspect the element we can use logger later for clean code
        System.out.println(addButton.toString());

        // Click the button
        addButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

