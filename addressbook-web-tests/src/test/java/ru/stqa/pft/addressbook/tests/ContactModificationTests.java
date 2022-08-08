package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test (enabled = false)
  public void testContactModification() {
    app.goTo().gotoHomePage();

    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData().withFirstname("test_name")
              .withLastname("test_surname").withGroup("test1"));
    }
    app.goTo().gotoHomePage();

    app.contact().initContactModification();
    app.contact().fillContactForm(new ContactData().withFirstname("test_name")
            .withLastname("test_surname").withGroup(null), false);
    app.contact().submitContactModification();
    app.goTo().gotoHomePage();

  }
}