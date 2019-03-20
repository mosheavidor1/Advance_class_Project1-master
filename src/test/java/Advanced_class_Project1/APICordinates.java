
package Advanced_class_Project1;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APICordinates {

    private static WebDriver driver;

    @BeforeClass
    public static void bc() throws MalformedURLException {

        uploadxml.uploadAllBrowsers(driver);
       uploadxml.uploadChromeDriver(driver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void Test01_run () throws IOException, ParserConfigurationException, SAXException {

    UploadGoogleMaps. API_Locations(driver);
       

    }




    }
















