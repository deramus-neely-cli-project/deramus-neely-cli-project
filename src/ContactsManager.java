import java.util.*;

public class ContactsManager {

  public static void print(String message) {
    System.out.println(message);
  }

  private final List<Contact> contacts;
  private final FileHandler fileHandler;

  public ContactsManager(String fileName) {
    fileHandler = new FileHandler(fileName);
    contacts = fileHandler.readContacts();
  }

  public void addContact(String name, String phone) {
    while (phone.length() < 10) {
      print("Invalid phone number. Please enter a valid phone number with at least 10 digits.");
      phone = new Scanner(System.in).nextLine();
    }
    phone = formatPhoneNumber(phone);
    Contact newContact = new Contact(name, phone);
    contacts.add(newContact);
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
    print("Name | Phone number");
    print("---------------");
    for (Contact contact : contacts) {
      print(contact.getName() + " | " + contact.getPhoneNumber());
    }
  }

  // formats the number to (xxx) xxx-xxxx
  public String formatPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() < 10) {
      return phoneNumber;
    }
    StringBuilder formattedNumber = new StringBuilder();
    formattedNumber.append("(");
    formattedNumber.append(phoneNumber.substring(0, 3));
    formattedNumber.append(") ");
    formattedNumber.append(phoneNumber.substring(3, 6));
    formattedNumber.append("-");
    formattedNumber.append(phoneNumber.substring(6));
    return formattedNumber.toString();
  }
}