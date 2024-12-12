import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappTests {

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/");
        $(byText("Drag and Drop")).click();
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").$("header").shouldHave(text("B"));
        actions().clickAndHold($("#column-b")).moveToElement($("#column-a")).release().perform();
        $("#column-a").$("header").shouldHave(text("A"));
    }
}
