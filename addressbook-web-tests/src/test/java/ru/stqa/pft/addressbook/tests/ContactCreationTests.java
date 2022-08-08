package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testContactCreation() {
    app.contact().create(new ContactData().withFirstname("test_name")
            .withLastname("test_surname").withGroup("test1"));
    app.goTo().gotoHomePage();

  }
}