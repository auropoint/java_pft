package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    File photo = new File("src/test/resources/stru.png");
    app.contact().create(new ContactData().withFirstname("test_name")
            .withLastname("test_surname").withGroup("test1").withPhoto(photo));
    app.goTo().gotoHomePage();
    System.out.println("*********");
    System.out.println(System.getProperty("browser"));
    System.out.println("*********");

  }

  @Test
          (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println("***");
    System.out.println(currentDir.getAbsolutePath());
    System.out.println("***");
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }


}