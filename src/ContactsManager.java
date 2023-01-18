import java.util.*;

public class ContactsManager {

  private final List<Contact> contacts;
  private final FileHandler fileHandler;

  public ContactsManager(String fileName) {
    fileHandler = new FileHandler(fileName);
    contacts = fileHandler.readContacts();
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
    fileHandler.writeContacts(contacts);
  }

  public Contact searchContact(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        return contact;
      }
    }
    return null;
  }

  public void deleteContactByName(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        contacts.remove(contact);
        fileHandler.writeContacts(contacts);
        return;
      }
    }
  }

  // method to view all contacts
  public void viewContacts() {
    System.out.println("Name | Phone number");
    System.out.println("---------------");
    for (Contact contact : contacts) {
      System.out.println(contact.getName() + " | " + contact.getPhoneNumber());
    }
  }
}