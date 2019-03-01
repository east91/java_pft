package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.ContactData;
import com.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
   // click(By.name("selected[]"));
  }

  public void initContactModification(int index) throws InterruptedException {
    wd.findElements(By.xpath("//img[@title='Edit'][@alt='Edit']")).get(index).click();
    //click(By.xpath("//img[@title='Edit'][@alt='Edit']"));
    //click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));  This is auto-generated locator
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0,350)", "");
    Thread.sleep(1000);
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


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList();
    List<WebElement> elements = wd.findElements(By.xpath("//input[@type='checkbox'][@name='selected[]']"));  //By.xpath("//img[@title='Edit'][@alt='Edit']")
    for (WebElement element : elements) {
    String name = element.getText();
    //int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
    ContactData contact = new ContactData(name, null, null, null, null, null);
    contacts.add(contact);
  }
    return contacts;
}
}
