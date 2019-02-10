package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", null, null, null, null, "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}
