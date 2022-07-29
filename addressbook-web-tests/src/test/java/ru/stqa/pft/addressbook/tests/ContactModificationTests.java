package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test_name",
              "test_surname", "test1"));
    }
    app.getNavigationHelper().gotoHomePage();

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_name",
            "test_surname", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();

  }
}