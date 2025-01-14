import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
        protected WebDriver driver;
        protected WebDriverWait wait;

        public BasePage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        public void myClick(By locator) throws InterruptedException {
            WebElement element = driver.findElement(locator);
            element.click();
            Thread.sleep(2000);

        }

        public void write(By locator, String text){
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        }

        public String returnText(By locator){
            return driver.findElement(locator).getText();
        }
    }

