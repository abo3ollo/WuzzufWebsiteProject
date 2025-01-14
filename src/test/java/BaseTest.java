import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {


        protected WebDriver driver;
        Faker fake;

        //Report
        protected static ExtentReports report;
        protected static ExtentTest reportTest;


        @BeforeSuite
        public void setUpReport(){
            report= new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(new File("Reports/report.html"));
            spark.config().setTheme(Theme.DARK);
            report.attachReporter(spark);

        }


            @BeforeTest
            public void setUp() {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
                driver = new ChromeDriver(options);

                fake = new Faker();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().window().maximize();
                driver.get("https://wuzzuf.net/jobs/egypt");

            }

            @AfterTest
            public void after() throws InterruptedException {
                Thread.sleep(2000);
                driver.quit();
            }

        @AfterSuite
        public void tearDown() throws IOException {
            report.flush();
            Desktop.getDesktop().open(new File("Reports/report.html"));

        }
    }

