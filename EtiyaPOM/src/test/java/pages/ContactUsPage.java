package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    private final By contactUsHeader = By.xpath("//div[contains(text(),'Bize Ulaşın')]");
    private final By successMessage = By.xpath("//div[@class='swal-text']");
    private final By okButton = By.xpath("//button[text()='OK']");
    private final By nameField = By.xpath("(//input[@placeholder='(*) Ad Soyad'])[1]");
    private final By emailField = By.xpath("(//input[@placeholder='(*) E-posta Adresi'])[1]");
    private final By phoneField = By.xpath("//input[@placeholder='(*) GSM']");
    private final By companyField = By.xpath("(//input[@placeholder='(*) Şirket'])[1]");
    private final By messageField = By.xpath("//textarea[@placeholder='(*) Mesajınız']");
    private final By sendButton = By.xpath("//button[@class='btn-send']");
    private final By privacyPolicyCheckBox = By.xpath("//ins[contains(text(),'Kampanya ve yeniliklerden haberdar olmak istiyorum')]");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public String getContactUsHeaderText() {
        return getElementText(contactUsHeader);
    }

    public void fillContactForm(String name, String email, String phone, String company, String message) throws InterruptedException {
        enterText(nameField, name);
        Thread.sleep(1000);
        enterText(emailField, email);
        Thread.sleep(1000);
        enterText(phoneField, phone);
        Thread.sleep(1000);
        enterText(companyField, company);
        Thread.sleep(1000);
        enterText(messageField, message);
    }

    public void clickPolicyBox(){
        clickElement(privacyPolicyCheckBox);
    }

    public void clickOkButton() {
        clickElement(okButton);
    }

    public void clickSendButton() {
        clickElement(sendButton);
    }

    public String getContactSuccessMessage() {
        return getElementText(successMessage);
    }
}