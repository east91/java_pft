package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.ContactData;
import com.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends GroupHelper {
  //*run chrome* ChromeDriver wd;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
    //*run chrome*  System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
    wd = new FirefoxDriver();
    //* run chrome* wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
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

  public void selectContact() {
    selectGroup();
  }

  public void editContact() {
    wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img")).click();
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0,350)", "");
  }

  public void deleteSelectedContacts() {
    wd.findElement(By.xpath("//*[@id=\"content\"]/form[2]/input[2]")).click();
  }

  public void gotoHomePage() {
    wd.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
  }

  public void submitContactCreation() {
    submitGroupCreation();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
