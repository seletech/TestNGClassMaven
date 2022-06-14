package user_services;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    //unit testing frameworks
    public  WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
    }
    @Test
    public void amazonTest(){

        driver.get("https://amazon.in");
    }

    @Test(dependsOnMethods = {"amazonTest"})
    public void devTo(){


        driver.get("https://dev.to/");
    }
    @AfterMethod
    public  void close()
    {
    driver.close();
    }
}
