package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPage {
    private WebDriver driver;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.id("name");
    private By submitButton = By.id("submit");
    private By resultDiv = By.id("result");

    public void open(String path) {
        driver.get(path);
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getResult() {
        return driver.findElement(resultDiv).getText();
    }
}
