import java.util.*;

public class ContactsManager {

  // method to print messages without having to type System.out.println() every
  // time
  public static void print(String message) {
    System.out.println(message);
  }

  private final List<Contact> CONTACTS;
  private final FileHandler FILE_HANDLER;

  // Constructor for ContactsManager class
  public ContactsManager(String fileName) {
    FILE_HANDLER = new FileHandler(fileName);
    CONTACTS = FILE_HANDLER.readContacts();
  }

  // method to add a contact
  public void addContact(String name, String phone) {
    for (Contact contact : CONTACTS) {
      if (contact.getName().equalsIgnoreCase(name)) {
        System.out.println(name + " already exists. Please enter a new name.");
        return;
      }
    }
    phone = formatPhoneNumber(phone);
    Contact newContact = new Contact(name, phone);
    CONTACTS.add(newContact);
    FILE_HANDLER.writeContacts(CONTACTS);
  }


  // method to search for a contact
  public Contact searchContact(String name) {
    for (Contact contact : CONTACTS) {
      if (contact.getName().equalsIgnoreCase(name)) {
        return contact;
      }
    }
    return null;
  }

  // method to delete a contact
  public void deleteContactByName(String name) {
    for (Contact contact : CONTACTS) {
      if (contact.getName().equalsIgnoreCase(name)) {
        CONTACTS.remove(contact);
        FILE_HANDLER.writeContacts(CONTACTS);
        return;
      }
    }
  }

  // method to view all contacts
  public void viewContacts() {
    print("Name | Phone number");
    print("---------------");
    for (Contact contact : CONTACTS) {
      print(contact.getName() + " | " + contact.getPhoneNumber());
    }
  }

  // formats the number to (xxx) xxx-xxxx
  public String formatPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() < 10) {
      return phoneNumber;
    }
    return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
  }
}