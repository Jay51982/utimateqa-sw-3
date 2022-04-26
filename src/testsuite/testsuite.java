package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class testsuite extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on Login link

        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));

        //Verify the text ‘Welcome Back!

        String secureArea = getTextFromElement(By.className("page__heading"));

        Assert.assertEquals("Incorrect Login detail", "Welcome Back!", secureArea);
    }
    @Test
    // verifyTheErrorMessage
    public void  verifyTheErrorMessage(){
        //click on the ‘Sign In’ link

        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));

        // Enter invalid username
        //to find email field and insert invalid email id

        getTextFromElement(By.id("user[email]"));
        sendTextToElement(By.id("user[email]"),"user[email]");

        //find the password field element and insert invalid password

        getTextFromElement(By.id("user[password]"));
        sendTextToElement(By.id("user[password]"), "abcxyz123");

        // Click on submit button

        clickOnElement(By.xpath("//input[@value='Sign in']"));

        //Verify the error message ‘Invalid email or password.'

        String secureArea = getTextFromElement(By.className("form-error__list-item"));

        Assert.assertEquals("Incorrect Login detail", "Invalid email or password.", secureArea);
    }
}

