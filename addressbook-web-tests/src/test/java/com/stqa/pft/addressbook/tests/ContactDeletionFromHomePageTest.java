package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionFromHomePageTest extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContactsFromHomePage();
    app.getContactHelper().closeAlertPopUP();

  }
}
