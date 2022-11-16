package pages;

import data.SelectMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static locator.SelectMenuLocator.*;


public class SelectMenuPage {
    WebDriver driver;

    SelectMenuData selectMenuData = new SelectMenuData();

    public void goToWebsite(String webURL) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(webURL);
    }

    public String isUserOnSelectMenuPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LABEL_MAIN_HEADER));
        return driver.findElement(LABEL_MAIN_HEADER).getText().trim();
    }

    public void chooseGroupName(String groupName) {
        driver.findElement(SELECT_VALUE_DROPDOWN).click();
        By chooseGroupName = By.xpath(String.format(SELECT_OPTION_VALUE, groupName));
        driver.findElement(chooseGroupName).click();
    }

    public void chooseTitle(String title) {
        scrollDown();
        driver.findElement(OPTION_DROPDOWN_TITLE).click();
        By chooseTitle = By.xpath(String.format(SELECT_OPTION_VALUE, title));
        driver.findElement(chooseTitle).click();
    }

    public void chooseStyle(String style) {
        WebElement element = driver.findElement(OPTION_DROPDOWN_STYLE);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        By chooseStyle = By.xpath(String.format(SELECT_STYLE_OPTION, style));
        driver.findElement(chooseStyle).click();
    }

    public void chooseColor(String color) {
        WebElement element = driver.findElement(OPTION_DROPDOWN_COLOR);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        if (color.equals("all color")) {
            By chooseGreen = By.xpath(String.format(SELECT_OPTION_VALUE, "Green"));
            driver.findElement(chooseGreen).click();
            By chooseBlue = By.xpath(String.format(SELECT_OPTION_VALUE, "Blue"));
            driver.findElement(chooseBlue).click();
            By chooseBlack = By.xpath(String.format(SELECT_OPTION_VALUE, "Black"));
            driver.findElement(chooseBlack).click();
            By chooseRed = By.xpath(String.format(SELECT_OPTION_VALUE, "Red"));
            driver.findElement(chooseRed).click();
        } else {
            By chooseColor = By.xpath(String.format(SELECT_OPTION_VALUE, color));
            driver.findElement(chooseColor).click();
        }

    }

    public String getGroupValue() {
        return driver.findElements(OPTION_LIST).get(0).getText();
    }

    public String getTitleValue() {
        return driver.findElements(OPTION_LIST).get(1).getText();
    }

    public String getStyle() {
        return driver.findElement(OPTION_DROPDOWN_STYLE).getAttribute("value");
    }

    public String getColor() {
        String colorValue = selectMenuData.getColor();
        String color = driver.findElements(OPTION_LIST).get(2).getText();
        if (color.contains("Green") && color.contains("Blue") && color.contains("Black") && color.contains("Red")) {
            colorValue = "all color";
        }
        return colorValue;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public void closeBrowser() {
        driver.close();

    }
}


