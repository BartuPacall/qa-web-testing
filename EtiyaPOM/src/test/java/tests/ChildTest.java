package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import java.time.Duration;


public class ChildTest {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;
    static JavascriptExecutor jsx;
    static HomePage homePage;
    static AboutPage aboutPage;
    static ProductsPage productsPage;
    static SolutionsPage solutionsPage;
    static ServicesPage servicesPage;
    static BlogPage blogPage;
    static NewsMediaPage newsMediaPage;
    static CareerPage careerPage;
    static ContactUsPage contactPage;
    int millis = 1500;


    @BeforeClass
    public static void setUp() {
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(6));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver.get("https://www.etiya.com/tr");
        homePage = new HomePage(cdriver);
        aboutPage = new AboutPage(cdriver);
        productsPage = new ProductsPage(cdriver);
        solutionsPage = new SolutionsPage(cdriver);
        servicesPage = new ServicesPage(cdriver);
        blogPage = new BlogPage(cdriver);
        newsMediaPage = new NewsMediaPage(cdriver);
        careerPage = new CareerPage(cdriver);
        contactPage = new ContactUsPage(cdriver);
        homePage.acceptCookies();
    }

    @BeforeMethod
    public void beforeAllTests() throws InterruptedException {
        cdriver.get("https://www.etiya.com/tr");
        homePage.clickMenuTitle();
        Thread.sleep(millis);
    }

    @AfterClass
    public static void tearDown() {
        cdriver.quit();
    }

    @Test
    public void testAbout() throws InterruptedException {
        homePage.clickAboutLink();
        Thread.sleep(millis);
        Assert.assertEquals(aboutPage.getAboutHeaderText(), "Hakkımızda");
    }

    @Test
    public void testProducts() throws InterruptedException {
        homePage.clickProductsLink();
        Thread.sleep(millis);
        Assert.assertEquals(productsPage.getProductsHeaderText(), "Etiya Ürünler");
    }

    @Test
    public void testSolutions() throws InterruptedException {
        homePage.clickSolutionsLink();
        Thread.sleep(millis);
        Assert.assertEquals(solutionsPage.getSolutionsHeaderText(), "Etiya Çözümler");
    }

    @Test
    public void testServices() throws InterruptedException {
        homePage.clickServicesLink();
        Thread.sleep(millis);
        Assert.assertEquals(servicesPage.getServicesHeaderText(), "Etiya SERVİSLER");
    }

    @Test
    public void testBlog() throws InterruptedException {
        homePage.clickBlogLink();
        Thread.sleep(millis);
        Assert.assertEquals(blogPage.getBlogHeaderText(), "Blog");
    }

    @Test
    public void testNewsMediaLink() throws InterruptedException {
        homePage.clickNewsMediaLink();
        Thread.sleep(millis);
        Assert.assertEquals(newsMediaPage.getNewsMediaHeaderText(), "Haber");
    }

    @Test
    public void testCareer() throws InterruptedException {
        homePage.clickCareerLink();
        Thread.sleep(millis);
        Assert.assertEquals(careerPage.getCareerHeaderText(), "EXCEED IN YOUR CAREER\n" + "EVERYDAY WITH US");
        jsx.executeScript("window.scrollBy(20,800)");
        Thread.sleep(millis);
        careerPage.fillCareerForm("example@hotmail.com");
        careerPage.clickBoxes();
        Thread.sleep(1000);
        careerPage.send();
        Assert.assertEquals(careerPage.getSuccessMessage(), "Mesajınızı başarıyla aldık.");

    }

    @Test
    public void testContactUs() throws InterruptedException {
        homePage.clickContactLink();
        Assert.assertEquals(contactPage.getContactUsHeaderText(), "Bize Ulaşın");
        Thread.sleep(millis);
        contactPage.fillContactForm("Random", "example@hotmail.com", "0 212 483 71 01", "Etiya", "Otomasyon denemesi :)");
        Thread.sleep(millis);
        contactPage.clickPolicyBox();
        Thread.sleep(millis);
        contactPage.clickSendButton();
        Assert.assertEquals(contactPage.getContactSuccessMessage(), "Mesajınız bize ulaşmıştır. En kısa süre içerisinde iletişime geçeceğiz. İlginiz için teşekkürler!");
        Thread.sleep(millis);
        contactPage.clickOkButton();
    }
}
