package stepdefinitions;

import data.SelectMenuData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SelectMenuPage;

public class SelectMenuStepDefs {

    SelectMenuPage selectMenuPage = new SelectMenuPage();
    SelectMenuData selectMenuData = new SelectMenuData();

    @Given("User go to {string}")
    public void userGoTo(String websiteUrl) {
        selectMenuPage.goToWebsite(websiteUrl);
    }

    @When("User in {string} page")
    public void userInPage(String pageName) {
        Assert.assertEquals("User is on the wrong page", selectMenuPage.isUserOnSelectMenuPage(), pageName);
    }

    @When("User choose select value {string}")
    public void userChooseSelectValue(String groupName) {
        selectMenuData.setGroupName(groupName);
        selectMenuPage.chooseGroupName(groupName);
    }

    @When("User choose select one {string}")
    public void userChooseSelectOne(String title) {
        selectMenuData.setTitle(title);
        selectMenuPage.chooseTitle(title);
    }

    @When("User choose old style select menu {string}")
    public void userChooseOldStyleSelectMenu(String style) {
        selectMenuData.setStyle(style);
        selectMenuPage.chooseStyle(style);
    }

    @When("User choose multi select drop down {string}")
    public void userChooseMultiSelectDropDown(String color) {
        selectMenuData.setColor(color);
        selectMenuPage.chooseColor(color);
    }

    @Then("User success input all select menu")
    public void userSuccessInputAllSelectMenu() {
        Assert.assertEquals("Value is incorrect", selectMenuPage.getGroupValue(), selectMenuData.getGroupName());
        Assert.assertEquals("One option is incorrect", selectMenuPage.getTitleValue(), selectMenuData.getTitle());
        Assert.assertEquals("Old option is incorrect", selectMenuPage.getStyle(), "10");
        Assert.assertEquals("Color option is incorrect", selectMenuPage.getColor(), selectMenuData.getColor());
        selectMenuPage.closeBrowser();
    }
}
