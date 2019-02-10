package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0,350)", "");
  }

  public void deleteSelectedContactsFromHomePage() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitUpdateContactModification() {
    click(By.name("update"));
  }

  public void closeAlertPopUP() {
    wd.switchTo().alert().accept();
  }

  public void gotoHomePage() {
    if (isElementPresent(By.name("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm((contact), true);
    submitContactCreation();
    gotoHomePage();
  }

  public void initContactCreation() {
    if (isElementPresent(By.name("maintable"))) {
      return;
    }
    click(By.linkText("add new"));
  }


}
