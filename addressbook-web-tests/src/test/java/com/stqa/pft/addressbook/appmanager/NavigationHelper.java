package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
  }

  public void gotoContactPage() {
    click(By.linkText("add new"));
  }
}
