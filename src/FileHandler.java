import java.io.*;
import java.util.*;

public class FileHandler {
  private final String FileName;

  public FileHandler(String fileName) {
    this.FileName = fileName;
  }

  public List<Contact> readContacts() {
    List<Contact> Contacts = new ArrayList<>();
    File File = new File(FileName);
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

  public void writeContacts(List<Contact> contacts) {
    File File = new File(FileName);
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
