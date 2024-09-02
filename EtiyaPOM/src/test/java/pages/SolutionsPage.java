package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SolutionsPage extends BasePage {

    private final By solutionHeader = By.xpath("//span[@class='services-h1-s']");

    public SolutionsPage(WebDriver driver) {
        super(driver);
    }

    public String getSolutionsHeaderText() {
        return getElementText(solutionHeader);
    }
}
