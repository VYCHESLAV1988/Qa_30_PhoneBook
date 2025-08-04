package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SingOut present ===> logout
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        //    svngdv@gmail.com   A123456789a@      -login and password
        app.getHelperUser().openLoginRegistrationForm(); //method Helperbase
        app.getHelperUser().fillLoginRegistrationForm("", "");
        app.getHelperUser().submitLogin();

        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    public void loginSuccessModel() {
        //    svngdv@gmail.com   A123456789a@      -login and password
        app.getHelperUser().openLoginRegistrationForm(); //method Helperbase
        app.getHelperUser().fillLoginRegistrationForm("", "");
        app.getHelperUser().submitLogin();
    }


}