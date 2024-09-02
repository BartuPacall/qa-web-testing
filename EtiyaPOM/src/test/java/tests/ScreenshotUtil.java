package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String captureScreenShot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String userHome = System.getProperty("user.home");
            String destDir = userHome + "/IdeaProjects/EtiyaPOM/test-output/screenshots/";
            File dir = new File(destDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String dest = destDir + screenshotName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
