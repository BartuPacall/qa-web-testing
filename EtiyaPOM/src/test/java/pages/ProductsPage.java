package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By productsHeader = By.xpath("//span[@class='services-h1-s']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsHeaderText() {
        return getElementText(productsHeader);
    }
}
