package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

    private final By aboutHeader = By.xpath("//h1[contains(text(),'Hakkımızda')]");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getAboutHeaderText() {
        return getElementText(aboutHeader);
    }
}
