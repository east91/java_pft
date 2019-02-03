package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.ContactData;
import com.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;
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

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
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
    wd.findElement(By.name("submit")).click();
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
