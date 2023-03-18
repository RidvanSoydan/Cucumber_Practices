package com.cydeo.step_definitions;

import com.cydeo.pages.TodoElements;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TodoStepDefs {
    TodoElements todoElements;

    @Given("user is on the Todo home page")
    public void user_is_on_the_todo_home_page() {
        Driver.getDriver().get("http://todomvc.com/");
        todoElements = new TodoElements();
    }
    @When("user click Javascript tab")
    public void user_click_javascript_tab() {
        todoElements.javaScript.click();


    }
    @When("user select Polymer link")
    public void user_select_polymer_link() {
       todoElements.polymer.click();
    }
    @When("user add first todo item and second item")
    public void user_add_first_todo_item_and_second_item() {
      todoElements.toDoItem.sendKeys("item1"+ Keys.ENTER+"item2" + Keys.ENTER);
    }
    @Then("user should re-edit second item")
    public void user_should_re_edit_second_item() {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(todoElements.SecondItem).perform();

        todoElements.inPut.sendKeys(Keys.chord(Keys.CONTROL+"a")+Keys.BACK_SPACE);
        todoElements.inPut.sendKeys("newitem"+Keys.ENTER);

        Driver.getDriver().close();

    }

}
