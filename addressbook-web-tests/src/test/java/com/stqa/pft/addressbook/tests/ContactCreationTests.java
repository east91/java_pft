package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test4", "test5"));
    app.getContactHelper().submitContactCreation();
  }
}
