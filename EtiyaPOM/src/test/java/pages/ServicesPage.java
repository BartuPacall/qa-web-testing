package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicesPage extends BasePage {

    private final By servicesHeader = By.xpath("//span[@class='services-h1-s']");

    public ServicesPage(WebDriver driver) {
        super(driver);
    }

    public String getServicesHeaderText() {
        return getElementText(servicesHeader);
    }
}
