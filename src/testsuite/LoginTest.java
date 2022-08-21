package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String BaseUrl = "https://courses.ultimateqa.com/";




    @Before
    public void setUp(){
        openBrowser(BaseUrl);
    }

    @Test
    public void VuserShouldNavigateToLoginPageSuccessfully(){

        //* click on the ‘Sign In’ link
        WebElement ClickOnLink = driver.findElement(By.linkText("Sign In"));
        ClickOnLink.click();

        //* Verify the text ‘Welcome Back!’
        WebElement VerifyText = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualText = VerifyText.getText();
        String expectedTest = "Welcome Back!";
        Assert.assertEquals(expectedTest,actualText);

    }
    @Test
    public void verifyTheErrorMessage(){

        //* click on the ‘Sign In’ link
        WebElement ClickOnLink = driver.findElement(By.linkText("Sign In"));
        ClickOnLink.click();

        //* Enter invalid username
        WebElement username = driver.findElement(By.xpath("//input[@id='user[email]']"));
        username.sendKeys("abcd@gmail.com");

        //* Enter invalid password
        WebElement password = driver.findElement(By.xpath("//input[@id='user[password]']"));
        password.sendKeys("1234hsp");

        //* Click on Login button
        WebElement Login = driver.findElement(By.xpath("//input[@value='Sign in']"));
        Login.click();

        //* Verify the error message ‘Invalid email or password.’
        WebElement VerifyText = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualText = VerifyText.getText();
        String expectedTest = "Invalid email or password.";
        Assert.assertEquals(expectedTest,actualText);
    }
    @After
    public void closebrowser(){
      //  driver.quit();
    }

}
