package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SignOut present ---> logout
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finished logout");
        }
    }

    @Test
    //    svngdv@gmail.com   A123456789a@      -login and password
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data --->email: 'svngdv@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();

        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data --->email: 'svngdv@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data --->email: 'svngdvgmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdvgmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is Alert present with error text 'Wrong email or password'");

    }



    @Test
    public void loginWrongPassword(){
        logger.info("Test data --->email: 'svngdv@gmail.com' & password: '123456789a'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv@gmail.com", "123456789a"); //A123456789a@ == 123456789a
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is Alert present with error text 'Wrong email or password'");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --->email: 'svngdv1234567@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv1234567@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is Alert present with error text 'Wrong email or password'");
    }
}