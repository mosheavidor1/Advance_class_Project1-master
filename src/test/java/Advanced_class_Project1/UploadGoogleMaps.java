package Advanced_class_Project1;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class  UploadGoogleMaps {

    private static WebDriver driver;


    public static void API_Locations(WebDriver driver) throws IOException, ParserConfigurationException, SAXException {


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()

.url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+tel.aviv&key=AIzaSyCvAHp_krsONsNZ3bEphkqXxuy_IKMJZ8g").build();




        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();

        JSONObject mainJsonObject = new JSONObject(jsonData);

        JSONArray resultsJson = mainJsonObject.getJSONArray("results");
        JSONObject mainJson = resultsJson.getJSONObject(0);

        JSONObject geometry = mainJson.getJSONObject("geometry");
        JSONObject location = geometry.getJSONObject("location");

        System.out.println(location.get("lat").toString() + " " + location.get("lng").toString());


       // driver.get("https://www.google.com/maps");
        driver.navigate().to(uploadxml.getData("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("searchboxinput")).sendKeys(location.get("lat").toString() + " " + location.get("lng").toString());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("searchbox-searchbutton")).click();

    }
}
