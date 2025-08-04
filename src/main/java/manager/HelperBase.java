package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd; //click mouse button constructor
    }

    public void type(By locator, String text) {

    }

    public void click(By locator){

    }

    public void submitLogin() {
    }

    poblic boolean isElementPresent(By locator){
        List<WebElement>list = wd.findElements(locator);
        return  list.size()>0;
    }
}
