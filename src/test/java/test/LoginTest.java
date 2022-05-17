package test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class LoginTest extends CommonMethods {

    @Test
    public void logoIsPresent(){
    // assert that logo is present on the loginPage

        boolean isDisplay =login.logo.isDisplayed();
        Assert.assertTrue(isDisplay);
    }

 @DataProvider(name = "Credentials")
 public Object [][] data(){

     Object[][] loginData={
             {"Admin","abc","Invalid credentialsaa"},
             {"Admin","xyz","Invalid credentials"},
             {"Admin","","Password cannot be empty"},
             {"","hum","Username cannot be empty"}
     };
     return  loginData;
 }



    @Test(dataProvider = "Credentials")
    public void invalidCredentials(String userName , String password , String errorMsg){

        login.usernameBox.sendKeys(userName);
        login.passwordBox.sendKeys(password);
        //sendText(login.usernameBox,userName);
        //sendText(login.passwordBox,password);
        login.loginBtn.click();
        String Msg = login.errorMessage.getText();

        Assert.assertEquals(Msg,errorMsg);
    }
}
