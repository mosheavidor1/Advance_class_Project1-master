package Advanced_class_Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;



public class uploadxml {
    private static WebDriver driver;

    public static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException, org.xml.sax.SAXException {


     //   File configXmlFile = new File("C:\\Users\\moshe\\Documents\\config3.xml");
        File configXmlFile = new File(ConstStrings.XML);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    public static void uploadChromeDriver(WebDriver driver) {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\moshe\\IdeaProjects\\Selenium\\chromedriver.exe");
        System.setProperty(ConstStrings.uploadDriver, ConstStrings.uploadDriver2);

    }

    public static void uploadAllBrowsers(WebDriver driver){

        String browserType = ("BrowserType");
        if (browserType.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equals("IE")) {
            driver = new InternetExplorerDriver();

    }}}