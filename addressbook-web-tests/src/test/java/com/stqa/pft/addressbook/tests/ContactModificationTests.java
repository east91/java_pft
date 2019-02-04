package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("edited test1", "edited test2", "edited test3", "edited test4", "edited test5"));
    app.getContactHelper().submitUpdateContactCreation();
  }
}
