package user_services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProviderExample {
    private WebDriver driver;
    private  String baseUrl;


    @BeforeMethod
    public void setUp(){
        baseUrl= "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test(dataProvider = "userData")
    public  void loginTest(String  username,String pass){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] userData(){
        Object [][] userdata = new Object[3][2]; // rows and colums
        userdata[0][0] = "standard_user";
        userdata[0][1] = "secret_sauce";

        userdata[1][0] = "standard_user2";
        userdata[1][1] = "secret_sauce2";

        userdata[2][0] = "standard_user3";
        userdata[2][1] = "secret_sauce3";
        return userdata;
    }

}
