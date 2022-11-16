package locator;

import org.openqa.selenium.By;

public interface SearchBookLocator {
    By SEARCH_BAR = By.xpath("//input[contains(@class, 'form-control')]");
    By LABEL_NO_ROWS_FOUND = By.xpath("//div[contains(@class, 'rt-noData')]");
    String LABEL_BOOK_TITLE = "//a[contains(text(),'%s')]";
    By BOOK_ROW_LIST = By.xpath("//div[contains(@class, 'rt-tr-group')]");
    By BOOKS_TITLE_LIST = By.xpath("//div[2][contains(@class, 'rt-td')]/div/span/a");
    By BOOKS_AUTHOR = By.xpath("//div[3][contains(@class, 'rt-td')]");
    By BOOKS_PUBLISHER = By.xpath("//div[4][contains(@class, 'rt-td')]");
    By BOOK_DETAIL = By.xpath("//div[@id='title-wrapper']/div[2]/label");
    By BOOK_AUTHOR_DETAIL = By.xpath("//div[@id='author-wrapper']/div[2]/label");
    By BOOK_PUBLISHER_DETAIL = By.xpath("//div[@id='publisher-wrapper']/div[2]/label");
}
