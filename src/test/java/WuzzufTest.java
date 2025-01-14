import com.github.javafaker.Faker;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class WuzzufTest extends BaseTest{
    WuzzufPage obj = new WuzzufPage(driver);

    Faker fake = new Faker();
    SoftAssert soft = new SoftAssert();
    String SearchText = "Software testing";





    @Test
    public void TC_001() throws InterruptedException {
        reportTest = report.createTest("WUZZUF Test");
        obj = new WuzzufPage(driver);



        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/jobs/egypt");
        reportTest.pass("You are in home page");

        obj.searchJobs(SearchText);
        reportTest.info("You searched for Software Testing in searchbar");
        obj.goToDataPosted();
        reportTest.info("clicked on DataPosted in Filter tool");


        obj.goToPastWeek();
        reportTest.info("selected past week ");

        soft.assertEquals(obj.getNumOfJobsFound(),"79");
        reportTest.pass("the number of founded jobs = "+ obj.getNumOfJobsFound());


        obj.goToFirstJobFound();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));



        System.out.println(driver.getCurrentUrl());

        reportTest.pass("clicked on first job found on the page");
        //apply for job
        obj.submitJob();
        reportTest.pass("clicked on apply job");
        
        reportTest.info("Registration Form");
        WebElement firstname = driver.findElement(By.cssSelector("input[id=\"firstname\"]"));
        firstname.sendKeys(fake.name().firstName());

        reportTest.pass("Enter your Firstname  ");
        WebElement lastname = driver.findElement(By.cssSelector("input[id=\"lastname\"]"));
        lastname.sendKeys(fake.name().lastName());

        reportTest.pass("Enter your Lastname  ");
        WebElement email = driver.findElement(By.cssSelector("input[id=\"email\"]"));
        email.sendKeys(fake.internet().safeEmailAddress());
        reportTest.pass("Enter your Email  ");

        WebElement password = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        lastname.sendKeys(fake.internet().password());
        reportTest.pass("Enter your Firstname  ");

        obj.sighUpBtn();
        reportTest.pass("signUp btn clicked   ");

//        obj.signUpWithGoogle();
//        reportTest.pass("SignedUp with Google Account ");






    }

}
