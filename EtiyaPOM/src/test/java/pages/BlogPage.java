package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage{
    private final By blogHeader = By.xpath("(//span[contains(text(),'Blog')])[2]");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public String getBlogHeaderText() {
        return getElementText(blogHeader);
    }
}