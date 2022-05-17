package test;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.EmployeeSearchPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class AddEmployeeTest extends CommonMethods {

    //read the configuration file for username and password
    //and add an employee

    @Test
    public void addEmployee(){

//        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
//        sendText(login.usernameBox, ConfigReader.getPropertyValue("password"));
//        click(login.loginBtn);

        login.LoginMethod(ConfigReader.getPropertyValue("username"),
                ConfigReader.getPropertyValue("password"));

        click(dash.pimOption);
        click(dash.addEmployeeButton);

        sendText(addEmployeePage.firstNameField, "bay");
        sendText(addEmployeePage.middleNameField, ".");
        sendText(addEmployeePage.lastNameField, "smokin");
       // click(addEmployeePage.saveButton); (if use here, code not gonna work..)

     //get the employee id

        String empID= addEmployeePage.empIDLocator.getAttribute("value");
        System.out.println(empID);
        click(addEmployeePage.saveButton);

        click(dash.pimOption);
        click(dash.employeeListOption);

       sendText(employeeSearchPage.idField,empID);
        click(employeeSearchPage.searchButton);

        List<WebElement> rowData = employeeSearchPage.rowData;
        for(WebElement data:rowData){
            String actualID = data.getText();
            Assert.assertEquals(empID,actualID);
        }

    }
}
