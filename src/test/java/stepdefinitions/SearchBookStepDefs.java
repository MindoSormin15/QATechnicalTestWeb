package stepdefinitions;

import data.BooksData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchBookPage;

public class SearchBookStepDefs {

    BooksData booksData = new BooksData();
    SearchBookPage searchBookPage = new SearchBookPage();

    @When("User search book {string}")
    public void userSearchBook(String bookName) {
        searchBookPage.searchBook(bookName);
        booksData.setTitle(searchBookPage.getTitle());
        booksData.setAuthor(searchBookPage.getAuthor());
        booksData.setPublisher(searchBookPage.getPublisher());
    }

    @When("User see {string}")
    public void userSee(String noBooksFound) {
        Assert.assertEquals("Book label is not the same", searchBookPage.noBooksFounds(), noBooksFound);
        searchBookPage.closeBrowser();
    }

    @When("User click book {string}")
    public void userClickBook(String bookName) {
        searchBookPage.clickBook(bookName);
    }

    @Then("User see {string} details")
    public void userSeeDetails(String bookTitle) {
        Assert.assertEquals("Title is incorrect", searchBookPage.getTitleDetail(), bookTitle);
        Assert.assertEquals("Title is not the same", searchBookPage.getTitleDetail(), booksData.getTitle());
        Assert.assertEquals("Author is not the same", searchBookPage.getAuthorDetail(), booksData.getAuthor());
        Assert.assertEquals("Publisher is not the same", searchBookPage.getPublisherDetail(), booksData.getPublisher());
        searchBookPage.closeBrowser();
    }
}
