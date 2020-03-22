package stepsdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * #Summary:
 * #Author: Zarina Bozhyk
 * #Author’s Email:
 * #Creation Date: 3/21/2020
 * #Comments:
 */
public class Login {

    public WebDriver driver;
    public Login()
    {
        driver = Hooks.driver;
    }

    @Given("^User navigated to Login Page$")
    public void userNavigatesToLoginPage() {
        driver.get("https://stackoverflow.com/");
    }

    @When("^User clicks on Login button on Homepage$")
    public void userClicksOnLoginButtonOnHomepage() {
        WebElement loginButton = driver.findElement(By.xpath("//ol[contains(@class,'user-logged-out')]//li[@class='-ctas']/a[contains(text(),'Log in')]"));
        loginButton.click();
    }

    @When("^User enters the invalid Username$")
    public void userEntersTheInvalidUsername() {
        WebElement loginField = driver.findElement(By.xpath("//form[@id='login-form']//div[contains(@class,'grid')]/input[@id='email']"));
        loginField.sendKeys("zaz@gmail,com");
    }

    @When("^User enters the invalid Password$")
    public void userEntersEheInvalidPassword() {
        WebElement passwordField = driver.findElement(By.xpath("//form[@id='login-form']//div[contains(@class,'grid')]/input[@id='password']"));
        passwordField.sendKeys("12345");
    }

    @When("^User clicks on the Login button$")
    public void userClicksOnTheLoginButton() {
        WebElement loginModalButton = driver.findElement(By.xpath("//form[@id='login-form']//div[contains(@class,'grid')]/button"));
        loginModalButton.click();
    }

    @Then("^User should sees the error message with text bellow:$")
    public void userShouldSeesTheErrorMessageWithTextBellow(String expectedText) {
        WebElement errorText = driver.findElement(By.xpath("//form[@id='login-form']//div[contains(@class,'grid')]//following-sibling::div[contains(@class,'fd-column-reverse ')]//preceding-sibling::p"));
        String actualText = errorText.getText();
        Assert.assertEquals(actualText, expectedText, String.format("The actual text of error message '%s' is not equal to the expected text '%s'.",
                actualText, expectedText));
    }
}
