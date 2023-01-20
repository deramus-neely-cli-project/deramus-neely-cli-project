import java.io.*;
import java.util.*;


public class FileHandler {
  private final String FILE_NAME;

  // Constructor for FileHandler class
  public FileHandler(String fileName) {
    this.FILE_NAME = fileName;
  }

  // method to read contacts from file
  public List<Contact> readContacts() {
    List<Contact> Contacts = new ArrayList<>();
    File File = new File(FILE_NAME);
    if (File.exists()) {
      try (BufferedReader br = new BufferedReader(new FileReader(File))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] contactDetails = line.split(" ");
          String name = contactDetails[0];
          String phoneNumber = contactDetails[1];
          Contacts.add(new Contact(name, phoneNumber));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return Contacts;
  }

  // method to write contacts to file
  public void writeContacts(List<Contact> contacts) {
    File File = new File(FILE_NAME);
    // if file doesn't exist, create it
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(File))) {
      for (Contact contact : contacts) {
        bw.write(contact.getName() + " " + contact.getPhoneNumber());
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
