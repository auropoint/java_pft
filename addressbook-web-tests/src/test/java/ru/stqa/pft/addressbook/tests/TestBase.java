package ru.stqa.pft.addressbook.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", "chrome"));

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p) {
    logger.info("Stop test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  public void verifyGroupListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      logger.info("UI verification is ON");
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData()
                      .withId(g.getId())
                      .withName(g.getName()))
              .collect(Collectors.toSet())));
      logger.info("UI verification is done");
    }
    logger.info("UI verification is OFF");
  }

  public void verifyContactListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      logger.info("UI verification is ON");
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData()
                      .withId(g.getId())
                      .withFirstname(g.getFirstname())
                      .withLastname(g.getLastname())
                      .withHomePhone(g.getHomePhone())
                      .withMobilePhone(g.getMobilePhone())
                      .withWorkPhone(g.getWorkPhone()))
              .collect(Collectors.toSet())));
      logger.info("UI verification is done");
    }
    logger.info("UI verification is OFF");
  }


}