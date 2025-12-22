package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoPageTest {

    private WebDriver driver;

    @BeforeAll
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void demoHtmlTest() throws IOException {
        // Открываем локальный HTML
        File file = new File("D:/GitFlow/GitFlow-lab-/demo.html");
        driver.get(file.toURI().toString());
        takeScreenshot("01_open.png");

        // Находим поле ввода и вводим данные
        WebElement usernameInput = driver.findElement(By.id("name"));
        usernameInput.sendKeys("Demo: ім'я користувача");
        takeScreenshot("02_input.png");

        // Нажимаем кнопку "Обробити"
        WebElement processButton = driver.findElement(By.id("submit"));
        processButton.click();
        takeScreenshot("03_click.png");

        // Проверяем результат
        WebElement result = driver.findElement(By.id("result"));
        Assertions.assertEquals("DEMO: ІМ'Я КОРИСТУВАЧА", result.getText()); // учитываем, что JS делает toUpperCase
        takeScreenshot("04_result.png");
    }

    // Метод для сохранения скриншотов
    private void takeScreenshot(String filename) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotDir = new File("D:/GitFlow/GitFlow-lab-/screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        Files.copy(
                screenshot.toPath(),
                Paths.get(screenshotDir.getAbsolutePath(), filename),
                StandardCopyOption.REPLACE_EXISTING
        );
    }
}
