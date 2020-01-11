
package com.cms.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.cms.qa.pages.HomePage;
import com.cms.qa.util.TestUtil;
import com.cms.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static EventFiringWebDriver e_driver;
	static WebEventListener eventListener;
	//public static Logger log;

	public TestBase() {
		try {
			prop = new Properties();
			/*
			 * String path =
			 * 
			 * "/src/main/java/com/cms/qa/config/config.properties"; String str
			 * = System.getProperty("user.dir"+path);
			 */
			FileInputStream fip = new FileInputStream(
					"E:\\workspace2\\FirstJBKTest\\src\\main\\java1\\com\\cms\\qa\\config\\config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*log = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("E:\\workspace2\\FirstJBKTest\\src\\main\\resources\\log4j.properties");
*/
	}

	public static HomePage intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\workspace2\\FirstJBKTest\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of event listenerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return null;

	}
}
