package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage extends BasePage {
    private final By careerHeader = By.xpath("//h1[@class='h1']");
    private final By emailField = By.name("email");
    private final By successMessage = By.xpath("//span[contains(text(),'Mesajınızı başarıyla aldık.')]");
    private final By monthlyCheckBox = By.xpath("//label[@for='monthly']//span");
    private final By newsAnnouncementBox = By.xpath("//label[@for='newsannu']//span");
    private final By securityBox = By.xpath("//label[@for='term']//span");
    private final By sendButton = By.xpath("//button[@id='send-newsl']");

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public String getCareerHeaderText() {
        return getElementText(careerHeader);
    }

    public void fillCareerForm(String email) {
        enterText(emailField, email);
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    public void clickBoxes() throws InterruptedException {
        clickElement(monthlyCheckBox);
        Thread.sleep(1000);
        clickElement(newsAnnouncementBox);
        Thread.sleep(1000);
        clickElement(securityBox);
        Thread.sleep(1000);
    }
    public void send() throws InterruptedException {
        clickElement(sendButton);
        Thread.sleep(1000);
    }
}
