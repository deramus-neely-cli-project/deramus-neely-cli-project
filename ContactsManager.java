package project;

import java.io.*;
import java.util.*;
import project.app.Contact;


public class ContactsManager {
  private List<Contact> contacts;
  private final String FILE_NAME = "contacts.txt";

  public ContactsManager() {
    contacts = new ArrayList<>();
    readContactsFromFile();
  }

  private void readContactsFromFile() {
    try {
      File file = new File(FILE_NAME);
      if (file.exists()) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
          String[] parts = line.split(",");
          contacts.add(new Contact(parts[0], parts[1]));
        }
        reader.close();
      }
    } catch (IOException e) {
      System.out.println("Error reading contacts file: " + e.getMessage());
    }
  }

  private void writeContactsToFile() {
    try {
      PrintWriter writer = new PrintWriter("contacts.txt", "UTF-8");
      for (Contact contact : contacts) {
        writer.println(contact.getName() + "|" + contact.getPhoneNumber());
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the contacts file.");
    }
  }
}
