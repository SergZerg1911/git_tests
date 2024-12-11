import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class GitHubWikiTest {

    @Test
    void assertJunitCode() {
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("[data-testid=results-list]").$("div span").shouldHave(text("selenide/")).click();
        $("[data-content=Wiki]").click();
        $("#wiki-pages-box").$(".wiki-more-pages-link").$("[type=button]").click();
        $("#wiki-pages-box").$$("li").get(20).$("span a").shouldHave(text("SoftAssertions")).click();
        $("#wiki-wrapper").$("div h1").shouldHave(text("SoftAssertions"));
        $(".markdown-body").shouldHave(text("Junit5"));
    }
}
