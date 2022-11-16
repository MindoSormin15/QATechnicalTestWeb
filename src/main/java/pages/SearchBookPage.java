package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static locator.SearchBookLocator.*;


public class SearchBookPage {

    WebDriver driver;

    public void searchBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BAR));
        WebElement element = driver.findElement(SEARCH_BAR);
        element.click();
        element.sendKeys(bookName);
    }

    public String noBooksFounds() {
        return driver.findElement(LABEL_NO_ROWS_FOUND).getText();
    }

    public void clickBook(String bookNames) {
        By book = By.xpath(String.format(LABEL_BOOK_TITLE, bookNames));
        driver.findElement(book).click();
    }

    public String getTitle() {
        String title = "";
        try {
            title = driver.findElements(BOOK_ROW_LIST).get(0).findElement(BOOKS_TITLE_LIST).getText();
        } catch (Exception e) {
            System.out.println(e);
        }
        return title;
    }

    public String getAuthor() {
        String author = "";
        try {
            author = driver.findElements(BOOK_ROW_LIST).get(0).findElement(BOOKS_AUTHOR).getText();
        } catch (Exception e) {
            System.out.println(e);
        }
        return author;
    }

    public String getPublisher() {
        String publisher = "";
        try {
            publisher = driver.findElements(BOOK_ROW_LIST).get(0).findElement(BOOKS_PUBLISHER).getText();
        } catch (Exception e) {
            System.out.println(e);
        }
        return publisher;
    }

    public String getTitleDetail() {
        return driver.findElement(BOOK_DETAIL).getText();
    }

    public String getAuthorDetail() {
        return driver.findElement(BOOK_AUTHOR_DETAIL).getText();
    }

    public String getPublisherDetail() {
        return driver.findElement(BOOK_PUBLISHER_DETAIL).getText();
    }

    public void closeBrowser() {
        driver.close();
    }
}
