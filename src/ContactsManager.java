
import java.io.*;
import java.util.*;

public class ContactsManager {
  public List<Contact> contacts;
  public final String fileName = "Contacts.txt";

  public Contact searchContact(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        return contact;
      }
    }
    return null;
  }

  public boolean deleteContact(String contactNumber) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(contactNumber)) {
        contacts.remove(contact);
        return true;
      }
    }
    return false;
  }

  public void ContactManager() {
    contacts = new ArrayList<>();
    File file = new File(fileName);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    readContacts();
  }

  // method to read contacts from file and store in the contacts list
  public void readContacts() {
    File file = new File(fileName);
    if (file.exists()) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] contactDetails = line.split(" ");
          String name = contactDetails[0];
          String phoneNumber = contactDetails[1];
          contacts.add(new Contact(name, phoneNumber));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  // method to write the contacts list to the file
  public void writeContacts() {
    File file = new File(fileName);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (Contact contact : contacts) {
        bw.write(contact.getName() + " " + contact.getPhoneNumber());
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // method to show the main menu and return the user's choice
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

  // adds a new contact to the list
  public void addContact(String name2, String phone) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the name of the contact: ");
			String name = scanner.nextLine();
			System.out.print("Enter the phone number of the contact: ");
			String phoneNumber = scanner.nextLine();

			// check if a contact with the same name already exists
			for (Contact contact : contacts) {
			  if (contact.getName().equalsIgnoreCase(name)) {
			    System.out.println("A contact with the same name already exists.");
			    System.out.print("Do you want to overwrite it? (Yes/No): ");
			    String choice = scanner.nextLine();
			    if (!choice.equalsIgnoreCase("yes")) {
			      // if the user does not want to overwrite, return without adding the contact
			      return;
			    }
			    break;
			  }
			}

			// format the phone number as (XXX) XXX-XXXX
			phoneNumber = formatPhoneNumber(phoneNumber);

			// add the contact to the list
			contacts.add(new Contact(name, phoneNumber));
		}
    System.out.println("Contact added successfully.");
  }

  public String formatPhoneNumber(String phoneNumber) {
    return null;
  }
}
