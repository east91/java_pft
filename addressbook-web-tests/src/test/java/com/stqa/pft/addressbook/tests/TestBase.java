package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }


  @AfterMethod
  public void tearDown() {
    app.stop(); }


  /*
  public static boolean isAlertPresent(FirefoxDriver) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentExeption e) {
      return false;
    }
  }*/
}
