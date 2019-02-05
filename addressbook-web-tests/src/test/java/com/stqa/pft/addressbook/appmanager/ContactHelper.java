package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void editContact() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0,350)", "");
  }

  public void deleteSelectedContactsFromHomePage() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
  }

  public void submitContactCreation() {
    //submitContactCreation();
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void submitUpdateContactCreation() {
    click(By.name("update"));
  }

  public void closeAlertPopUP() {
    wd.switchTo().alert().accept();
  }
}
