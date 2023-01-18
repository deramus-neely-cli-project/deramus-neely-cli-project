import java.util.*;

public class ContactsManager {

  private final List<Contact> contacts;
  private final FileHandler fileHandler;

  public ContactsManager(String fileName) {
    fileHandler = new FileHandler(fileName);
    contacts = fileHandler.readContacts();
  }

  public void addContact(String name, String phone) {
    while (phone.length() < 10) {
      System.out.println("Invalid phone number. Please enter a valid phone number with at least 10 digits.");
      phone = new Scanner(System.in).nextLine();
    }
    Contact newContact = new Contact(name, phone);
    contacts.add(newContact);
    fileHandler.writeContacts(contacts);
  }

  public String getValidPhoneNumber(Scanner scanner) {
    String phoneNumber;
    do {
      System.out.println("Please enter a phone number with at least 10 digits:");
      phoneNumber = scanner.nextLine();
    } while (phoneNumber.length() < 10);
    return formatPhoneNumber(phoneNumber);
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