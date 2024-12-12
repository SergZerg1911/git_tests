import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappTests {

    @Test
    void dragAndDropTest() {
        //Открываем тренировочный сайт
        open("https://the-internet.herokuapp.com/");
        //Ищем и кликаем по ссылке Drag and Drop
        $(byText("Drag and Drop")).click();
        //Перетаскиваем элемент A на место элемента B
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        //Проверяем что у элемента, на который перетащили первый элемент появился header A
        $("#column-a").$("header").shouldHave(text("B"));
        //Перетаскиваем элемент обратно
        actions().clickAndHold($("#column-b")).moveToElement($("#column-a")).release().perform();
        //Проверяем что у элемента A header A, а у элемента B header B
        $("#column-a").$("header").shouldHave(text("A"));
    }
}
