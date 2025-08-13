package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .setEmail("xnow" + z + "@gmail.com")
                .setPassword("Xsnow123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

    }

// ========================== HW 7 NEGATIVE TEST===========================================
    @Test
    public void loginWrongEmail(){
        User user = new User()
                .setEmail("xnowgmail.com") // xnow@gmail.com
                .setPassword("Xsnow123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginEmptyEmail(){
        User user = new User()
                .setEmail("") // xnow@gmail.com
                .setPassword("Xsnow123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword(){
        User user = new User()
                .setEmail("xnow@gmail.com")
                .setPassword("snow"); //Xsnow123456$

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
    }

    @Test
    public void loginEmptyPassword(){
        User user = new User()
                .setEmail("xnow@gmail.com")
                .setPassword(""); //Xsnow123456$

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }



}