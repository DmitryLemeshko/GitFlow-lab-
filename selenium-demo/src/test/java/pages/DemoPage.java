package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPage {

    private WebDriver driver;

    private By title = By.tagName("h1");
    private By nameInput = By.name("username");
    private By submitButton = By.tagName("button");

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
