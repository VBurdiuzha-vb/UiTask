import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.XmPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FirstClassTest extends WebDriver {
    private static XmPage homePage;

    @Test
    public void userCanSearch() {
        homePage = PageFactory.initElements(driver, XmPage.class);
        homePage.getPage();
//        SearchResultsPage results = page.searchFor("Selenide java");
//        assertThat(results.getResults().get(0).getText(), containsString("Selenide: concise UI tests in Java"));
    }
}
