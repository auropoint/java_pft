package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() {
    Configuration cfg1 = new Configuration();
    cfg1.configure("hibernateAddressbook.cfg.xml");

    try {
      sessionFactory = cfg1.buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testHbConnectionGroups() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    for (GroupData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
  }


  @Test
  public void testHbConnectionContacts() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    for (ContactData contact : result) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
  }


  @Test
  public void testHbConnectionContactsAndGroupsManyToManyLazy() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();

    for (ContactData contact : result) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }

    session.getTransaction().commit();
    session.close();
  }



  @Test
  public void testHbConnectionContactsAndGroupsManyToManyEager() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();

    for (ContactData contact : result) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }
  }


}
