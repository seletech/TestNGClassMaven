package user_services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalUsage {

    @Test(dataProvider = "urlData")
    public void AmazonURlOpening(String url) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }


    @DataProvider
    public Object[][] urlData(){
        Object [][] data = new Object[2][1]; // rows columns
        data[0][0] = "https://amazon.in";
        data[1][0] =  "https://facebook.com/";
        return data;
    }
}
