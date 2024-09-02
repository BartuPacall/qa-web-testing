package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsMediaPage extends BasePage {

    private final By newsMediaHeader = By.xpath("//p[normalize-space()='Haber']");

    public NewsMediaPage(WebDriver driver) {
        super(driver);
    }

    public String getNewsMediaHeaderText() {
        return getElementText(newsMediaHeader);
    }
}
