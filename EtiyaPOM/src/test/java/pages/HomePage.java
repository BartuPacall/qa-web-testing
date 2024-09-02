package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By menuTitle = By.xpath("//div[@class='menu-title']");
    private final By acceptAllButton = By.xpath("//button[normalize-space()='Hepsini Kabul Et']");
    private final By aboutLink = By.xpath("//a[@class='child'][contains(text(),'Hakkımızda')]");
    private final By productsLink = By.xpath("//a[@class='child'][text()='Ürünler']");
    private final By solutionsLink = By.xpath("//a[@class='child'][text()='Çözümler']");
    private final By servicesLink = By.xpath("//a[@class='child'][text()='Servisler']");
    private final By blogLink = By.xpath("//div[@id='menu-container']//a[text()='Blog']");
    private final By newsMediaLink = By.xpath("//a[@class='child'][text()='Haber ve Medya']");
    private final By careerLink = By.xpath("//div[@id='menu-container']//a[text()='Kariyer']");
    private final By contactLink = By.xpath("(//a[contains(text(),'Bize Ulaşın')])[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuTitle() {
        clickElement(menuTitle);
    }

    public void acceptCookies() {
        clickElement(acceptAllButton);
    }

    public void clickAboutLink() {
        clickElement(aboutLink);
    }

    public void clickProductsLink() {
        clickElement(productsLink);
    }

    public void clickSolutionsLink() {
        clickElement(solutionsLink);
    }

    public void clickServicesLink() {
        clickElement(servicesLink);
    }

    public void clickBlogLink() {
        clickElement(blogLink);
    }

    public void clickNewsMediaLink() {
        clickElement(newsMediaLink);
    }

    public void clickCareerLink() {
        clickElement(careerLink);
    }

    public void clickContactLink() {
        clickElement(contactLink);
    }
}
