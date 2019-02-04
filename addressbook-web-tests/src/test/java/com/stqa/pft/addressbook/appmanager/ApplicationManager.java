package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;

  private ContactHelper contactHelper;
  //FirefoxDriver wd;

  private GroupHelper groupHelper;
  //*run chrome* ChromeDriver wd;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
    //*run chrome*  System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
    wd = new FirefoxDriver();
    //* run chrome* wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    login("admin", "secret");
  }

  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void stop() {
    wd.quit();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHomePage() {
    wd.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
