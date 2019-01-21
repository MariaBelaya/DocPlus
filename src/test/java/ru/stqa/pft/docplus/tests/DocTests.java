package ru.stqa.pft.docplus.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.stqa.pft.docplus.appmanager.TestBase;

import java.util.List;

public class DocTests extends TestBase {

  String yandexSearchField = ".input_theme_websearch .input__control";


  @Test
  public void testSearch() {
    List<String> listOfLinks;

    app.openYandexPage();
    app.writeInSearch(yandexSearchField,"docplus");
    app.clickEnterForSearch(yandexSearchField);

    listOfLinks = app.getListOfLinks();

    app.docplusSiteNameShouldBeDisplayed(listOfLinks);
  }

}

