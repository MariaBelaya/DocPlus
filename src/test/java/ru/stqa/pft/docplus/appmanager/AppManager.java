package ru.stqa.pft.docplus.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppManager {
  public WebDriver wd;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://www.yandex.ru");
  }

  public void stop() {
    wd.close();
  }

  public void clickEnter(WebElement element) {
    element.sendKeys(Keys.RETURN);
  }

  public void clickEnterForSearch(String locator) {
    clickEnter(wd.findElement(By.cssSelector(locator)));
  }

  public void openYandexPage() {
    wd.get("https://www.yandex.ru");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public void writeInSearch(String locator, String text) {
    wd.findElement(By.cssSelector(locator)).sendKeys(text);
  }

  public void docplusSiteNameShouldBeDisplayed(List<String> listOfLinks) {
    Assert.assertTrue(listOfLinks.contains("docplus.ru"));
  }

  public List<String> getListOfLinks() {
    List<String> listOfLinks = new ArrayList<>();

    List<WebElement> elements = wd.findElements(By.cssSelector(".serp-item .organic"));

    for (WebElement element : elements) {

      listOfLinks.add(element.findElement(By.cssSelector(".organic__path")).getText());
    }
    return listOfLinks;
  }
}
