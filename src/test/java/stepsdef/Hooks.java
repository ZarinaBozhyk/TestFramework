package stepsdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * #Summary:
 * #Author: Zarina Bozhyk
 * #Author’s Email:
 * #Creation Date: 3/22/2020
 * #Comments:
 */
public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Zarina_Bozhyk/IdeaProjects/TestFramework/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
