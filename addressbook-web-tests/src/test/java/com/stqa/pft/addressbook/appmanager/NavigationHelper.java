package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
              return;
    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.name("maintable"))) {
      return;
    }
    //click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
    click(By.linkText("home"));
  }

  public void initContactCreation() {
    if (isElementPresent(By.name("maintable"))) {
      return;
    }
    click(By.linkText("add new"));
  }
}
