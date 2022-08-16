package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class ContactHelper extends HelperBase {

  private Contacts contactCash = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      new Select(wd.findElement(By.name("new_group")))
              .selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactModification() {
    click(By.xpath("//img[contains(@title, 'Edit')]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
    contactCash = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[contains(@title, 'Edit')]"));
  }

  public void create(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
    contactCash = null;
  }

  public Contacts all() {
    if (contactCash != null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement k : elements) {
      int id = Integer.parseInt(k.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = k.findElement(By.xpath(".//td[3]")).getText();
      String lastname = k.findElement(By.xpath(".//td[2]")).getText();
      String[] phones = k.findElement(By.xpath(".//td[6]")).getText().split("\n");
      String allPhones = k.findElement(By.xpath(".//td[6]")).getText();
      contactCash.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withHomePhone(phones[0])
              .withMobilePhone(phones[1])
              .withWorkPhone(phones[2])
              .withAllPhones(allPhones));
    }
    return new Contacts(contactCash);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    or
//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    or
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    or
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }




}
