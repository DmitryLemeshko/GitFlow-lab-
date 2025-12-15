package utilits;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static void take(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(src.toPath(), new File("screenshots/" + name + ".png").toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
