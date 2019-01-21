package ru.stqa.pft.docplus.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.docplus.appmanager.AppManager;


public class BasePage {

  public  AppManager app;

  @BeforeMethod
  public void SetUp() {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  public AppManager getApp() {
    return app;
  }
}
