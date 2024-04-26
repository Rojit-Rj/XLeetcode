package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import javax.lang.model.util.ElementScanner6;
import javax.xml.xpath.XPath;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String sitename = "leetcode";
        if(driver.getCurrentUrl().contains(sitename))
        System.out.println("The URL of the Leetcode homepage contains "+ "leetcode");
        else
        System.out.println("The URL of the Leetcode homepage Does NOT contains" +"leetcode");
    }

    public  void testCase02()throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        WebElement questionsButton = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questionsButton.click();
        Thread.sleep(30000);
        if(driver.getCurrentUrl().contains("problemset"))
        System.out.println("The URL of the problemset page contains "+ "problemset");
        else
        System.out.println("The URL of the problemset page DOES NOT contains "+ "problemset");

        List <WebElement> questionsList= driver.findElements(By.xpath("//div[@class='max-w-[302px] flex items-center overflow-hidden']"));
        for (WebElement webElement : questionsList) {
            if(webElement.getText().contains("Zigzag Conversion"))
            break;
            System.out.println(webElement.getText());
        }
        
    }

    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        WebElement problem1 = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        problem1.click();
        if(driver.getCurrentUrl().contains("two-sum"))
        System.out.println("The URL of the problem contains two-sum");
        else
        System.out.println("The URL of the problem does NOT contains two-sum");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        WebElement submissionstab = driver.findElement(By.id("submissions_tab"));
        submissionstab.click();
        WebElement button = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String buttontext = "Register or Sign In";
        if(button.getText().equalsIgnoreCase(buttontext))
        System.out.println("The message \"Register or Sign In\" is displayed when you click on the submissions tab.");
        else
        System.out.println("The message 'Register or Sign In'+ is NOT displayed when you click on the submissions tab.");
    }

}