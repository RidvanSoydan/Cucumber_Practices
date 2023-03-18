package com.cydeo.step_definitions;

import com.cydeo.pages.CtisPage;
import com.cydeo.pages.CtisPortalPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CtisStepDefinition {
    CtisPage ctisPage = new CtisPage();
    CtisPortalPage ctisPortalPage = new CtisPortalPage();

    @When("user is on ctissolutions search page")
    public void user_is_on_ctissolutions_search_page() {
        Driver.getDriver().get("https://qa.ctissolutions.com/");
    }

    @When("user types helpdesk1@cybertekschool.com")
    public void user_types_helpdesk1_cybertekschool_com() {
        ctisPage.userNameBox.sendKeys("helpdesk1@cybertekschool.com");
    }

    @And("user types UserUser")
    public void userTypesUserUser() {
        ctisPage.userPassBox.sendKeys("UserUser");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        ctisPage.loginButton.click();
    }

    @Then("user should see title is Portal")
    public void userShouldSeeTitleIsPortal() {
        String expectedTitle = "Portal";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("user close the driver")
    public void userCloseTheDriver() {
        Driver.closeDriver();
    }

    @And("user types {string} as password")
    public void userTypesAsPassword(String arg0) {
        ctisPage.userPassBox.sendKeys(arg0);
    }

    @When("user types hr1@cybertekschool.com")
    public void user_types_hr1_cybertekschool_com() {
        ctisPage.userPassBox.sendKeys("hr1@cybertekschool.com");
    }

    @And("user types {string} as username")
    public void userTypes(String arg0) {
        ctisPage.userNameBox.sendKeys(arg0);
    }

    @And("user types username and password")
    public void userTypesUsernameAndPassword(List<String> list) {
        ctisPage.userNameBox.sendKeys(list.get(0));
        ctisPage.userPassBox.sendKeys(list.get(1));
    }


    @And("user get data from excel and verify login")
    public void userGetDataFromExcelAndVerifyLogin() throws IOException {
        String path = "CTIS.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("ctis");

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            String userName = sheet.getRow(i).getCell(0).toString();
            String userPass = sheet.getRow(i).getCell(1).toString();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ctisPage.login(userName, userPass);
            ctisPortalPage.logOut();
            ctisPage.userNameBox.clear();
        }
    }

}










