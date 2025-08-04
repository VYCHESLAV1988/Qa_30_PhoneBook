package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    //Created method open login registration form
    public void openLoginRegistrationForm(){
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        //xPath ==> //a[text()='LOGIN']
       // loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(){
        //WebElement emailInput = wd.findElement(By.name("email"));
       // emailInput.click();
       //emailInput.clear();
        //emailInput.sendKeys(email);
        type(By.name("email",email); //var 2

    }

    public void passwordInput(){
        //WebElement passwordInput = wd.findElement(By.name("password"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(email);
        type(By.name("password",password));
    }

    public void sabmitLogin(){
        click(By.xpath("//button[text()='/LOGIN')]");
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//buton[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//buton[text()='Sign Out']"));
    }
}
