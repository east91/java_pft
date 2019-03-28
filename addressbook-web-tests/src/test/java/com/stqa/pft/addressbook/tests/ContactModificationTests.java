package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test      //need to add option to modify last contact. the problem is - can't find locator for now
  public void testContactModification() throws InterruptedException {
    app.goTo().gotoHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test2"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"edited test1", "edited test2", "edited test3", "edited test4", "edited test5", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitUpdateContactModification();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(before, after);

  }
}
