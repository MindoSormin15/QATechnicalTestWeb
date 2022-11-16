package locator;

import org.openqa.selenium.By;

public interface SelectMenuLocator {
    By LABEL_MAIN_HEADER = By.xpath("//div[contains(@class, 'main-header')]");
    By SELECT_VALUE_DROPDOWN = By.xpath("//div[contains(text(), 'Select Option')]");
    By OPTION_LIST = By.xpath("//div[contains(@class, ' css-1hwfws3')]");
    By OPTION_DROPDOWN_TITLE = By.xpath("//div[contains(text(), 'Select Title')]");
    By OPTION_DROPDOWN_STYLE = By.xpath("//select[@id='oldSelectMenu']");
    By OPTION_DROPDOWN_COLOR = By.xpath("//div[contains(text(), 'Select...')]");
    String SELECT_STYLE_OPTION = "//option[contains(text(), '%s')]";
    String SELECT_OPTION_VALUE = "//div[contains(text(), '%s')]";

}
