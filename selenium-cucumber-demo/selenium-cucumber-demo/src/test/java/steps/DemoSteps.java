package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class DemoSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("я відкриваю сторінку demo.html")
    public void я_відкриваю_сторінку_demo_html() {
        // Инициализация ChromeDriver (убедись, что chromedriver доступен)
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Укажи полный путь к своему файлу demo.html
        driver.get("file:///D:/GitFlow/GitFlow-lab-/demo.html");
    }

    @When("я вводжу ім'я {string}")
    public void я_вводжу_ім_я(String name) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        input.clear();
        input.sendKeys(name);
    }

    @When("натискаю кнопку {string}")
    public void натискаю_кнопку(String button) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        btn.click();
    }

    @Then("я бачу результат {string}")
    public void я_бачу_результат(String expected) {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        // Скрипт в HTML делает toUpperCase(), учитываем это при проверке
        assertEquals(expected.toUpperCase(), result.getText());
        driver.quit();
    }
}
