package ru.stqa.pft.docplus.appmanager;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

  protected static final AppManager app = new AppManager();

  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }
}
