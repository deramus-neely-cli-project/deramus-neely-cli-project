import java.util.*;

public class ContactsManager {

  private List<Contact> contacts;
  private FileHandler fileHandler;

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

  public boolean deleteContactByName(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        contacts.remove(contact);
        fileHandler.writeContacts(contacts);
        return true;
      }
    }
    return false;
  }

  public int showMenu() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("1. View contacts");
      System.out.println("2. Add a new contact");
      System.out.println("3. Search a contact by name");
      System.out.println("4. Delete an existing contact");
      System.out.println("5. Exit");
      System.out.print("Enter an option (1-5): ");
      int choice = scanner.nextInt();
      return choice;
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