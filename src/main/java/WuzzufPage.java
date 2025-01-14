import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WuzzufPage extends BasePage{
    public WuzzufPage(WebDriver driver) {
        super(driver);
    }

    // Locators

    By searchBarLocator = By.cssSelector("input[class=\"css-ukkbbr e1n2h7jb1\"]");
    By searchBarBtnLocator =By.cssSelector("button[type=\"submit\"]");
    By dataPostedLocator = By.cssSelector("h3[class=\"css-1d5tds3\"]");
    By pastWeekLocator = By.cssSelector("span[class=\"css-35ezg3\"]");
    By numberOfJobsFoundLocator = By.cssSelector("span[class=\"css-xkh9ud\"] strong");
    By firstJobFoundLocator= By.cssSelector("div[class=\"css-9i2afk\"] div[class=\"css-1gatmva e1v1l3u10\"]:nth-child(1) div[class=\"css-laomuu\"] h2 a");
    By applyForJobBtnLocator = By.cssSelector("button[class=\"css-1m0yk35 ezfki8j0\"]");
    By signUpWithGoogleBtnLocator = By.cssSelector("button[class=\"ee8rty01 css-we3y1y ezfki8j0\"]");
    By signUpBtnLocator = By.cssSelector("button[class=\"css-6lejne ezfki8j0\"]");


    //Methods

    public void searchJobs(String text) throws InterruptedException {
        write(searchBarLocator,text);
        myClick(searchBarBtnLocator);
    }
    public void goToDataPosted() throws InterruptedException {
        myClick(dataPostedLocator);
    }
    public void goToPastWeek() throws InterruptedException {
        myClick(pastWeekLocator);
    }
    public String getNumOfJobsFound(){
        return returnText(numberOfJobsFoundLocator);
    }
    public void goToFirstJobFound() throws InterruptedException {
        myClick(firstJobFoundLocator);
    }
    public void submitJob() throws InterruptedException {
        myClick(applyForJobBtnLocator);
    }
    public void signUpWithGoogle() throws InterruptedException {
        myClick(signUpWithGoogleBtnLocator);
    }
    public void sighUpBtn() throws InterruptedException {
        myClick(signUpBtnLocator);
    }





}
