package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;
    HelperUser helperUser;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();// full resolution
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// timer 5 second
        wd.navigate().to("https://telranedu.web.app/");
        helperUser = new HelperUser(wd); //new init
    }

    public void stop(){
        //wd.close();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
