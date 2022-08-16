package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(String hibernateCfgFile) {
    Configuration cfg1 = new Configuration();
    cfg1.configure(hibernateCfgFile);
    // A SessionFactory is set up once for an application!
    sessionFactory = cfg1.buildSessionFactory();
  }

public Groups groups(){
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  List<GroupData> result = session.createQuery("from GroupData").list();
  session.getTransaction().commit();
  session.close();
  return new Groups(result);
}


  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
}
