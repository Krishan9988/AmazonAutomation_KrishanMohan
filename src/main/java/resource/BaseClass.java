package resource;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public WebDriver driver;
	public String url;
	public String url1;
	public String imageurl;
	public String username;
	public String wrongname;
	public JSONObject jsonObject;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver intializingDriver() throws ParseException 
	{
	WebDriverManager.chromedriver().setup();
		JSONParser jsonParser=new JSONParser();
		try (Reader reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\base.json")) {

		//	String JSON = "{\"google\":\"chrome\", \"firefox\":\"gecko\",\"url\":\"https://www.amazon.in/\",\"url1\":\"https://www.amazon.com/,\"imageurl\":\"https://imgbb.com/\"}";
		//	ObjectMapper objectMapper = new ObjectMapper();
			//ProjectProperties pp = new ProjectProperties();
		//	pp = objectMapper.readValue(JSON,ProjectProperties.class);
		jsonObject = new JSONObject();
			jsonObject = (JSONObject) jsonParser.parse(reader);
			
            System.out.println(jsonObject);

           String google = (String) jsonObject.get("google");
           // System.out.println(google);
            String gecko = (String) jsonObject.get("gecko");
           // System.out.println(gecko);
             url = (String) jsonObject.get("url");
             url1 = (String) jsonObject.get("url1");
             imageurl=(String) jsonObject.get("imageurl");
             username = (String) jsonObject.get("username");
             wrongname = (String) jsonObject.get("wrongname");
            // String google =   System.getProperty(google);
          //   String gecko =   System.getProperty(gecko);
            if(google.contains("chrome"))
            {
            	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
            	driver = new ChromeDriver();
            }
            else if(gecko.contains("firefox"))
            {
            	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\geckodriver.exe");
        		driver = new FirefoxDriver();	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tdriver.set(driver);
		return getDriver();
    }
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();	
	}
	public void getIntializingDriver()
	{
			try {
			driver=	intializingDriver();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public void getURL()
	{
		driver.get(url);
	}
	
	
	public void tearDown() {
		driver.quit();
	}
	
	}


