package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test1"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("edited test1", "edited test2", "edited test3", "edited test4", "edited test5", null), false);
    app.getContactHelper().submitUpdateContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
