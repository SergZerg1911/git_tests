import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
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

    @Test
    void hoverTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("[data-testid=SubNav-root-heading]").shouldHave(text("Enterprise"));
    }
}
